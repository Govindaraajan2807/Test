package dao.Implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.TypeDao;
import entity.Type;
import exception.TypeDaoException;
import utility.DbConnection;


public class TypeDaoImpl implements TypeDao {

	DbConnection db = new DbConnection();

	public boolean addWatchType(Type type) throws SQLException,TypeDaoException {
		Connection con = null;
		Statement st = null;

		try {
			con = db.getConnection();
			st = con.createStatement();
			String query = "INSERT INTO type VALUES(" + type.getTypeId() + ", '" + type.getName() + "' )";
			int result = st.executeUpdate(query);

			if (result != 1) {
				throw new TypeDaoException("not inserted successfully");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SQLException();
		} finally {
			db.closeConnection(con);
			st.close();
		}
		return false;
	}

	public boolean isValidTypeId(int typeId) throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = db.getConnection();
			st = con.createStatement();
			String query = "SELECT * FROM type WHERE type_id = " + typeId + " ";
			rs = st.executeQuery(query);

			if (!rs.next()) {
				System.out.println("type does not exist");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return true;
	}

}

//entity,client,service,dao,
