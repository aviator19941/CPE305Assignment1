import java.util.*;

public class Driver {
	private String name;
	private double balance;
	private String carTitle;
	private boolean status;
	private int xCoordStart;
	private int yCoordStart;
	private double rating;
	private int numRatings;
	private PriorityQueue<Driver> pQueue;
	
	public Driver(String name, double balance, String carTitle, boolean status, int xCoord, int yCoord, double rating, int numRatings) {
		this.name = name;
		this.balance = balance;
		this.carTitle = carTitle;
		this.status = status;
		this.xCoordStart = xCoord;
		this.yCoordStart = yCoord;
		rating = 0.0;
		this.numRatings = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public double balance() {
		return balance;
	}
	
	public String getCarTitle() {
		return carTitle;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public double getRating() {
		return rating;
	}
	
	public int getNumRatings() {
		return numRatings;
	}
	
	public boolean isAvailableDriver() {
		return status == true;
	}
	
	public int getXCoord() {
		return xCoordStart;
	}
	
	public int getYCoord() {
		return yCoordStart;
	}
	
	// check distance from passenger
	public void acceptRequest(Passenger p, Grid grid, Trip trip) {
		if (p.sendRequest(grid) && this.isAvailableDriver()) {
			pQueue.add(this);
		}
	}
	
	public void declineRequest(Passenger p) {
		status = false;
	}
	
	public PriorityQueue<Driver> getDrivers() {
		return this.pQueue;
	}
	
}
