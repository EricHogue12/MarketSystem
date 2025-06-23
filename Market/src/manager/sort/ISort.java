package manager.sort;

import java.util.ArrayList;

import market.stock.Food;

public interface ISort {

	void sort(ArrayList<Food> foods);
	
	void omitDuplicates(ArrayList<Food> foods);
}
