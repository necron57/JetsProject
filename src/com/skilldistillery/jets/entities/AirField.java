package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	private Jet newJet;
	Scanner sc = new Scanner(System.in);
	private List<Jet> fleet = new ArrayList<>();

	public AirField() {

		readShips("jets.txt");
	}

	public List<Jet> readShips(String fileName) {

		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetRecord = line.split(",");
				String modelOfJet = jetRecord[0];
				double speed = Double.parseDouble(jetRecord[1]);
				int range = Integer.parseInt(jetRecord[2]);
				long price = Long.parseLong(jetRecord[3]);
				Jet myJet = null;
				if (modelOfJet.equalsIgnoreCase("Cruiser")) {

					myJet = new Cruiser(modelOfJet, speed, range, price);
				}
				if (modelOfJet.equalsIgnoreCase("Frigate")) {
					myJet = new Frigate(modelOfJet, speed, range, price);
				}
				if (modelOfJet.equalsIgnoreCase("Battleship")) {
					myJet = new BattleShip(modelOfJet, speed, range, price);
				}
				fleet.add(myJet);

			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return fleet;
	}

	public void listShips() {
		for (Jet ship : fleet) {
			if (ship != null) {
				System.out.println(ship);
			}
		}

	}

	public void sailShip() {
		for (int i = 0; i < fleet.size(); i++) {
			newJet = fleet.get(i);
			System.out.print(newJet);
			newJet.sail();
		}

	}

	public void fastestShip() {
		System.out.println("The fastest Ship is: ");
		newJet = fleet.get(0);
		for (Jet ship : fleet) {
			if (ship != null) {
				if (newJet.getSpeed() < ship.getSpeed()) {
					newJet = ship;
				}
			}

		}
		System.out.println(newJet);
	}

	public void longestRangeShip() {
		System.out.println("The Ship with the longest range is: ");
		newJet = fleet.get(0);
		for (Jet ship : fleet) {
			if (ship != null) {
				if (newJet.getRange() < ship.getRange()) {
					newJet = ship;
				}
			}

		}
		System.out.println(newJet);
	}

	public void addShip(String name, Double speed, int range, long price) {
		newJet = null;
		String nameOfJet = name;
		Double speedOfJet = speed;
		int rangeOfJet = range;
		long priceOfJet = price;
		if (nameOfJet.equalsIgnoreCase("Battleship")) {
			newJet = new BattleShip(nameOfJet, speedOfJet, rangeOfJet, priceOfJet);
		} else if (nameOfJet.equalsIgnoreCase("Cruiser")) {
			newJet = new Cruiser(nameOfJet, speedOfJet, rangeOfJet, priceOfJet);
		} else if (nameOfJet.equalsIgnoreCase("Frigate")) {
			newJet = new Frigate(nameOfJet, speedOfJet, rangeOfJet, priceOfJet);
		}

		fleet.add(newJet);
		System.out.println(" Added ship to fleet ");

	}

	public void removeShip() {
		System.out.println("Please select the Ship that you would like to remove:  ");
		for (int index = 0; index < fleet.size(); index++) {
			System.out.println(index + ". " + fleet.get(index));
		}
		int selection = sc.nextInt();
		fleet.remove(selection);

	}

	public void command() {
		for (Jet jet : fleet) {
			if (jet instanceof BattleShip) {
				((BattleShip) jet).leadFleet();
			}
		}
	}

	public void escort() {
		for (Jet jet : fleet) {
			if (jet instanceof Frigate) {
				((Frigate) jet).escortFleet();
			}
		}
	}
}
