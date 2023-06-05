package com.skilldistillery.jets.entities;

public class Cruiser extends Jet {

	public Cruiser() {

	}

	public Cruiser(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void sail() {
		double flightTime = (int) (getRange() / getSpeed());
		System.out.println("The current time left for this voyage is: " + flightTime + " hours");

	}
}
