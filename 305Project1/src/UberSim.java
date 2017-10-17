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
			grid.generateRandomPassenger(pass1);
			Driver driver1 = new Driver("D1", driverBalance, "Sedan", true, 0.0);
			Driver driver2 = new Driver("D2", driverBalance, "UberX", true, 4.5);
			grid.generateRandomDriver(driver1);
			grid.generateRandomDriver(driver2);
			
			grid.printGrid();
			pass1.enterDestination(4, 1);
			
			Trip trip1 = new Trip(rate, driver1, pass1);
			Trip trip2 = new Trip(rate, driver2, pass1);
			
			driver1.setTrip(trip1);
			driver2.setTrip(trip2);
			
			System.out.println(trip1.distanceFromDriverToPass());
			System.out.println(trip2.distanceFromDriverToPass());
			
			PriorityQueue<Driver> pQueue = new PriorityQueue<Driver>();
			
			pQueue.add(driver1);
			pQueue.add(driver2);
			driver2.decline();
			/*int count = 1;
			while (!pQueue.isEmpty()) {
				System.out.println(pQueue.peek().getStatus());
				System.out.println("Dequeued " + count + " ---> " + pQueue.remove());
				count++;
			}*/
			// Look at #10 and #14 of requirements
			System.out.println(pQueue.peek());
			Driver frontOfQueue = pQueue.peek();

			Transaction transaction1 = new Transaction(frontOfQueue, pass1, trip1);
			transaction1.deductPassengerBalance();
			transaction1.addToDriverBalance();
			
			System.out.println("Driver is on way...");
			System.out.println("ETA: " + trip1.estimatedTimeArrival() + " mins");
			
			// Use timer for ETA
			System.out.println("Driver has arrived.");
			
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
