package market.login;

/**
 * Make up the bulk of the users
 */
public class Customer extends User {
	
	// only ten customers allowed at a time
	public final static int MAX_CUSTOMERS = 10;
	public static int customerCounter = 0;
	
	public Customer(String firstName, String lastName, String username, String password, double balance) {
		super(firstName, lastName, username, password, balance);
		customerCounter++;
	}
	
	
}
