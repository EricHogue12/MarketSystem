package manager.sort;

import java.util.ArrayList;

import market.stock.Food;


public class FoodStockSort implements ISort {

	public void sort(ArrayList<Food> foods){
		for (int i = 0; i < foods.size() - 1; i++) {
			int maxIndex = i;
			for (int j = i+1; j < foods.size(); j++) {
				if (foods.get(j).getStock() > foods.get(maxIndex).getStock()) {
					maxIndex = j;
				}
			}
			if (maxIndex != i) {
				Food tempMax = foods.get(maxIndex);
				Food temp = foods.remove(i);
				foods.add(i, tempMax);
				foods.remove(maxIndex);
				foods.add(maxIndex, temp);
				
			}
		}
	}
	
	public void omitDuplicates(ArrayList<Food> foods){
		for (int i = 0; i < foods.size(); i++) {
			for (int j = i + 1; j < foods.size(); j++) {
				if (foods.get(i) != null && foods.get(j) != null) {
					if (foods.get(i).getStock() == foods.get(j).getStock()) {
						foods.remove(j);
						foods.add(j, null);
					}
				}
			}
		}
		
		while(foods.remove(null));
		
	}
}
