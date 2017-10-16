
public class Grid {
	private int[][] map;
	private int size;
	
	// Change to 300*300 grid
	public Grid(int size) {
		this.size = size;
		map = new int[size][size];
	}
	
	// Driver = 1
	public void generateRandomDriver() {
		int row = (int) Math.floor(Math.random() * this.size);
		int col = (int) Math.floor(Math.random() * this.size);
		map[row][col] = 1;
	}
	
	// Passenger = 2
	public void generateRandomPassenger() {
		int row = (int) Math.floor(Math.random() * this.size);
		int col = (int) Math.floor(Math.random() * this.size);
		map[row][col] = 2;
	}
	
	public int getSizeOfGrid() {
		return this.size;
	}
	
	// get xCoord and yCoord of closest driver and move driver (1) to passenger's destination
	public void moveDriver(Driver driver) {
		int newRow = driver.getXCoord();
		int newCol = driver.getYCoord();
		map[newRow][newCol] = 1;
	}
	
	// get xCoord and yCoord of passenger and move passenger (2) to passenger's destination
	public void movePassenger(Passenger pass) {
		int newRow = pass.getXCoordDest();
		int newCol = pass.getYCoordDest();
		map[newRow][newCol] = 2;
	}
	
}
