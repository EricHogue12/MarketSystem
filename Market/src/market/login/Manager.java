package market.login;

public class Manager extends User {
	
	private static final String PASSCODE = "8157215";
	public final static int MAX_MANAGERS = 10;
	public static int managerCounter = 0;
	
	public Manager(String firstName, String lastName) {
		super("manager" + String.valueOf(managerCounter + 1), PASSCODE, firstName, lastName);
		managerCounter++;
	}
	
	/*
	 * Used for initialization when the first manager logs in to system
	 */
	public static boolean isPasscodeCorrect(String p) {
		return p.equals(PASSCODE);
	}
	
}
