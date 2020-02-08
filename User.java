public class User {
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String login;
	private String password;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(String UserName, String login, String password) {
		this.userName = UserName;
		this.login = login;
		this.password = password;
	}
	public User(String UserName, String login, String password, String role) {
		this.userName = UserName;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	public User(String UserName) {
		this.userName = UserName;
	}
}