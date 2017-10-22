import static org.junit.Assert.*;

import org.junit.Test;
/**
 * A class for unit testing the Grid class
 * @author Avinash Sharma
 *
 */
public class GridTest {
	
	/**
	 * Test the x and y coordinates of the moved Passenger
	 */
	@Test
	public void testMovePassengerAfter() {
		Grid grid = new Grid(20);
		Passenger pass1 = new Passenger("P1", 10000.0);
		pass1.setXCoordStart(1);
		pass1.setYCoordStart(1);

		pass1.enterDestination(grid, 4, 1);
		
		grid.movePassenger(pass1);
		assertEquals("Passenger XCoordDest moved: ", pass1.getXCoordDest(), 4);
		assertEquals("Passenger YCoordDest moved: ", pass1.getYCoordDest(), 1);

	}

}
