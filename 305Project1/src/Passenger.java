/**
 * A class for producing Passengers
 * @author Avinash Sharma
 *
 */
public class Passenger {
	private String name;
	private double balance;
	private int xCoordStart;
	private int yCoordStart;
	private int xCoordDest;
	private int yCoordDest;
	
	/**
	 * Constructs a passenger with a name and amount of money
	 * @param name the Passenger's name
	 * @param balance the Passenger's amount of money
	 */
	public Passenger(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	/**
	 * Gets the Passenger's name
	 * @return the Passenger's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the Passenger's amount of money
	 * @return the Passenger's amount of money
	 */
	public double getCustBalance() {
		return balance;
	}
	
	/**
	 * Sets the balance of the Passenger to the new balance
	 * @param balance the new balance to set the Passenger's balance to
	 */
	public void setCustBalance(double balance) {
		this.balance = balance;
	}
	
	/**
	 * Gets the xCoordStart position of the Passenger
	 * @return the xCoordStart position of the Passenger
	 */
	public int getXCoordStart() {
		return xCoordStart;
	}
	
	/**
	 * Sets the xCoordStart position of the Passenger to the new xCoordStart
	 * @param xCoordStart the new xCoordStart position of the Passenger
	 */
	public void setXCoordStart(int xCoordStart) {
		this.xCoordStart = xCoordStart;
	}
	
	/**
	 * Gets the yCoordStart position of the Passenger
	 * @return the yCoordStart position of the Passenger
	 */
	public int getYCoordStart() {
		return yCoordStart;
	}
	
	/**
	 * Sets the yCoordStart position of the Passenger to the new yCoordStart
	 * @param yCoordStart the new yCoordStart position of the Passenger
	 */
	public void setYCoordStart(int yCoordStart) {
		this.yCoordStart = yCoordStart;
	}
	
	/**
	 * Gets the xCoordDest position of the Passenger
	 * @return the xCoordDest position of the Passenger
	 */
	public int getXCoordDest() {
		return xCoordDest;
	}
	
	/**
	 * Sets the xCoordDest position of the Passenger to the new xCoordDest
	 * @param xCoordDest the new xCoordDest position of the Passenger
	 */
	public void setXCoordDest(int xCoordDest) {
		this.xCoordDest = xCoordDest;
	}
	
	/**
	 * Gets the yCoordDest position of the Passenger
	 * @return the yCoordDest position of the Passenger
	 */
	public int getYCoordDest() {
		return yCoordDest;
	}
	
	/**
	 * Sets the yCoordDest position of the Passenger to the new yCoordDest
	 * @param yCoordDest the new yCoordDest of the Passenger
	 */
	public void setYCoordDest(int yCoordDest) {
		this.yCoordDest = yCoordDest;
	}
	
	/**
	 * Sets the x and y destination positions of the Passenger
	 * @param grid the current grid
	 * @param xCoordDest the new xCoordDest of the Passenger
	 * @param yCoordDest the new yCoordDest of the Passenger
	 */
	public void enterDestination(Grid grid, int xCoordDest, int yCoordDest) {
		if (isValidDest(grid, xCoordDest, yCoordDest)) {
			this.xCoordDest = xCoordDest;
			this.yCoordDest = yCoordDest;
		}
	}
	
	/**
	 * Checks if the entered destination is valid (within the grid boundaries)
	 * @param grid the current grid
	 * @param xCoordDest the new xCoordDest of the Passenger
	 * @param yCoordDest the new yCoordDest of the Passenger
	 * @return true if the destination coordinates are within the grid boundaries, otherwise false
	 */
	public boolean isValidDest(Grid grid, int xCoordDest, int yCoordDest) {
		return (grid.getSizeOfGrid() - 1 >= xCoordDest) && (grid.getSizeOfGrid() - 1 >= yCoordDest);
	}
	
	/**
	 * Sets the driver's status to true/available and calculates their new rating 
	 * based on the new rating by the current Passenger
	 * @param driver the Driver being rated
	 * @param newRating the Passenger's rating of the Driver
	 */
	public void enterRating(Driver driver, double newRating) {
		driver.setStatus(true);
		double curRating = driver.getRating();
		int numRatings = driver.getNumRatings();
		driver.incNumRatings();
		System.out.println("curRating: " + curRating);
		double retRating = curRating + ((newRating - curRating) / (driver.getNumRatings()));
		//return retRating;
		System.out.println("Rating set to: " + retRating);
		driver.setRating(retRating);
		driver.setNumRatingsToCurrent(driver);
	}
	
	/**
	 * Prints out the name of the Passenger
	 */
	public String toString() {
		//return "Name: " + name + " balance: " + balance;
		return name;
	}
}
