package model;
import java.util.*;

public final class User {
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.username.equals(((User)obj).username);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	private String username;
	private List<Order>orders;
	
	public User(String username)
	{
		this.username = username;
		this.orders = new ArrayList<Order>();
	}
	
	public boolean addOrder(Order order) {
		return this.orders.add(order);
	}
	
	public List<Order> getOrders(){
		return this.orders;
	}
	
	public String getUsername() {
		return this.username;
	}
}
