package manager.sort;

import java.util.ArrayList;


import market.stock.Food;

/**
 * Interface for sorting food lists in customer/manager view
 */
public interface ISort {

	/**
	 * Sorts the passed ArrayList based on a certain field
	 * @param foods the ArrayList of foods passed
	 */
	void sort(ArrayList<Food> foods);
	
	/**
	 * Makes sure there are no duplicates in the list
	 * @param foods the ArrayList of foods passed
	 */
	void omitDuplicates(ArrayList<Food> foods);
}
