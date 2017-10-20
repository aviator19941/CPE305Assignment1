import java.util.*;
import java.io.*;

public class UberSim {
	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			ArrayList<String> list = new ArrayList<String>();
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			fileReader.close();
			double driverBalance = Double.parseDouble(list.get(0));
			double passBalance = Double.parseDouble(list.get(1));
			double rate = Double.parseDouble(list.get(2));
			
			Grid grid = new Grid(5);
			
			Passenger pass1 = new Passenger("P1", passBalance);
			Passenger pass2 = new Passenger("P2", passBalance);
			grid.generateRandomPassenger(pass1);
			grid.generateRandomPassenger(pass2);
			Driver driver1 = new Driver("D1", driverBalance, "Sedan", true, 0.0, 0);
			Driver driver2 = new Driver("D2", driverBalance, "UberX", true, 4.5, 1);
			grid.generateRandomDriver(driver1);
			grid.generateRandomDriver(driver2);
			
			grid.printGrid();
			grid.addPassengers();
			grid.addDrivers();
			ArrayList<Passenger> passengersList = grid.getPassengers();
			ArrayList<Driver> driversList = grid.getDrivers();

			// create random destinations
			pass1.enterDestination(grid, 4, 1);
			
			Trip trip1 = new Trip(rate, driver1, pass1);
			Trip trip2 = new Trip(rate, driver2, pass1);
			
			driver1.setTrip(trip1);
			driver2.setTrip(trip2);
			
			System.out.println(trip1.distanceFromDriverToPass());
			System.out.println(trip2.distanceFromDriverToPass());
			
			PriorityQueue<Driver> pQueue = new PriorityQueue<Driver>();
			
			driver1.addDriverToQueue(pQueue, driver1);
			driver2.decline();
			driver2.addDriverToQueue(pQueue, driver2);
			
			// Look at #10 and #14 of requirements
			System.out.println(pQueue.peek());
			Driver frontOfQueue = pQueue.peek();

			Transaction transaction1 = new Transaction(frontOfQueue, pass1, trip1);
			transaction1.deductPassengerBalance(); // driver status is true or false depending on custBalance
			transaction1.addToDriverBalance();
			
			System.out.println("Driver is on way...");
			System.out.println("ETA: " + trip1.estimatedTimeArrival() + " mins");
			
			// Use timer for ETA
			System.out.println("Driver has arrived.");
			
			System.out.println("Ride started.");
			frontOfQueue.setXCoordEnd(pass1.getXCoordDest());
			frontOfQueue.setYCoordEnd(pass1.getYCoordDest());
			grid.movePassenger(pass1);
			grid.moveDriver(frontOfQueue);
			grid.printGrid();
			System.out.println("Ride is finished");
			
			frontOfQueue.setRating(pass1.enterRating(frontOfQueue, 5.0));
			System.out.println("New rating is: " + frontOfQueue.getRating());
			
			/*Trip trip3 = new Trip(rate, driver1, pass2);
			Trip trip4 = new Trip(rate, driver2, pass2);
			
			driver1.setTrip(trip3);
			driver2.setTrip(trip4);
			
			System.out.println(trip3.distanceFromDriverToPass());
			System.out.println(trip4.distanceFromDriverToPass());
			System.out.println(pQueue.peek());*/
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//public static void testTrip(PriorityQueue pQueue, )
	
}
