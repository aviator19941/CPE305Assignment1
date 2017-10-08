
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
	
	public static void main(String[] args) {
		int numDrivers = 3;
		int numPassengers = 2;
		Grid grid = new Grid(5);
		
		for (int i = 0; i < numDrivers; i++) {
			grid.generateRandomDriver();
		}
		
		for (int j = 0; j < numPassengers; j++) {
			grid.generateRandomPassenger();
		}
		
		for (int a = 0; a < grid.map.length; a++) {
			for (int b = 0; b < grid.map[a].length; b++) {
				System.out.print(grid.map[a][b] + " ");
			}
			System.out.println();
		}
		
		
	}

}
