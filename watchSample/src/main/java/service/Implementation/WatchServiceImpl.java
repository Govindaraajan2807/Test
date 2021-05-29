package service.Implementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import entity.Watch;
import service.WatchService;
import dao.WatchDao;
import dao.Implementation.WatchDaoImpl;

public class WatchServiceImpl implements WatchService {
	private static Scanner sc = new Scanner(System.in);
	WatchDao watch = new WatchDaoImpl();

	public boolean addWatch(int typeId) throws SQLException {
		System.out.println("Enter the below details : ");
		System.out.print("Enter the Id : ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter the model number : ");
		String modelNumber = sc.nextLine();

		System.out.println("Enter the price : ");
		float price = sc.nextFloat();

		watch.addWatch(id, modelNumber, price,typeId);
		return true;

	}
	
	public List<Watch> getAllWatches() throws SQLException{
		return watch.getAllWatches();
	}
	
	public List<Watch> sortWatches(List<Watch>watches) throws SQLException{
		Collections.sort(watches, new PriceComparator());
		return new ArrayList<Watch>(watches);
		
	}
	
	
	class PriceComparator implements Comparator<Watch>{
		
		public int compare(Watch w1,Watch w2) {
			
			if(w1.getPrice() > w2.getPrice())
				return 1;
			else if(w1.getPrice() < w2.getPrice())
				return -1;
			else
				return 2;
		}
	}

}
