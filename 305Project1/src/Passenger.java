
public class Passenger {
	private String name;
	private double balance;
	private int xCoordStart;
	private int yCoordStart;
	private int xCoordDest;
	private int yCoordDest;
	
	public Passenger(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	
	public double getCustBalance() {
		return balance;
	}
	
	public void setCustBalance(double balance) {
		this.balance = balance;
	}
	
	public int getXCoordStart() {
		return xCoordStart;
	}
	
	public void setXCoordStart(int xCoordStart) {
		this.xCoordStart = xCoordStart;
	}
	
	public int getYCoordStart() {
		return yCoordStart;
	}
	
	public void setYCoordStart(int yCoordStart) {
		this.yCoordStart = yCoordStart;
	}
	
	public int getXCoordDest() {
		return xCoordDest;
	}
	
	public void setXCoordDest(int xCoordDest) {
		this.xCoordDest = xCoordDest;
	}
	
	public int getYCoordDest() {
		return yCoordDest;
	}
	
	public void setYCoordDest(int yCoordDest) {
		this.yCoordDest = yCoordDest;
	}
	
	public void enterDestination(Grid grid, int xCoordDest, int yCoordDest) {
		if (isValidDest(grid, xCoordDest, yCoordDest)) {
			this.xCoordDest = xCoordDest;
			this.yCoordDest = yCoordDest;
		}
	}
	
	public boolean isValidDest(Grid grid, int xCoordDest, int yCoordDest) {
		return (grid.getSizeOfGrid() - 1 >= xCoordDest) && (grid.getSizeOfGrid() - 1 >= yCoordDest);
	}
	
	public void enterRating(Driver driver, double newRating) {
		driver.setStatus(true);
		double curRating = driver.getRating();
		int numRatings = driver.getNumRatings();
		driver.incNumRatings();
		System.out.println("Set numRatings: " + driver.getNumRatings());
		System.out.println("curRating: " + curRating);
		double retRating = curRating + ((newRating - curRating) / (driver.getNumRatings()));
		//return retRating;
		System.out.println("Rating set to: " + retRating);
		driver.setRating(retRating);
		driver.setNumRatingsToCurrent(driver, driver.getNumRatings());
		//driver.setNumRatingsZero();
	}
	
	public String toString() {
		//return "Name: " + name + " balance: " + balance;
		return name;
	}
}
