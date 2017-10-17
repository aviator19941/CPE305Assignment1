
public class Transaction {
	private Driver driver;
	private Passenger pass;
	private Trip trip;
	private static int numTransactions = 0;
	
	public Transaction(Driver driver, Passenger pass, Trip trip) {
		this.driver = driver;
		this.pass = pass;
		this.trip = trip;
	}
	
	public static int getNumTransactions() {
		return numTransactions;
	}
	
	// check if customerBalance is sufficient for fare
	// cancel and notify Passenger
	public boolean checkPassengerBalance() {
		if (pass.getCustBalance() - trip.calculateFare() >= 0) {
			System.out.println("Passenger can ride!");
			driver.setStatus(false);
			return true;
		}
		System.out.println("CANNOT ride due to insufficient funds!");
		System.out.println("Trip is cancelled");
		driver.setStatus(true);
		return false;
	}
	
	public void deductPassengerBalance() {
		if (this.checkPassengerBalance()) {
			numTransactions++;
			double balance = pass.getCustBalance() - trip.calculateFare();
			System.out.println("Passenger pays: $" + trip.calculateFare());
			pass.setCustBalance(balance);
		}
	}
	
	// add 75% of fare to driver balance
	public void addToDriverBalance() {
		if (this.checkPassengerBalance()) {
			double newBalance = trip.calculateFare() * 0.75;
			System.out.println("Driver earns: $" + newBalance);
			driver.setBalance(newBalance);
		}
	}
}
