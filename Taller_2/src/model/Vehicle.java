package model;

import java.io.Serializable;

public class Vehicle implements Serializable {
	private int id;
	private String brand;
	private String model;
	private int year;
	private String licensePlate;
	private String color;

	public Vehicle(int id, String brand, String model, int year, String licensePlate, String color) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.licensePlate = licensePlate;
		this.color = color;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getLicensePlate() {
		return licensePlate;
	}
	
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return id + ". " + brand + " " + model + " (" + year + ")" + " - " + color + " [" + licensePlate + "]";
	}
	
	

}
