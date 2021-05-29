package clientLayer;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import entity.Type;
import entity.TypeServiceException;
import entity.Watch;
import service.TypeService;
import service.WatchService;
import service.Implementation.TypeServiceImpl;
import service.Implementation.WatchServiceImpl;

public class ClientApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		boolean flag = true;
		TypeService type = new TypeServiceImpl();
		WatchService watch = new WatchServiceImpl();

		// entity
		// client -> service
		// service -> dao
		// dao -> utility

		do {

			displayMenu();
			byte menu = sc.nextByte();
			sc.nextLine();
			switch (menu) {
			case 1:

				Type types = askDetails();
				try {
					type.addType(types);
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			case 2:

				int typeId = askTypeId();
				try {
					boolean check = type.isValidTypeId(typeId);
					if (!check) {
						flag = false;
						break;
					}
					watch.addWatch(typeId);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 3:
				List<Watch> watches = null;
				try {
					watches = watch.getAllWatches();
					List<Watch> sortedWatches = watch.sortWatches(watches);
					displayWatches(sortedWatches);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;

			case 4:
				flag = false;
				System.out.println("Application exited");
				break;

			default:
				System.out.println("Choose a valid option");
				break;
			}

		} while (flag);

	}
	
	private static void displayWatches(List<Watch> sortedWatches) {
		for (Watch watch : sortedWatches) {
			System.out.println("Watch id : " + watch.getId() + ", Model Number : " + watch.getModelNumber()
					+ ", Price : " + watch.getPrice() + ", Type Id : " + watch.getTypeId());
		}

	}

	private static Type askDetails() {
		return new Type(askTypeId(), askTypeName());
	}

	private static String askTypeName() {
		System.out.println("Enter the type name : ");
		return sc.nextLine();
	}

	private static int askTypeId() {
		System.out.println("Enter the type id : ");
		int id = sc.nextInt();
		sc.nextLine();
		return id;
	}

	private static void displayMenu() {
		System.out.println("<----------Govind's watch program------------->");
		System.out.println("1. Add Type");
		System.out.println("2. Add Watch");
		System.out.println("3. Sort All Watches Based On Price ");
		System.out.println("4. Exit Application ");
		System.out.println("<----------------------->");
		System.out.println("Enter your preferred choice");
	}

}
