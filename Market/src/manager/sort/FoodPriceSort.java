package manager.sort;

import java.util.ArrayList;

import market.stock.Food;

public class FoodPriceSort implements ISort {

	public void sort(ArrayList<Food> foods){
		for (int i = 0; i < foods.size() - 1; i++) {
			int maxIndex = i;
			for (int j = i+1; j < foods.size(); j++) {
				if (foods.get(j).getPrice() > foods.get(maxIndex).getPrice()) {
					maxIndex = j;
				}
			}
			if (maxIndex != i) {
				Food temp = foods.remove(i);
				foods.add(i, foods.get(maxIndex));
				foods.remove(maxIndex);
				foods.add(maxIndex, temp);
				
			}
		}
	}
	
	public void omitDuplicates(ArrayList<Food> foods){
		double[] temp = new double[foods.size()];
		for (Food f: foods) {
			for (int i = 0; i < temp.length; i++) {
				if (f.getPrice() == temp[i]) {
					foods.remove(f);
				}
			}
		}
	}
	
}
