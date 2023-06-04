package com.skilldistillery.jets.entities;

public class Frigate extends Jet implements Escort {
	
	public Frigate() {
		
	}
	public Frigate(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void escortFleet() {
		System.out.println("Escort craft standing by to support fleet");
	}
	@Override
	public void fly() {
		System.out.println("Scouting ahead in support of command craft");
		
	}

}
