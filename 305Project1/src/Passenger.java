
public class Passenger {
	private String name;
	private double balance;
	private int xCoordStart;
	private int yCoordStart;
	private int xCoordDest;
	private int yCoordDest;
	private static int numRatings = 0;
	
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
	
	public int getYCoordDest() {
		return yCoordDest;
	}
	
	public void enterDestination(int xCoordDest, int yCoordDest) {
		this.xCoordDest = xCoordDest;
		this.yCoordDest = yCoordDest;
	}
	
	public boolean isValidDest(Grid grid) {
		return (grid.getSizeOfGrid() - 1 >= this.xCoordDest) && (grid.getSizeOfGrid() - 1 >= this.yCoordDest);
	}
	
	public double enterRating(Driver driver, double newRating) {
		double curRating = driver.getRating();
		numRatings++;
		double retRating = curRating + ((newRating - curRating) / numRatings);
		return retRating;
	}
	
	public String toString() {
		//return "Name: " + name + " balance: " + balance;
		return name;
	}
}
