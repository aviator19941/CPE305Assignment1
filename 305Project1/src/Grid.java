
public class Grid {
	private int[][] map;
	
	public Grid() {
		map = new int[10][10];
	}
	
	// Driver = 1
	public void generateRandomDrivers() {
		int row = (int) Math.floor(Math.random() * 10);
		int col = (int) Math.floor(Math.random() * 10);
		
	}
	
	// Passenger = 2
	public void generateRandomPassengers() {
		int row = (int) Math.floor(Math.random() * 10);
		int col = (int) Math.floor(Math.random() * 10);
		
	}

}
