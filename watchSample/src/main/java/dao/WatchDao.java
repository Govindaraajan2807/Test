package dao;

import java.sql.SQLException;
import java.util.List;
import entity.Watch;

public interface WatchDao {
	void addWatch(int id, String modelNumber, float price,int typeId) throws SQLException;
	List<Watch>getAllWatches() throws SQLException;

}
