package dao;

import java.sql.SQLException;

import entity.Type;
import exception.TypeDaoException;

public interface TypeDao {


	boolean addWatchType(Type type) throws SQLException, TypeDaoException;

	boolean isValidTypeId(int typeId) throws SQLException;

}
