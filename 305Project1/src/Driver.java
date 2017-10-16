import java.util.*;

public class Driver implements Comparable<Driver>{
	private String name;
	private double balance;
	private String carTitle;
	private boolean status;
	private int xCoordStart;
	private int yCoordStart;
	private int xCoordEnd;
	private int yCoordEnd;
	private double rating;
	private PriorityQueue<Driver> pQueue;
	
	public Driver(String name, double balance, String carTitle, boolean status, double rating) {
		this.name = name;
		this.balance = balance;
		this.carTitle = carTitle;
		this.status = status;
		rating = 0.0;
	}
	
	public String getName() {
		return name;
	}
	
	public double balance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getCarTitle() {
		return carTitle;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
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
	
	public void setXCoordEnd(int xCoordEnd) {
		this.xCoordEnd = xCoordEnd;
	}
	
	public void setYCoordEnd(int yCoordEnd) {
		this.yCoordEnd = yCoordEnd;
	}
	
	// check distance from passenger
	public void addDriverToQueue(Passenger p, Grid grid, Trip trip) {
		if (p.isValidDest(grid) && this.isAvailableDriver()) {
			pQueue.add(this);
		}
	}
	
	public PriorityQueue<Driver> getDrivers() {
		return this.pQueue;
	}
	
}
