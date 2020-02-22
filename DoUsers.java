import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DoUsers {
	public void addUser(User prsn) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	        	connection = DriverManager.getConnection("jdbc:sqlite:D:/Sklep.db");

	        	Statement statement = connection.createStatement();
	        	statement.setQueryTimeout(30); 

	        	statement.executeUpdate("INSERT INTO Person values('"+prsn.getUserName()+"')");
	        
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage());
	    	 	throw e;
	    	}
		catch (ClassNotFoundException e) {
			System.err.println(e.getMessage()); 
			throw e;
		}
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {          
				System.err.println(e); 
			}
	    }
	}
	
	public void removeUser (User prsn) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	        	connection = DriverManager.getConnection("jdbc:sqlite:D:/Sklep.db");

	        	Statement statement = connection.createStatement();
	        	statement.setQueryTimeout(30); 

	        	statement.executeUpdate("DELETE FROM Person WHERE name='"+ prsn.getUserName() + "'");
	        
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage());
	    	 	throw e;
	    	}
		catch (ClassNotFoundException e) {
			System.err.println(e.getMessage()); 
			throw e;
		}
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {          
				System.err.println(e); 
			}
	    }
	}
	public List<User> getPersons () throws Exception {
		List<User> listOfPersons = new ArrayList<User>();

		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	         	connection = DriverManager.getConnection("jdbc:sqlite:D:/Sklep.db");

	         	Statement statement = connection.createStatement();
	         	statement.setQueryTimeout(30); 

	         	ResultSet resultSet = statement.executeQuery("SELECT name from Person");
	         	while(resultSet.next())
	         	{
	         		User newUser = new User(resultSet.getString("name"));
	        	 	listOfPersons.add (newUser);
	         	}
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage()); 
	    	}       
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {        
				System.err.println(e); 
			}
	    	}
		
		return listOfPersons;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addProduct(Product prdc) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	        	connection = DriverManager.getConnection("jdbc:sqlite:D:/Sklep.db");

	        	Statement statement = connection.createStatement();
	        	statement.setQueryTimeout(30); 

	        	statement.executeUpdate("INSERT INTO Product(name, price, amount) values('"+prdc.getName()+"','"+prdc.getPrice()+"','"+prdc.getAmount()+"')");
	        
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage());
	    	 	throw e;
	    	}
		catch (ClassNotFoundException e) {
			System.err.println(e.getMessage()); 
			throw e;
		}
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {          
				System.err.println(e); 
			}
	    }
	}
	
	public void removeProduct (Product prdc) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	        	connection = DriverManager.getConnection("jdbc:sqlite:D:/Sklep.db");

	        	Statement statement = connection.createStatement();
	        	statement.setQueryTimeout(30); 

	        	statement.executeUpdate("DELETE FROM Product name='"+ prdc.getName() + "'");
	        
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage());
	    	 	throw e;
	    	}
		catch (ClassNotFoundException e) {
			System.err.println(e.getMessage()); 
			throw e;
		}
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {          
				System.err.println(e); 
			}
	    }
	}
	
	public List<Product> getProducts () throws Exception {
		List<Product> listOfProducts = new ArrayList<Product>();

		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	         	connection = DriverManager.getConnection("jdbc:sqlite:D:/Sklep.db");

	         	Statement statement = connection.createStatement();
	         	statement.setQueryTimeout(30); 

	         	ResultSet resultSet = statement.executeQuery("SELECT name from product");
	         	while(resultSet.next())
	         	{
	         		Product newProduct = new Product(resultSet.getString("name"), resultSet.getString("Price"), resultSet.getInt("amount"));
	        	 	listOfProducts.add (newProduct);
	         	}
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage()); 
	    	}       
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {        
				System.err.println(e); 
			}
	    	}
		
		return listOfProducts;
	}
}
