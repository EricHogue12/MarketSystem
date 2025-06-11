package market.login;

import java.util.ArrayList;

public class Login {
	
	private ArrayList<User> users;
	private User currentUser;
	private static Login instance;
	
	private Login() {
		users = new ArrayList<User>();
	}
	
	public static synchronized Login getInstance() {
		if (instance == null) {
			instance = new Login();
		}
		
		return instance;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	public void logout() {
		currentUser = null;
	}
	
	public void login(String username, String password) {
		if (currentUser != null) {
			throw new IllegalArgumentException("Cannot log in when a user is already logged in");
		}
		
		User userBasedOnUsername = null;
		
		for (int i = 0; i < users.size(); i++) {
			if (username.equals(users.get(i).getUsername())) {
				userBasedOnUsername = users.get(i);
			}
		}
		
		if (userBasedOnUsername == null) {
			throw new IllegalArgumentException("There is no User with that username");
		}
		
		if (userBasedOnUsername.isCorrectPassword(password)) {
			currentUser = userBasedOnUsername;
		}
		else {
			throw new IllegalArgumentException("Invalid password");
		}
	}
	
	
	
	
}
