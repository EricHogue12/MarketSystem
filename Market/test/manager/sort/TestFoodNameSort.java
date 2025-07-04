package manager.sort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import market.stock.Food;
import market.stock.Fruit;
import market.stock.Vegetable;


public class TestFoodNameSort {

	@Test
	public void testSort() {
		ArrayList<Food> foods = new ArrayList<Food>();
		foods.add(new Vegetable("Carrot", false, 5, 2.50));
		foods.add(new Fruit("Watermelon", false, 6, 7.80));
		foods.add(new Vegetable("Ginger", true, 3, 1.35));
		foods.add(new Fruit("Grape", true, 80, 4.00));
		
		FoodNameSort f = new FoodNameSort();
		f.sort(foods);
		
		assertEquals("Carrot", foods.get(0).getName());
		assertEquals("Ginger", foods.get(1).getName());
		assertEquals("Grape", foods.get(2).getName());
		assertEquals("Watermelon", foods.get(3).getName());
	}
	
	@Test
	public void testOmitDuplicates() {
		ArrayList<Food> foods = new ArrayList<Food>();
		foods.add(new Vegetable("Carrot", false, 5, 2.50));
		foods.add(new Fruit("Watermelon", false, 6, 7.80));
		foods.add(new Vegetable("Ginger", true, 3, 1.35));
		foods.add(new Fruit("Grape", true, 80, 4.00));
		foods.add(new Fruit("Watermelon", true, 8, 7.50));
		
		FoodNameSort f = new FoodNameSort();
		f.omitDuplicates(foods);
		assertEquals(4, foods.size());
	}

}
