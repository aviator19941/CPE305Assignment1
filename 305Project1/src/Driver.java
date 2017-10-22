import java.util.*;
/**
 * A class for producing Drivers
 * @author Avinash Sharma
 *
 */
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
	private static int numRatings = 0;
	private Trip trip;
	
	/**
	 * Constructs a Driver object that can drive a passenger
	 * @param name the name of the driver
	 * @param balance the dollar amount the driver has earned overall
	 * @param carTitle the name of the driver's car
	 * @param status the status of the driver (true if available, false if not available)
	 * @param rating the rating of the driver
	 * @param numRatings the number of ratings the driver has
	 */
	public Driver(String name, double balance, String carTitle, boolean status, double rating, int numRatings) {
		this.name = name;
		this.balance = balance;
		this.carTitle = carTitle;
		this.status = status;
		this.rating = rating;
		this.numRatings = numRatings;
	}
	
	/**
	 * Gets the name of the driver
	 * @return name of the driver
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the number of ratings to the driver's current number of ratings
	 * @param driver the driver to set the number of ratings for
	 */
	public static void setNumRatingsToCurrent(Driver driver) {
		numRatings = driver.getNumRatings();
	}
	
	/**
	 * Gets the balance of the driver
	 * @return the balance of the driver
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Sets the balance of the driver
	 * @param balance the new balance of the driver
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/**
	 * Gets the name of the driver's car
	 * @return name of the driver's car
	 */
	public String getCarTitle() {
		return carTitle;
	}
	
	/**
	 * Gets the status of the driver
	 * @return the status of the driver (true/available or false/busy)
	 */
	public boolean getStatus() {
		return status;
	}
	
	/**
	 * Sets the status of the driver
	 * @param status status of the driver to set to true/available or false/busy
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	/**
	 * Gets the rating of the driver
	 * @return the rating of the driver
	 */
	public double getRating() {
		return rating;
	}
	
	/**
	 * Sets the rating of the driver
	 * @param rating the new rating of the driver to set to
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	/**
	 * Increments the numRatings field by 1
	 */
	public void incNumRatings() {
		this.numRatings++;
	}
	
	/**
	 * Sets the xCoordStart position of the driver to the new xCoordStart
	 * @param xCoordStart the xCoord start position of the driver's trip
	 */
	public void setXCoordStart(int xCoordStart) {
		this.xCoordStart = xCoordStart;
	}
	
	/**
	 * Gets the xCoordStart position of the driver
	 * @return xCoordStart position of the driver
	 */
	public int getXCoordStart() {
		return xCoordStart;
	}
	
	/**
	 * Sets the yCoordStart position of the driver to the new yCoordStart
	 * @param yCoordStart the yCoordStart position of the driver's trip
	 */
	public void setYCoordStart(int yCoordStart) {
		this.yCoordStart = yCoordStart;
	}
	
	/**
	 * Gets the yCoordStart position of the driver
	 * @return the yCoordStart position of the driver
	 */
	public int getYCoordStart() {
		return yCoordStart;
	}
	
	/**
	 * Gets the xCoordEnd position of the driver
	 * @return the xCoordEnd position of the driver
	 */
	public int getXCoordEnd() {
		return xCoordEnd;
	}
	
	/**
	 * Sets the xCoordEnd position of the driver to the new xCoordEnd
	 * @param xCoordEnd the xCoordEnd position of the driver's trip
	 */
	public void setXCoordEnd(int xCoordEnd) {
		this.xCoordEnd = xCoordEnd;
	}
	
	/**
	 * Gets the yCoordEnd position of the driver
	 * @return the yCoordEnd position of the driver
	 */
	public int getYCoordEnd() {
		return yCoordEnd;
	}
	
	/**
	 * Sets the yCoordEnd position of the driver to the new yCoordEnd
	 * @param yCoordEnd the yCoordEnd position of the driver's trip
	 */
	public void setYCoordEnd(int yCoordEnd) {
		this.yCoordEnd = yCoordEnd;
	}
	
	/**
	 * Sets the driver's trip
	 * @param trip the trip of the driver's trip
	 */
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	/**
	 * Gets the number of ratings the driver has
	 * @return the number of ratings the driver has
	 */
	public static int getNumRatings() {
		return numRatings;
	}
	
	/**
	 * Compares the current Driver to another Driver to order in the PriorityQueue 
	 * by shortest distance and then highest rating
	 * @param other the other Driver to compare to
	 */
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
	
	/**
	 * Adds a driver to the PriorityQueue of Drivers if their status is true/available, otherwise
	 * don't add to PriorityQueue
	 * @param drivers the PriorityQueue of Drivers ordered by shortest distance and then highest rating
	 * @param driver the Driver to add to the PriorityQueue
	 */
	public void addDriverToQueue(PriorityQueue<Driver> drivers, Driver driver) {
		if (driver.status == false) {
			System.out.println("Busy! Cannot add to queue");
		}
		else {
			drivers.add(driver);
		}
	}
	
	/**
	 * Gets the name of the current Driver object
	 * @return the name of the current Driver object
	 */
	public String toString() {
		//return "Name: " + name + " balance: " + balance + " carTitle: " + carTitle + " status: " + status + " rating: " + rating;
		return name;
	}
	
	/**
	 * Changes the current Driver's status to false/busy
	 */
	public void decline() {
		this.status = false;
	}
	
	
}
