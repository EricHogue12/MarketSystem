package manager.sort;

import java.util.ArrayList;

import market.stock.Food;


public class FoodNameSort implements ISort {

	public void sort(ArrayList<Food> foods){
		for (int i = 0; i < foods.size() - 1; i++) {
			int minIndex = i;
			for (int j = i+1; j < foods.size(); j++) {
				if (foods.get(i).getName().compareTo(foods.get(minIndex).getName()) > 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				Food temp = foods.remove(i);
				foods.add(i, foods.get(minIndex));
				foods.remove(minIndex);
				foods.add(minIndex, temp);
				
			}
		}
	}
	
	public void omitDuplicates(ArrayList<Food> foods){
		String[] temp = new String[foods.size()];
		for (Food f: foods) {
			for (int i = 0; i < temp.length; i++) {
				if (f.getName().equals(temp[i])) {
					foods.remove(f);
				}
			}
		}
	}
}
