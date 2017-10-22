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
	
	public int getSizeOfGrid() {
		return this.size;
	}
	
	// get xCoord and yCoord of closest driver and move driver to passenger's destination
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
	
	// get xCoord and yCoord of passenger and move passenger to passenger's destination
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
