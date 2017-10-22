import java.util.*;

/**
 * Class to initialize a Grid with randomly placed passengers and drivers
 * @author Avinash Sharma
 *
 */
public class Grid {
	private Object[][] map;
	private int size;
	private ArrayList<Passenger> passengers;
	private ArrayList<Driver> drivers;
	
	/**
	 * Constructs the size*size grid of Objects to store Passengers and Drivers
	 * @param size the size of the grid to initialize
	 */
	public Grid(int size) {
		this.size = size;
		map = new Object[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[i][j] = 0;
			}
		}
		passengers = new ArrayList<Passenger>();
		drivers = new ArrayList<Driver>();
	}
	
	/**
	 * Initializes a driver at a random location. If the random location already is occupied, it takes the
	 * spot next to it
	 * @param driver the driver to give the random location to
	 */
	public void generateRandomDriver(Driver driver) {
		int row = (int) Math.floor(Math.random() * this.size);
		int col = (int) Math.floor(Math.random() * this.size);
		if (map[row][col] instanceof Passenger || map[row][col] instanceof Driver) {
			if (row + 1 <= getSizeOfGrid() - 1) {
				map[row + 1][col] = driver;
				driver.setXCoordStart(row + 1);
				driver.setYCoordStart(col);
			}
			else if (col + 1 <= getSizeOfGrid() - 1){
				map[row][col + 1] = driver;
				driver.setXCoordStart(row);
				driver.setYCoordStart(col + 1);
			}
		}
		else {
			map[row][col] = driver;
			driver.setXCoordStart(row);
			driver.setYCoordStart(col);	
		}
	}
	
	/**
	 * Initializes a passenger at a random location. If the random location already is occupied, it takes the
	 * spot next to it
	 * @param pass the passenger to give the random location to
	 */
	public void generateRandomPassenger(Passenger pass) {
		int row = (int) Math.floor(Math.random() * this.size);
		int col = (int) Math.floor(Math.random() * this.size);
		if (map[row][col] instanceof Passenger || map[row][col] instanceof Driver) {
			if (row + 1 <= getSizeOfGrid() - 1) {
				map[row + 1][col] = pass;
				pass.setXCoordStart(row + 1);
				pass.setYCoordStart(col);
			}
			else if (col + 1 <= getSizeOfGrid() - 1){
				map[row][col + 1] = pass;
				pass.setXCoordStart(row);
				pass.setYCoordStart(col + 1);
			}
		}
		else {
			map[row][col] = pass;
			pass.setXCoordStart(row);
			pass.setYCoordStart(col);	
		}
	}
	
	/**
	 * Gets the size of the grid
	 * @return the size of the grid
	 */
	public int getSizeOfGrid() {
		return this.size;
	}
	
	/**
	 * Get the xCoord and yCoord of closest driver and move driver to passenger's destination
	 * @param driver the closest driver to the current passenger
	 */
	public void moveDriver(Driver driver) {
		int oldRow = driver.getXCoordStart();
		int oldCol = driver.getYCoordStart();
		System.out.println("Driver old coords: " + oldRow + ", " + oldCol);
		map[oldRow][oldCol] = 0;
		int newRow = driver.getXCoordEnd();
		int newCol = driver.getYCoordEnd();
		Driver newDriver = new Driver(driver.getName(), driver.getBalance(), driver.getCarTitle(), driver.getStatus(), driver.getRating(), driver.getNumRatings());
		newDriver.setXCoordStart(newRow);
		newDriver.setYCoordStart(newCol);
		System.out.println("New driver new coords: " + newRow + ", " + newCol);
		newDriver.setStatus(true);
		map[newRow][newCol] = newDriver;
	}
	
	/**
	 * Gets the xCoord and yCoord of the current passenger and move passenger to passenger's destination
	 * @param pass the current passenger
	 */
	public void movePassenger(Passenger pass) {
		int oldRow = pass.getXCoordStart();
		int oldCol = pass.getYCoordStart();
		System.out.println("Old coords: " + oldRow + ", " + oldCol);
		map[oldRow][oldCol] = 0;
		int newRow = pass.getXCoordDest();
		int newCol = pass.getYCoordDest();
		Passenger newPass = new Passenger(pass.getName(), pass.getCustBalance());
		newPass.setXCoordDest(newRow);
		newPass.setYCoordDest(newCol);
		System.out.println("New coords: " + newRow + ", " + newCol);
		map[newRow][newCol] = newPass;
	}
	
	/**
	 * Adds all Passengers in the Grid to an ArrayList of Passengers
	 */
	public void addPassengers() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] instanceof Passenger) {
					passengers.add((Passenger)map[i][j]);
				}
			}
		}
	}
	
	/**
	 * Adds all Drivers in the Grid to an ArrayList of Drivers
	 */
	public void addDrivers() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] instanceof Driver) {
					drivers.add((Driver)map[i][j]);
				}
			}
		}
	}
	
	/**
	 * Gets the ArrayList of Passengers
	 * @return the ArrayList of Passengers
	 */
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}
	
	/**
	 * Gets the ArrayList of Drivers
	 * @return the ArrayList of Drivers
	 */
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}
	
	/**
	 * Prints the grid's contents
	 */
	public void printGrid() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Stores the grid into a String to be able to write it to a file
	 * @return the grid in String version
	 */
	public String stringGrid() {
		String retStr = "";
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				retStr += map[i][j] + "  ";
			}
			retStr += "\n";
		}
		retStr += "\n";
		return retStr;
	}
	
}
