package manager.sort;

import java.util.ArrayList;

import market.stock.Food;


public class FoodNameSort implements ISort {

	public void sort(ArrayList<Food> foods){
		for (int i = 0; i < foods.size() - 1; i++) {
			int minIndex = i;
			for (int j = i+1; j < foods.size(); j++) {
				if (foods.get(j).getName().compareTo(foods.get(minIndex).getName()) < 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				Food tempMin = foods.get(minIndex);
				Food temp = foods.remove(i);
				foods.add(i, tempMin);
				foods.remove(minIndex);
				foods.add(minIndex, temp);				
			}
		}
	}
	
	public void omitDuplicates(ArrayList<Food> foods){
		for (int i = 0; i < foods.size(); i++) {
			for (int j = i + 1; j < foods.size(); j++) {
				if (foods.get(i) != null && foods.get(j) != null) {
					if (foods.get(i).getName().equals(foods.get(j).getName())) {
						foods.remove(j);
						foods.add(j, null);
					}
				}
			}
		}
		
		while(foods.remove(null));
		
	}
}
