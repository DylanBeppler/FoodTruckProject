package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	private FoodTruck[] fleet = new FoodTruck[5];
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.run();
	}

	public void run() {
		int option;
		do {
			displayMenu();
			option = sc.nextInt();
			sc.nextLine(); 

			switch (option) {
			case 1:
				inputFoodTrucks();
				break;
			case 2:
				listFoodTrucks();
				break;
			case 3:
				displayAverageRating();
				break;
			case 4:
				displayHighestRated();
				break;
			case 5:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		} while (option != 5);

		
		sc.close();
	}

	private void displayMenu() {
		System.out.println("______ Menu ______");
		System.out.println("1. Input Food Trucks");
		System.out.println("2. List All Food Trucks");
		System.out.println("3. Average Rating of Food Trucks");
		System.out.println("4. Display Highest Rated Food Truck");
		System.out.println("5. Quit");
		System.out.print("Enter your choice: ");
	}

	void inputFoodTrucks() {
		for (int i = 0; i < fleet.length; i++) {
			System.out.println("Please input the food truck name, or type 'quit' to exit:");
			String name = sc.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				break; 
			}

			System.out.println("Food type:");
			String foodType = sc.nextLine();

			System.out.println("Rating (1-5):");
			double rating = sc.nextDouble();
			sc.nextLine(); 

			fleet[i] = new FoodTruck(name, foodType, rating);
		}
	}

	void listFoodTrucks() {
		System.out.println("______ List of Food Trucks ______");
		for (FoodTruck truck : fleet) {
			if (truck != null) {
				System.out.println(truck);
			}
		}
	}

	void displayAverageRating() {
		double sum = 0;
		int count = 0;
		for (FoodTruck truck : fleet) {
			if (truck != null) {
				sum += truck.getRating();
				count++;
			}
		}
		if (count > 0) {
			double averageRating = sum / count;
			System.out.println("Average Rating of Food Trucks: " + averageRating);
		} else {
			System.out.println("No food trucks to calculate the average rating.");
		}
	}

	void displayHighestRated() {
		FoodTruck highestRated = null;
		for (FoodTruck truck : fleet) {
			if (truck != null) {
				if (highestRated == null || truck.getRating() > highestRated.getRating()) {
					highestRated = truck;
				}
			}
		}

		if (highestRated != null) {
			System.out.println("______ Highest Rated Food Truck ______");
			System.out.println(highestRated);
		} else {
			System.out.println("No food trucks to display the highest rated truck.");
		}
	}
}

