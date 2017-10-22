import java.util.*;

public class Trip {
	private double rate;
	private Driver driver;
	private Passenger pass;
	
	public Trip(double rate, Driver driver, Passenger pass) {
		this.rate = rate;
		this.driver = driver;
		this.pass = pass;
	}
	
	public double getRate() {
		return rate;
	}
	
	public Driver getDriver() {
		return driver;
	}
	
	public Passenger getPassenger() {
		return pass;
	}
	
	public double distanceFromDriverToPass() {
		int xDiff = Math.abs(driver.getXCoordStart() - pass.getXCoordStart());
		int yDiff = Math.abs(driver.getYCoordStart() - pass.getYCoordStart());
		return Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
	}
	
	public double distanceFromPassToDest() {
		int xDiff = Math.abs(pass.getXCoordDest() - pass.getXCoordStart());
		int yDiff = Math.abs(pass.getYCoordDest() - pass.getYCoordStart());
		return Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
	}
	
	// 3 min per unit
	public double estimatedTimeArrival() {
		return this.distanceFromDriverToPass() * 1;
	}
	
	// get rate from input file
	public double calculateFare() {
		return this.distanceFromPassToDest() * rate;
	}
	
}
