package service.Implementation;

import service.TypeService;

import java.sql.SQLException;

import dao.TypeDao;
import dao.Implementation.TypeDaoImpl;
import entity.Type;
import entity.TypeServiceException;
import exception.TypeDaoException;

public class TypeServiceImpl implements TypeService {

	TypeDao typeObj = new TypeDaoImpl();
	public boolean addType(Type type) throws SQLException, TypeServiceException{
		try {
			typeObj.addWatchType(type);
			return true;
		}
		catch(SQLException e){
			throw new SQLException();
		}
		catch(TypeDaoException e) {
			throw new TypeServiceException();
		}
	}
	
	public boolean isValidTypeId(int typeId) throws SQLException, TypeServiceException{
		boolean value = false;
		try {
			value = typeObj.isValidTypeId(typeId);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}



}
