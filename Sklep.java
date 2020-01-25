import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Sklep {

		private User loggedInUser = null;
		private Map<String, User> users = new HashMap<String, User>();
		private ItemManager itemMgr = new ItemManager();
		
		public void addUser(String UserName, String login, String password) {
			users.put(login, new User (UserName, login, password, 1));
		}
		
		public void work () {
			User admin = new User ("admin", "admin", "admin", 0);
			User user1 = new User ("user1", "user1", "user1", 1);
			
			users.put(admin.getLogin(), admin);
			users.put(user1.getLogin(), user1);
			
			Scanner scan = new Scanner(System.in);
			
			Boolean doStop = false;
			
			do {
				System.out.println("Podaj login:");
				String login = scan.nextLine();
				System.out.println("Podaj haslo:");
				String pass = scan.nextLine();
				
				if (users.containsKey(login) && users.get(login).getPassword().equals(pass)) {
					loggedInUser = users.get(login);
					if (loggedInUser.getRole() == 0) {
						//admin
						Boolean doLogout = false;
						do {
							System.out.println("[1]. Dodaj u¿ytkownika");
							System.out.println("[2]. Lista u¿ytkowników");
							System.out.println("[3]. Dodaj produkt");
							System.out.println("[4]. Lista produktów");
							System.out.println("[5]. Zmieñ iloœæ produktu");
							System.out.println("[10]. Wylogowanie");
							System.out.println("[11]. Wyjœcie ze sklepu");
							String userChoice = scan.nextLine();
							switch (userChoice) {
								case "1" : {
									System.out.println("Login dla nowego u¿ytkownika: ");
									String newUserLogin = scan.nextLine();
									System.out.println("Password dla nowego u¿ytkownika: ");
									String newUserPass = scan.nextLine();
									System.out.println("Nazwa dla nowego u¿ytkownika: ");
									String newUserName = scan.nextLine();
									addUser(newUserLogin, newUserPass, newUserName);
									break;
								} 
								case "2" : {
									for (User u : users.values())
										System.out.println("User: " + u.getName() + ", login: " + u.getLogin());
									break;
								}
								case "3" : {
									System.out.println("Nazwa dla nowego produktu: ");
									String newProductName = scan.nextLine();
									System.out.println("Cena dla nowego produktu: ");
									String newProductPrice = scan.nextLine();
									System.out.println("Iloœæ dla nowego produktu: ");
									int newProductAmount = scan.nextInt();
									if (scan.hasNextLine()) scan.nextLine();
									Product newProduct = itemMgr.createProduct(newProductName, newProductPrice, newProductAmount);
									itemMgr.addProduct(newProduct);
								}
								case "4" : {
									int i = 0;
									System.out.println("Lista produktów:");
									for (Product Product : itemMgr.getProduct())
										System.out.println("Produkt [" + i++ + "]: " + Product.getName() + ", cena: " + Product.getPrice() + ", iloœæ w magazynie: " + Product.getAmount());
									break;
								}
								case "5" : {
									System.out.println("Wybierz produkt: ");
									int ProductIndex = scan.nextInt();
									if (scan.hasNextLine()) scan.nextLine();
									System.out.println("Nowa iloœæ dla produktu: ");
									int itemAmount = scan.nextInt();
									if (scan.hasNextLine()) scan.nextLine();
									itemMgr.getProduct().get(ProductIndex).setAmount(ProductAmount);
									break;
								}
								case "10" : {
									System.out.println("Wylogowano");
									doLogout = true; 
									break;
								}
								case "11" : {
									doLogout = true; 
									doStop = true; 
									break;
								}
							}
						} while (doLogout == false);
					} else {
						//user
					}
				} else {
					System.out.println("Niew³aœciwy login lub has³o");
				}
			} while (doStop == false);
			
			System.out.println("Bye.");
			scan.close();
		}


	public static void main(String[] args) {
		
	}

}
