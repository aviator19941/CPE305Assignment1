/**
 * A class to handle Transactions between Passengers and Drivers
 * @author Avinash Sharma
 *
 */
public class Transaction {
	private Driver driver;
	private Passenger pass;
	private Trip trip;
	
	/**
	 * Constructs a Transaction based on the Driver, Passenger, and Trip
	 * @param driver the current Driver
	 * @param pass the current Passenger
	 * @param trip the current Trip
	 */
	public Transaction(Driver driver, Passenger pass, Trip trip) {
		this.driver = driver;
		this.pass = pass;
		this.trip = trip;
	}
	
	/**
	 * check if customerBalance is sufficient for fare, if not cancel and notify Passenger
	 * @return true if the Passenger has sufficient funds, otherwise false and notify Passenger
	 */
	public boolean checkPassengerBalance() {
		if (pass.getCustBalance() - trip.calculateFare() >= 0) {
			System.out.println("Ride accepted.");
			driver.setStatus(false);
			return true;
		}
		System.out.println("CANNOT ride due to insufficient funds!");
		System.out.println("Trip is cancelled");
		driver.setStatus(true);
		return false;
	}
	
	/**
	 * Gets the fare of the trip
	 * @return the calculated fare of the trip, otherwise return 0
	 */
	public double getFare() {
		if (this.checkPassengerBalance()) {
			return trip.calculateFare();
		}
		return 0.0;
	}
	
	/**
	 * Subtract the fare from the Passenger's current balance and set the balance to the new balance
	 */
	public void deductPassengerBalance() {
		if (this.checkPassengerBalance()) {
			double balance = pass.getCustBalance() - trip.calculateFare();
			System.out.printf("Passenger pays: $%.2f\n", trip.calculateFare());
			pass.setCustBalance(balance);
		}
	}
	
	/**
	 * Add 75% of the fare the the Driver's current balance
	 */
	public void addToDriverBalance() {
		if (this.checkPassengerBalance()) {
			double newBalance = trip.calculateFare() * 0.75;
			System.out.printf("Driver earns: $%.2f\n", newBalance);
			driver.setBalance(driver.getBalance() + newBalance);
		}
	}
}
