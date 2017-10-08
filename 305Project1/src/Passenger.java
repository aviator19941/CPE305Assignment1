
public class Passenger {
	private String name;
	private double balance;
	private int xCoord;
	private int yCoord;
	private int xCoordDest;
	private int yCoordDest;
	
	public Passenger(String name, double balance, int xCoord, int yCoord) {
		this.name = name;
		this.balance = balance;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public String getName() {
		return name;
	}
	
	public double getCustBalance() {
		return balance;
	}
	
	public int getXCoord() {
		return xCoord;
	}
	
	public int getYCoord() {
		return yCoord;
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
	
	public boolean sendRequest(Grid grid) {
		if (this.isValidDest(grid)) {
			return true;
		}
		return false;
	}
	
	public double enterRating(Driver driver, double newRating) {
		double curRating = driver.getRating();
		double retRating = curRating + ((newRating - curRating) / driver.getNumRatings() + 1);
		return retRating;
	}
}
