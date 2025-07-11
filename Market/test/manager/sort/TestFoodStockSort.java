package manager.sort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import market.stock.Food;
import market.stock.Fruit;
import market.stock.Vegetable;

/**
 * Tests the FoodStockSort class
 */
public class TestFoodStockSort {

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
		foods.add(new Vegetable("Cucumber", false, 6, 3.66));
		
		FoodStockSort f = new FoodStockSort();
		f.sort(foods);
		
		assertEquals("Grape", foods.get(0).getName());
		assertEquals("Watermelon", foods.get(1).getName());
		assertEquals("Cucumber", foods.get(2).getName());
		assertEquals("Carrot", foods.get(3).getName());
		assertEquals("Ginger", foods.get(4).getName());
	}
	
	/**
	 * Tests omitDuplicates method
	 */
	@Test
	public void testOmitDuplicates() {
		ArrayList<Food> foods = new ArrayList<Food>();
		foods.add(new Vegetable("Carrot", false, 80, 2.50));
		foods.add(new Fruit("Watermelon", false, 80, 7.80));
		foods.add(new Vegetable("Ginger", true, 3, 1.35));
		foods.add(new Fruit("Grape", true, 80, 4.00));
		foods.add(new Fruit("Orange", true, 8, 7.50));
		
		
		FoodStockSort f = new FoodStockSort();
		f.omitDuplicates(foods);
		assertEquals(3, foods.size());
	}

}

