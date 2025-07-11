package market.login;

/**
 * Will be initialized once (just one manager will exist)
 */
public class Manager extends User {
	
	private static final String PASSCODE = "8157215";
	
	
	public Manager(String firstName, String lastName) {
		super(firstName, lastName, "manager", PASSCODE, 0);
	}
	
	
}
