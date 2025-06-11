package market.login;

// Each user should have a unique user name
public class User {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	public User(String username, String password, String firstName, String lastName) {
		
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
	
	public boolean isCorrectPassword(String password) {
		return this.password == password;
	}
	
}
