package service;

import java.sql.SQLException;
import exception.TypeServiceException;

import entity.Type;

public interface TypeService {

	boolean addType(Type type) throws SQLException, TypeServiceException;

	boolean isValidTypeId(int typeId) throws SQLException, TypeServiceException;
}
