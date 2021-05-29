package dao.Implementation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.WatchDao;
import entity.Watch;
import utility.DbConnection;

public class WatchDaoImpl implements WatchDao {

	DbConnection db = new DbConnection();

	public void addWatch(int id, String modelNumber, float price, int typeId) throws SQLException {
		Connection con = null;
		Statement st = null;

		try {
			con = db.getConnection();
			st = con.createStatement();
			String query = "INSERT INTO watch VALUES(" + id + ", '" + modelNumber + "'," + price + "," + typeId + ")";
			st.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SQLException();
		} finally {
			db.closeConnection(con);
			st.close();
		}
	}

	public List<Watch> getAllWatches() throws SQLException {
		return null;

	}
}
