package model;

public final class Burger extends Meal {
	private String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddition() {
		return addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}

	public int getweight() {
		return weight;
	}

	public void setweight(int weight) {
		this.weight = weight;
	}

	private String addition;
	private int weight;
	
	public Burger(String name,String type,String addition, int weight, float price) {
		super(name, price);
		this.type = type;
		this.addition = addition;
		this.weight = weight;
	}
}
