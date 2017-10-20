
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
	
	public int getYCoordDest() {
		return yCoordDest;
	}
	
	public void enterDestination(Grid grid, int xCoordDest, int yCoordDest) {
		if (isValidDest(grid, xCoordDest, yCoordDest)) {
			System.out.println("Valid coords");
			this.xCoordDest = xCoordDest;
			this.yCoordDest = yCoordDest;
		}
	}
	
	public boolean isValidDest(Grid grid, int xCoordDest, int yCoordDest) {
		return (grid.getSizeOfGrid() - 1 >= xCoordDest) && (grid.getSizeOfGrid() - 1 >= yCoordDest);
	}
	
	public double enterRating(Driver driver, double newRating) {
		double curRating = driver.getRating();
		System.out.println("curRating is: " + curRating);
		double retRating = curRating + ((newRating - curRating) / (driver.getNumRatings() + 1));
		System.out.println("retRating is: " + retRating);
		return retRating;
	}
	
	public String toString() {
		//return "Name: " + name + " balance: " + balance;
		return name;
	}
}
