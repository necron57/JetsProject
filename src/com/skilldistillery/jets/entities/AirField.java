package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AirField {
	private Jet newJet;
	private List<Jet> fleet = new ArrayList<>();
//	public static void main(String[] args) {
//		String fileName = "jets.txt";
//		AirField af = new AirField();
//		List<Jet> fleet= af.readJets(fileName);
//		System.out.println(fleet);
//	}

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

		Iterator<Jet> listOfJets = fleet.iterator();
		while (listOfJets.hasNext()) {
			System.out.println(listOfJets.next());
		}

	}

	public void sailShip() {
//		fleet.

	}

	public void fastestShip() {
		System.out.println("The fastest Ship is: ");
		Jet fastJet = fleet.get(0);
		for (Jet jet : fleet) {
			if (jet != null) {
				if (fastJet.getSpeed() < jet.getSpeed()) {
					fastJet = jet;
				}
			}

		}
		System.out.println(fastJet);
	}

	public void longestRangeShip() {
		System.out.println("The Ship with the longest range is: ");
		Jet longRangeShip = fleet.get(0);
		for (Jet jet : fleet) {
			if (jet != null) {
				if (longRangeShip.getRange() < jet.getRange()) {
					longRangeShip = jet;
				}
			}

		}
		System.out.println(longRangeShip);
	}

	public void addShip(String name, Double speed, int range, long price) {
		Jet newJet = null;
		String nameOfJet = name;
		Double speedOfJet = speed;
		int rangeOfJet = range;
		long priceOfJet = price;
		if (nameOfJet.equalsIgnoreCase("Battleship")) {
			newJet = new BattleShip(nameOfJet, speedOfJet, rangeOfJet, priceOfJet);
		}
		if (nameOfJet.equalsIgnoreCase("Cruiser")) {
			newJet = new Cruiser(nameOfJet, speedOfJet, rangeOfJet, priceOfJet);
		} else if (nameOfJet.equalsIgnoreCase("Frigate")) {
			newJet = new Frigate(nameOfJet, speedOfJet, rangeOfJet, priceOfJet);
		}
		fleet.add(newJet);

	}

	public void removeShip(int userChoice) {
		System.out.println("you have chosen to remove:" + "Ship ID: " + userChoice);
		if (userChoice >= 0) {
			fleet.remove(userChoice);
		}
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
