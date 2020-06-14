package model;

public final class Pizza extends Meal{
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

	public String getsize() {
		return size;
	}

	public void setsize(String size) {
		this.size = size;
	}

	private String addition;
	private String size;
	
	public Pizza(String name, String type,String addition, String size, float price) {
		super(name, price);
		this.type = type;
		this.addition = addition;
		this.size = size;
	}
	
}
