
public class Transaction {
	private Driver driver;
	private Passenger pass;
	private Trip trip;
	private static int numTransactions = 0;
	
	public Transaction(Driver driver, Passenger pass, Trip trip) {
		this.driver = driver;
		this.pass = pass;
		this.trip = trip;
		this.numTransactions++;
	}
	
	public static int getNumTransactions() {
		return numTransactions;
	}
	
	// check if customerBalance is sufficient for fare
	// cancel and notify Passenger
	public boolean checkPassengerBalance() {
		if (pass.getCustBalance() - trip.calculateFare(pass) >= 0) {
			System.out.println("Passenger can ride!");
			return true;
		}
		System.out.println("CANNOT ride!");
		System.out.println("Trip is cancelled");
		driver.setStatus(false);
		return false;
	}
	
	public void deductPassengerBalance() {
		if (this.checkPassengerBalance()) {
			double balance = pass.getCustBalance() - trip.calculateFare(pass);
			System.out.println("Passenger pays: " + balance);
			pass.setCustBalance(balance);
		}
	}
	
	// add 75% of fare to driver balance
	public void addToDriverBalance() {
		if (this.checkPassengerBalance()) {
			double newBalance = trip.calculateFare(pass) * 0.75;
		}
	}
}
