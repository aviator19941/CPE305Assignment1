
public class Trip {
	
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
	
}
