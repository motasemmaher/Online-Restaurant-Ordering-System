package model;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final  class Query {
	private static Statement query;
	private static ResultSet result;
	private static ConnectionOcracle connection;
	private static PreparedStatement ps;

	public  Query() {
		try {
			connection = new ConnectionOcracle();
			query = connection.getConnection().createStatement();
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
                        
			e.printStackTrace();
                        
		}
                createTableUser();
                createTableOrder();
                
            try {
                ps = connection.getConnection().prepareStatement("insert into User values (?)");
                ps.setString(1, "osama");
                ps.execute();
                
                ps = connection.getConnection().prepareStatement("insert into User values (?)");
                ps.setString(1, "motasem");
                ps.execute();
                
            } catch (SQLException ex) {
                //Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
	}

	public static Boolean createTableUser() {
		String q = "create table User (username varchar(50),primary key(username))";
		try {
			if (query.execute(q)) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("The Table already exist(User).");
                        e.printStackTrace();
		}
		return false;
	}

	public static Boolean createTableOrder() {
		String q = "create table Orders (username varchar(25),name varchar(25),customization varchar(1000),type varchar(100),size varchar(6),weight varchar(4),meat varchar(7), price FLOAT(7,2));";
		try {
			if (query.execute(q)) {
				return true;
			}
                        System.out.println("The table was not created");
		} catch (SQLException e) {
			System.out.println("The Table already exist(Order).");
                        e.printStackTrace();
		}
		return false;
	}

	

	public static Boolean insertIntoUser(String username) {
		try {
			ps = connection.getConnection().prepareStatement("insert into User values (?)");
			ps.setString(1, username);
			if (ps.execute()) {
				return true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		return false;
	}

	public static Boolean insertIntoOrder(String username, String name, String customization, String type, String Size, String weigth, String meat, float price) {
		try {
			ps = connection.getConnection().prepareStatement("insert into Orders values (?,?,?,?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, name);
			ps.setString(3, customization);
			ps.setString(4, type);
			ps.setString(5, Size);
			ps.setString(6, weigth);
			ps.setString(7, meat);
                        ps.setFloat(8, price);
			if (ps.execute()) {
				return true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		return false;
	}

	

	public static ArrayList<Order> getOrder(String username) {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			ps = connection.getConnection().prepareStatement("select * from Orders where username = ?");
			ps.setString(1, username);
                        result = ps.executeQuery();
			
			while (result.next()) {
				String name = result.getString("name");
				if (name.equals("Pizza")) {
					orders.add(new Order(new Pizza(result.getString("name"), result.getString("type"),
							result.getString("customization"), result.getString("size"), result.getFloat("price"))));
				} else if (name.equals("Burger")) {
					orders.add(new Order(new Burger(result.getString("name"), result.getString("type"),
							result.getString("customization"), Integer.parseInt(result.getString("weight")), result.getFloat("price"))));
				} else {
					orders.add(new Order(new Pasta(result.getString("name"), result.getString("type"),
							result.getString("customization"), result.getString("meat"), result.getFloat("price"))));
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		return orders;
	}

	public static Boolean matchUser(String username) {
		try {
			ps = connection.getConnection().prepareStatement("select * from User where username = ?");
			ps.setString(1, username);
			result = ps.executeQuery();
			result.first();
			if(result.getRow() == 1) {
				return true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		return false;
	}
}
	
