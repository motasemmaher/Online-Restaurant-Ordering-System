package model;

public final class Order {
	Meal meal;
	
	public Order(Meal meal) {
		this.meal = meal;
	}
	public Meal getMeal() {
		return meal;
	}
}
