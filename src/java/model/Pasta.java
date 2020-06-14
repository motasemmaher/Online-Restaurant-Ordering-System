package model;

public final class Pasta extends Meal{
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

	public String getMeat() {
		return meat;
	}

	public void setMeat(String meat) {
		this.meat = meat;
	}

	private String addition;
	private String meat;
	
	public Pasta(String name, String type,String addition, String meat, float price) {
		super(name, price);
		this.type = type;
		this.addition = addition;
		this.meat = meat;
	}
}
