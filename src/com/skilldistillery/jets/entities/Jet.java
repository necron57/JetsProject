package com.skilldistillery.jets.entities;

import java.util.Objects;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;
	private static int currentNumberOfShips;
	private int id = 0;

	public abstract void fly();

	public Jet() {

	}

	public Jet(String model, double speed, int range, long price) {
		Jet.currentNumberOfShips++;
		id = Jet.currentNumberOfShips;
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public double getSpeed() {
		return speed;
	}

	public int getRange() {
		return range;
	}

	public long getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Ship  [ShipID=" + id + ", model=" + model + ", speedInMPH=" + speed + ", range=" + range + 
				", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model) && price == other.price && range == other.range
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}

}