package model;

public abstract class Meal {

    private String name;
    private float price;

    public Meal(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

}
