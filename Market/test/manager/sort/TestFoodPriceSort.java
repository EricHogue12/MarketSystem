package manager.sort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import market.stock.Food;
import market.stock.Fruit;
import market.stock.Vegetable;

/**
 * Tests the FoodPriceSort class
 */
public class TestFoodPriceSort {

	/**
	 * Tests sort method
	 */
	@Test
	public void testSort() {
		ArrayList<Food> foods = new ArrayList<Food>();
		foods.add(new Vegetable("Carrot", false, 5, 2.50));
		foods.add(new Fruit("Watermelon", false, 6, 7.80));
		foods.add(new Vegetable("Ginger", true, 3, 1.35));
		foods.add(new Fruit("Grape", true, 80, 4.00));
		foods.add(new Vegetable("Asparagus", false, 8, 1.35));
		
		FoodPriceSort f = new FoodPriceSort();
		f.sort(foods);
		
		assertEquals("Ginger", foods.get(0).getName());
		assertEquals("Asparagus", foods.get(1).getName());
		assertEquals("Carrot", foods.get(2).getName());
		assertEquals("Grape", foods.get(3).getName());
		assertEquals("Watermelon", foods.get(4).getName());
	}
	
	/**
	 * Tests omitDuplicates method
	 */
	@Test
	public void testOmitDuplicates() {
		ArrayList<Food> foods = new ArrayList<Food>();
		foods.add(new Vegetable("Carrot", false, 5, 2.50));
		foods.add(new Fruit("Watermelon", false, 6, 7.80));
		foods.add(new Vegetable("Ginger", true, 3, 1.35));
		foods.add(new Fruit("Grape", true, 80, 4.00));
		foods.add(new Fruit("Orange", true, 8, 4.00));
		
		FoodPriceSort f = new FoodPriceSort();
		f.omitDuplicates(foods);
		assertEquals(4, foods.size());
	}

}
