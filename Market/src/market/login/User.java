package market.login;

// Each user should have a unique user name
public class User {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public User(String firstName, String lastName, String username, String password) {
		if (Customer.customerCounter >= Customer.MAX_CUSTOMERS) {
			throw new IllegalArgumentException("Customer limit reached");
		}
		if (username == null || "".equals(username)) {
			throw new IllegalArgumentException("Illegal username");
		}
		if (this instanceof Customer && username.contains("manager")){
			throw new IllegalArgumentException("Illegal username");
		}
		if (password == null || "".equals(password)) {
			throw new IllegalArgumentException("Illegal password");
		}
		if (firstName == null || "".equals(firstName)) {
			throw new IllegalArgumentException("Illegal first name");
		}
		if (lastName == null || "".equals(lastName)) {
			throw new IllegalArgumentException("Illegal last name");
		}
		
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String f) {
		this.firstName = f;
	}
	
	public void setLastName(String l) {
		this.lastName = l;
	}
	
	public void setPassword(String p) {
		if ("".equals(p) || p == null) {
			throw new IllegalArgumentException("Password cannot be null or empty");
		}
		this.password = p;
	}
	
	public boolean isCorrectPassword(String password) {
		return password.equals(this.password);
	}
	
}
