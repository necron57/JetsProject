package com.skilldistillery.jets.entities;

public class Cruiser extends Jet {
	
	public Cruiser() {
		
	}
	public Cruiser(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	@Override
	public void fly() {
		System.out.println("Standing by to engage threats");
		
	}
}
