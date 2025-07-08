package market.login;

public class Customer extends User {
	
	public final static int MAX_CUSTOMERS = 10;
	public static int customerCounter = 0;
	
	public Customer(String firstName, String lastName, String username, String password, double balance) {
		super(firstName, lastName, username, password, balance);
		customerCounter++;
	}
	
	
}
