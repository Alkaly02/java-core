package models;

public class Fourniture {
	private double price, width, height;
	
	public Fourniture(double price, double width, double height) {
		this.price = price;
		this.width = width;
		this.height = height;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return this.price;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	public double getWidth() {
		return this.width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	public double getHeight() {
		return this.height;
	}
}
