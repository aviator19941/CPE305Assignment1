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
	private int numRatings;
	private Trip trip;
	
	public Driver(String name, double balance, String carTitle, boolean status, double rating, int numRatings) {
		this.name = name;
		this.balance = balance;
		this.carTitle = carTitle;
		this.status = status;
		this.rating = rating;
		this.numRatings = numRatings;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
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
	
	public void setXCoordStart(int xCoordStart) {
		this.xCoordStart = xCoordStart;
	}
	
	public int getXCoordStart() {
		return xCoordStart;
	}
	
	public void setYCoordStart(int yCoordStart) {
		this.yCoordStart = yCoordStart;
	}
	
	public int getYCoordStart() {
		return yCoordStart;
	}
	
	public int getXCoordEnd() {
		return xCoordEnd;
	}
	
	public void setXCoordEnd(int xCoordEnd) {
		this.xCoordEnd = xCoordEnd;
	}
	
	public int getYCoordEnd() {
		return yCoordEnd;
	}
	
	public void setYCoordEnd(int yCoordEnd) {
		this.yCoordEnd = yCoordEnd;
	}
	
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	public int getNumRatings() {
		return this.numRatings;
	}
	
	public int compareTo(Driver other) {
		if (this.trip.distanceFromDriverToPass() == other.trip.distanceFromDriverToPass()) {
			if (this.getRating() < other.getRating()) {
				return 1;
			}
			else if (this.getRating() > other.getRating()) {

				return -1;
			}
			else {
				return 0;
			}
		}
		else if (this.trip.distanceFromDriverToPass() > other.trip.distanceFromDriverToPass()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public void addDriverToQueue(PriorityQueue<Driver> drivers, Driver driver) {
		if (driver.status == false) {
			System.out.println("Busy! Cannot add to queue");
		}
		else {
			drivers.add(driver);
		}
	}
	
	public String toString() {
		//return "Name: " + name + " balance: " + balance + " carTitle: " + carTitle + " status: " + status + " rating: " + rating;
		return name;
	}
	
	public void decline() {
		this.status = false;
	}
	
	
}
