
public class Transaction {
	private Driver driver;
	private Passenger pass;
	private Trip trip;
	
	public Transaction(Driver driver, Passenger pass, Trip trip) {
		this.driver = driver;
		this.pass = pass;
		this.trip = trip;
	}
	
	// check if customerBalance is sufficient for fare
	// cancel and notify Passenger
	public boolean checkPassengerBalance() {
		if (pass.getCustBalance() - trip.calculateFare() >= 0) {
			driver.setStatus(false);
			return true;
		}
		System.out.println("CANNOT ride due to insufficient funds!");
		System.out.println("Trip is cancelled");
		driver.setStatus(true);
		return false;
	}
	
	public double getFare() {
		if (this.checkPassengerBalance()) {
			return trip.calculateFare();
		}
		return 0.0;
	}
	
	public void deductPassengerBalance() {
		if (this.checkPassengerBalance()) {
			double balance = pass.getCustBalance() - trip.calculateFare();
			System.out.printf("Passenger pays: $%.2f\n", trip.calculateFare());
			pass.setCustBalance(balance);
		}
		
	}
	
	// add 75% of fare to driver balance
	public void addToDriverBalance() {
		if (this.checkPassengerBalance()) {
			double newBalance = trip.calculateFare() * 0.75;
			System.out.printf("Driver earns: $%.2f\n", newBalance);
			driver.setBalance(driver.getBalance() + newBalance);
		}
	}
}
