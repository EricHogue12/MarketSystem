package market.login;

public class Customer extends User {
	
	public final static int MAX_CUSTOMERS = 100;
	public static int customerCounter = 0;
	
	public Customer(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
		customerCounter++;
	}
}
