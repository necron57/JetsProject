package com.skilldistillery.jets.entities;

public class BattleShip extends Jet implements Command {

	public BattleShip() {

	}

	public BattleShip(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void leadFleet() {
		System.out.println("Battleship standing by to command the fleet");

	}

	@Override
	public void sail() {
		double flightTime = (int) (getRange() / getSpeed());
		System.out.println("The current time left for this voyage is: " + flightTime + " hours");

	}

}
