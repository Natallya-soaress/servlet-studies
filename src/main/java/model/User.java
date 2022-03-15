package model;

public class User {
	
	private String userName;
	private String password;
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean login(String userName, String password) {
		if(!this.userName.equals(userName)) {
			return false;
		}
		if(!this.password.equals(password)) {
			return false;
		}
		return true;
	}

}
