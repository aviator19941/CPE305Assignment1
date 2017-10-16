import java.util.*;

public class Trip {
	private double rate;
	
	public Trip(double rate) {
		this.rate = rate;
	}
	
	public double getRate() {
		return rate;
	}
	
	public double distanceFromDriverToPass(Driver driver, Passenger pass) {
		int xDiff = driver.getXCoord() - pass.getXCoord();
		int yDiff = driver.getYCoord() - pass.getYCoord();
		return Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
	}
	
	public double distanceFromPassToDest(Passenger pass) {
		int xDiff = pass.getXCoordDest() - pass.getXCoord();
		int yDiff = pass.getYCoordDest() - pass.getYCoord();
		return Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
	}
	
	// 3 min per unit
	public int estimatedTimeArrival(Driver driver, Passenger pass) {
		return (int)this.distanceFromDriverToPass(driver, pass) * 3;
	}
	
	// get rate from input file
	public double calculateFare(Passenger pass) {
		return this.distanceFromPassToDest(pass) * rate;
	}
	
}
