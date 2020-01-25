import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	private String UserName;
	private String login;
	private String password;
	public User(String UserName, String login, String password) {
		this.UserName = UserName;
		this.login = login;
		this.password = password;
	}
}