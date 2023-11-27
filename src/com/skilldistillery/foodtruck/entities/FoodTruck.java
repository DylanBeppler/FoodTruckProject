package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private String name;
	private String foodType;
	private double rating;

	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public FoodTruck(String name, String foodType, double rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}

	public String toString() {
		return "Food Truck Name = " + name + ", Food Type = " + foodType + ", Rating = " + rating;
	}
}
