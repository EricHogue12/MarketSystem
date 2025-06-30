package manager.sort;

import java.util.ArrayList;

import market.stock.Food;

public class FoodPriceSort implements ISort {

	public void sort(ArrayList<Food> foods){
		for (int i = 0; i < foods.size() - 1; i++) {
			int minIndex = i;
			for (int j = i+1; j < foods.size(); j++) {
				if (foods.get(j).getPrice() < foods.get(minIndex).getPrice()) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				Food tempMax = foods.get(minIndex);
				Food temp = foods.remove(i);
				foods.add(i, tempMax);
				foods.remove(minIndex);
				foods.add(minIndex, temp);
				
			}
		}
	}
	
	public void omitDuplicates(ArrayList<Food> foods){
		for (int i = 0; i < foods.size(); i++) {
			for (int j = i + 1; j < foods.size(); j++) {
				if (foods.get(i) != null && foods.get(j) != null) {
					if (foods.get(i).getPrice() == foods.get(j).getPrice()) {
						foods.remove(j);
						foods.add(j, null);
					}
				}
			}
		}
		
		while(foods.remove(null));
		
	}
	
}
