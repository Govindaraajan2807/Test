package service;

import java.sql.SQLException;
import java.util.List;

import entity.Watch;

public interface WatchService {
	boolean addWatch(int typeId) throws SQLException;

	List<Watch> getAllWatches() throws SQLException;

	List<Watch> sortWatches(List<Watch> watches) throws SQLException;
}
