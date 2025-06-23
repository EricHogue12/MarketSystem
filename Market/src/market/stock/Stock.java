package market.stock;

import java.util.ArrayList;

import manager.sort.FoodPriceSort;



public class Stock {
	
	private static Stock instance;
	private ArrayList<Food> foods;
	
	private Stock() {
		foods = new ArrayList<Food>();
	}
	
	public static synchronized Stock getInstance() {
		if (instance == null) {
			instance = new Stock();
		}
		
		return instance;
	}
	
	public ArrayList<Food> getFoods() {
		return foods;
	}
	
	public void testingSortingStuff() {
		Food f = new Vegetable("a", true, 5, 6.77);
		foods.add(f);
		
		FoodPriceSort fps = new FoodPriceSort();
		fps.sort(foods);
		
		// need to test out sorting methods
	}
	
	
	
}
