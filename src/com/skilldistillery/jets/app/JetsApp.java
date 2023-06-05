package com.skilldistillery.jets.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Jet;

public class JetsApp {
	private AirField af = new AirField();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		ja.run();

	}

	public void run() {

		boolean running = true;
		while (running) {
			System.out.println("\nPlease make a selection from the menu listed:");
			printMenu();
			int input = sc.nextInt();
			if (input == 1) {
				listFleet();
			} else if (input == 2) {
				sailShips();
			} else if (input == 3) {
				fastestShip();
			} else if (input == 4) {
				longestRangeShip();
			} else if (input == 5) {
				escortShip();
			} else if (input == 6) {
				commandShip();
			} else if (input == 7) {
				createShip();
			} else if (input == 8) {
				removeShip();
			} else if (input == 9) {
				System.out.println("QUITTING PROGRAM");
				running = false;
			}

		}
		sc.close();
	}

	private void printMenu() {
		System.out.println("1. List fleet");
		System.out.println("2. Sail all Ships");
		System.out.println("3. View fastest Ship");
		System.out.println("4. View Ship with longest range");
		System.out.println("5. Escort Fleet");
		System.out.println("6. Command Fleet");
		System.out.println("7. Add a Ship to Fleet");
		System.out.println("8. Remove a Ship from Fleet");
		System.out.println("9. Quit");
	}

	protected void listFleet() {
		af.listShips();
	}

	private void sailShips() {
		af.sailShip();
	}

	private void fastestShip() {
		af.fastestShip();
	}

	private void longestRangeShip() {
		af.longestRangeShip();
	}

	private void escortShip() {
		af.escort();

	}

	private void commandShip() {
		af.command();
	}

	private void createShip() {
		System.out.println("Please choose beteween a Battleship, Cruiser, Frigate and enter your selction: ");
		String userNameChoice = sc.next();
		System.out.println("Please enter the Speed of the vessal: ");
		double userSpeedChoice = sc.nextDouble();
		System.out.println("Please enter the range you would like for the vessal: ");
		int userRangeChoice = sc.nextInt();
		System.out.println("Please enter the price you are wanting to pay for this model: ");
		long userPriceChoice = sc.nextLong();
		af.addShip(userNameChoice, userSpeedChoice, userRangeChoice, userPriceChoice);

	}

	private void removeShip() {

		af.removeShip();

	}

}
