import java.util.*;

public class Grid {
	private Object[][] map;
	private int size;
	private ArrayList<Passenger> passengers;
	private ArrayList<Driver> drivers;
	
	// Change to 300*300 grid
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
	
	public void generateRandomDriver(Driver driver) {
		int row = (int) Math.floor(Math.random() * this.size);
		int col = (int) Math.floor(Math.random() * this.size);
		map[row][col] = driver;
		driver.setXCoordStart(row);
		driver.setYCoordStart(col);
	}
	
	public void generateRandomPassenger(Passenger pass) {
		int row = (int) Math.floor(Math.random() * this.size);
		int col = (int) Math.floor(Math.random() * this.size);
		map[row][col] = pass;
		pass.setXCoordStart(row);
		pass.setYCoordStart(col);
	}
	
	public int getSizeOfGrid() {
		return this.size;
	}
	
	// get xCoord and yCoord of closest driver and move driver (1) to passenger's destination
	public void moveDriver(Driver driver) {
		int oldRow = driver.getXCoordStart();
		int oldCol = driver.getYCoordStart();
		map[oldRow][oldCol] = 0;
		int newRow = driver.getXCoordEnd();
		int newCol = driver.getYCoordEnd();
		map[newRow][newCol] = driver;
	}
	
	// get xCoord and yCoord of passenger and move passenger (2) to passenger's destination
	public void movePassenger(Passenger pass) {
		int oldRow = pass.getXCoordStart();
		int oldCol = pass.getYCoordStart();
		System.out.println("Old coords: " + oldRow + ", " + oldCol);
		map[oldRow][oldCol] = 0;
		int newRow = pass.getXCoordDest();
		int newCol = pass.getYCoordDest();
		System.out.println("New coords: " + newRow + ", " + newCol);
		map[newRow][newCol] = pass;
	}
	
	public void addPassengers() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] instanceof Passenger) {
					passengers.add((Passenger)map[i][j]);
				}
			}
		}
	}
	
	public void addDrivers() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] instanceof Driver) {
					drivers.add((Driver)map[i][j]);
				}
			}
		}
	}
	
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}
	
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}
	
	public void printGrid() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
