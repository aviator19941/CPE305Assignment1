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
			
			Grid grid = new Grid(300);
			
			Passenger pass1 = new Passenger("P1", passBalance);
			Passenger pass2 = new Passenger("P2", passBalance);
			Passenger pass3 = new Passenger("P3", passBalance);
			Passenger pass4 = new Passenger("P4", passBalance);
			Passenger pass5 = new Passenger("P5", passBalance);

			grid.generateRandomPassenger(pass1);
			grid.generateRandomPassenger(pass2);
			grid.generateRandomPassenger(pass3);
			grid.generateRandomPassenger(pass4);
			grid.generateRandomPassenger(pass5);
			
			Driver driver1 = new Driver("D1", driverBalance, "Sedan", true, 3.0, 1);
			Driver driver2 = new Driver("D2", driverBalance, "UberX", true, 4.0, 1);
			Driver driver3 = new Driver("D3", driverBalance, "Toyota", true, 5.0, 1);
			Driver driver4 = new Driver("D4", driverBalance, "Tesla", true, 4.75, 1);
			Driver driver5 = new Driver("D5", driverBalance, "Volvo", true, 3.0, 1);
			Driver driver6 = new Driver("D6", driverBalance, "Ford", true, 3.5, 1);
			Driver driver7 = new Driver("D7", driverBalance, "BMW", true, 0.0, 0);
			Driver driver8 = new Driver("D8", driverBalance, "Lamborghini", true, 0.0, 1);
			Driver driver9 = new Driver("D9", driverBalance, "Ferrari", true, 4.0, 1);
			Driver driver10 = new Driver("D10", driverBalance, "Sedan", true, 4.0, 1);
			
			grid.generateRandomDriver(driver1);
			grid.generateRandomDriver(driver2);
			grid.generateRandomDriver(driver3);
			grid.generateRandomDriver(driver4);
			grid.generateRandomDriver(driver5);
			grid.generateRandomDriver(driver6);
			grid.generateRandomDriver(driver7);
			grid.generateRandomDriver(driver8);
			grid.generateRandomDriver(driver9);
			grid.generateRandomDriver(driver10);
			
			grid.printGrid();
			grid.addPassengers();
			grid.addDrivers();
			ArrayList<Passenger> passengersList = grid.getPassengers();
			ArrayList<Driver> driversList = grid.getDrivers();
			File fout = new File("trips.json");
			FileWriter fw = new FileWriter(fout);
			for (int i = 0; i < passengersList.size(); i++) {
				testTrips(grid, passengersList, driversList, (int) Math.floor(Math.random() * grid.getSizeOfGrid()), 
						(int) Math.floor(Math.random() * grid.getSizeOfGrid()), passengersList.get(i), rate, fw, i);
				grid.addDrivers();
				
			}
			PrintWriter writer = new PrintWriter("finalOutput.txt", "UTF-8");
			writer.println("Number of successful trips: " + successCount);
			writer.println("Number of cancelled trips: " + cancelledCount);
			writer.print(grid.stringGrid());
			writer.println("Total number of transactions: " + numTransactions);
			for (int i = 0; i < driversList.size(); i++) {
				driverBalance = driversList.get(i).getBalance();
				writer.printf(driversList.get(i).getName() + " balance is: $%.2f\n", driverBalance);
			}
			
			for (int i = 0; i < passengersList.size(); i++) {
				writer.printf(passengersList.get(i).getName() + " balance is: $%.2f\n", passengersList.get(i).getCustBalance());
			}
			
			for (int i = 0; i < driversList.size(); i++) {
				writer.println(driversList.get(i).getName() + " ratings are: " + driversList.get(i).getRating());
			}
			
			fw.close();
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addDriversToQueue(PriorityQueue<Driver> pQueue, ArrayList<Driver> driversList) {
		for (int i = 0; i < driversList.size(); i++) {
			driversList.get(i).addDriverToQueue(pQueue, driversList.get(i));
		}
	}
	
	public static ArrayList<Trip> makeListOfTrips(ArrayList<Driver> driversList, double rate, Passenger pass) {
		ArrayList<Trip> tripsList = new ArrayList<Trip>();
		for (int i = 0; i < driversList.size(); i++) {
			System.out.println("driversList at i is: " + driversList.get(i) + " Pass is: " + pass);
			tripsList.add(new Trip(rate, driversList.get(i), pass));
		}
		return tripsList;
	}
	private static int successCount = 0;
	private static int cancelledCount = 0;
	private static int numTransactions = 0;
	private static int numRatings = 0;
	public static void testTrips(Grid grid, ArrayList<Passenger> passengersList, ArrayList<Driver> driversList, 
			int xCoordDest, int yCoordDest, Passenger pass, double rate, FileWriter fw, int j) {
		try {
			
			pass.enterDestination(grid, xCoordDest, yCoordDest);

			ArrayList<Trip> tripsList = makeListOfTrips(driversList, rate, pass);
			for (int i = 0; i < tripsList.size(); i++) {
				driversList.get(i).setTrip(tripsList.get(i));
			}
			
			System.out.println("Start is: " + pass.getXCoordStart() + ", " + pass.getYCoordStart());
			
			for (int i = 0; i < tripsList.size(); i++) {
				System.out.println("i is: " + tripsList.get(i).getDriver().getName() + " " + tripsList.get(i).distanceFromDriverToPass());
			}
			Trip minTrip = null;
			for (int i = 1; i < tripsList.size(); i++) {
				minTrip = tripsList.get(0);
				if (minTrip.distanceFromDriverToPass() > tripsList.get(i).distanceFromDriverToPass()) {
					minTrip = tripsList.get(i);
				}
			}
			
			PriorityQueue<Driver> pQueue = new PriorityQueue<Driver>();
			
			for (int i = 0; i < driversList.size(); i++) {
				driversList.get(i).addDriverToQueue(pQueue, driversList.get(i));
			}
			
			System.out.println("frontOfQueue is: " + pQueue.peek());
			Driver frontOfQueue = pQueue.peek();
			
			double driverBalance = 0;
			Transaction transaction1 = new Transaction(frontOfQueue, pass, minTrip);
			transaction1.deductPassengerBalance(); // driver status is true or false depending on custBalance
			numTransactions++;
			transaction1.addToDriverBalance();
			
			fw.write("{\n");
			fw.write("\t\"fare\": " + transaction1.getFare() + ",\n");
			fw.write("\t\"start\": [" + pass.getXCoordStart() + ", " + pass.getYCoordStart() + "],\n");
			fw.write("\t\"end\": [" + pass.getXCoordDest() + ", " + pass.getYCoordDest() + "],\n");
			
			if (transaction1.checkPassengerBalance()) {
				System.out.println("Driver is on way...");
				System.out.printf("ETA: %.2f mins\n", minTrip.estimatedTimeArrival());
				
				// Use timer for ETA
				System.out.println("Driver has arrived.");
				
				System.out.println("Ride started.");
				frontOfQueue.setXCoordEnd(pass.getXCoordDest());
				frontOfQueue.setYCoordEnd(pass.getYCoordDest());
				grid.movePassenger(pass);
				grid.moveDriver(frontOfQueue);
				
				// the new location of drivers
				for (int i = 0; i < driversList.size(); i++) {
					if (frontOfQueue.getXCoordStart() == driversList.get(i).getXCoordStart() && frontOfQueue.getYCoordStart() == driversList.get(i).getYCoordStart()) {
						driversList.get(i).setXCoordStart(frontOfQueue.getXCoordEnd());
						driversList.get(i).setYCoordStart(frontOfQueue.getYCoordEnd());
					}
					fw.write("\t\"driverLocation" + i + "\": [" + driversList.get(i).getXCoordStart() + ", " + driversList.get(i).getYCoordStart() + "],\n");
				}
				for (int i = 0; i < driversList.size(); i++) {
					driverBalance = driversList.get(i).getBalance();
					fw.write("\t\"" + driversList.get(i).getName() + "Balance" + "\": " + driverBalance + ",\n");
				}
				
				for (int i = 0; i < passengersList.size(); i++) {
					fw.write("\t\"" + passengersList.get(i).getName() + "Balance\": " + passengersList.get(i).getCustBalance() + ",\n");
				}
				
				grid.printGrid();
				System.out.println("Ride is finished");
			
				pass.enterRating(frontOfQueue, 4.47);
				System.out.println("New rating is: " + frontOfQueue.getRating());
				
				for (int i = 0; i < driversList.size(); i++) {
					if (driversList.get(i).getName().equals(frontOfQueue.getName())) {
						driversList.get(i).setRating(frontOfQueue.getRating());
					}
					double rating = driversList.get(i).getRating();

					fw.write("\t\"" + driversList.get(i).getName() + "Rating\": " + rating + ",\n");
	
				}
	
				fw.write("\t\"tripStatus\": \"success\"\n");
				successCount++;
			}
			else {
				fw.write("\t\"tripStatus\": \"cancelled\"\n");
				cancelledCount++;
			}
			
			if (j < passengersList.size() - 1) {
				fw.write("},\n");
			}
			else if (j == passengersList.size() - 1){
				fw.write("}");
			}
			
			tripsList.clear();
			pQueue.clear();
			driversList.clear();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
