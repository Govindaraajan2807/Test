package service;

import java.sql.SQLException;

import entity.Type;
import entity.TypeServiceException;

public interface TypeService {

	boolean addType(Type type) throws SQLException, TypeServiceException;

	boolean isValidTypeId(int typeId) throws SQLException, TypeServiceException;
}
