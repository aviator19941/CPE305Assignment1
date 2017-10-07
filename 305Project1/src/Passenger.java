import java.util.*;

public class Passenger {
	private String name;
	private double balance;
	private int xCoordDest;
	private int yCoordDest;
	
	public Passenger(String name, double balance, int xCoordDest, int yCoordDest) {
		this.name = name;
		this.balance = balance;
		this.xCoordDest = xCoordDest;
		this.yCoordDest = yCoordDest;
	}
	
	public String getName() {
		return name;
	}
	
	public double getCustBalance() {
		return balance;
	}
	
	public int getXCoord() {
		return xCoordDest;
	}
	
	public int getYCoord() {
		return yCoordDest;
	}
	
	public void sendRequest(PriorityQueue<Driver> drivers) {
		
	}
	
	public void enterDestination(int xCoordDest, int yCoordDest) {
		this.xCoordDest = xCoordDest;
		this.yCoordDest = yCoordDest;
	}
	
	public double enterRating(Driver driver, double newRating) {
		double curRating = driver.getRating();
		double retRating = curRating + ((newRating - curRating) / driver.getNumRatings() + 1);
		return retRating;
	}
}
