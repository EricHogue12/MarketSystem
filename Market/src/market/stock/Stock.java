package market.stock;

import java.util.ArrayList;

import manager.sort.FoodNameSort;
import manager.sort.FoodPriceSort;
import manager.sort.FoodStockSort;



public class Stock {
	
	private static Stock instance;
	private ArrayList<Food> foods;
	
	private Stock() {
		foods = new ArrayList<Food>();
	}
	
	public static synchronized Stock getInstance() {
		if (instance == null) {
			instance = new Stock();
		}
		
		return instance;
	}
	
	public ArrayList<Food> getFoods() {
		return foods;
	}
	
	public ArrayList<Food> getVegetables(){
		ArrayList<Food> v = new ArrayList<Food>();
		for (Food f: foods) {
			if (f instanceof Vegetable) {
				v.add(f);
			}
		}
		return v;
	}
	
	public ArrayList<Food> getFruits(){
		ArrayList<Food> fr = new ArrayList<Food>();
		for (Food f: foods) {
			if (f instanceof Fruit) {
				fr.add(f);
			}
		}
		return fr;
	}
	
	public ArrayList<Food> getMeats(){
		ArrayList<Food> m = new ArrayList<Food>();
		for (Food f: foods) {
			if (f instanceof Meat) {
				m.add(f);
			}
		}
		return m;
	}
	
	public ArrayList<Food> getDairy(){
		ArrayList<Food> d = new ArrayList<Food>();
		for (Food f: foods) {
			if (f instanceof Dairy) {
				d.add(f);
			}
		}
		return d;
	}
	
	public ArrayList<Food> getBakery(){
		ArrayList<Food> b = new ArrayList<Food>();
		for (Food f: foods) {
			if (f instanceof Bakery) {
				b.add(f);
			}
		}
		return b;
	}
	
	public void addVegetable(String name, boolean byWeight, int stock, double price) {
		Vegetable v = new Vegetable(name, byWeight, stock, price);
		for (Food f: foods) {
			if (f.equals(v)) {
				throw new IllegalArgumentException("Duplicate vegetables");
			}
		}
		foods.add(v);
	}
	
	public void addFruit(String name, boolean byWeight, int stock, double price) {
		Fruit fr = new Fruit(name, byWeight, stock, price);
		for (Food f: foods) {
			if (f.equals(fr)) {
				throw new IllegalArgumentException("Duplicate fruits");
			}
		}
		foods.add(fr);
	}
	
	public void addMeat(String name, boolean byWeight, int stock, double price) {
		Meat m = new Meat(name, byWeight, stock, price);
		for (Food f: foods) {
			if (f.equals(m)) {
				throw new IllegalArgumentException("Duplicate meats");
			}
		}
		foods.add(m);
	}
	
	public void addDairy(String name, boolean byWeight, int stock, double price) {
		Dairy d = new Dairy(name, byWeight, stock, price);
		for (Food f: foods) {
			if (f.equals(d)) {
				throw new IllegalArgumentException("Duplicate dairy items");
			}
		}
		foods.add(d);
	}
	
	public void addBakery(String name, boolean byWeight, int stock, double price) {
		Bakery b = new Bakery(name, byWeight, stock, price);
		for (Food f: foods) {
			if (f.equals(b)) {
				throw new IllegalArgumentException("Duplicate bakery items");
			}
		}
		foods.add(b);
	}
	
	public void removeFoodByIndex(int idx, String category) {
		ArrayList<Food> foodCat = new ArrayList<Food>();
		Food rem = null;
		
		if (idx < 0 || idx >= foods.size()) {
			throw new IllegalArgumentException("Invalid index");
		}
		
		if ("Vegetable".equals(category)) {
			foodCat = getVegetables();
			rem = foodCat.get(idx);
		}
		else if ("Fruit".equals(category)) {
			foodCat = getFruits();
			rem = foodCat.get(idx);
		}
		else if ("Meat".equals(category)) {
			foodCat = getMeats();
			rem = foodCat.get(idx);
		}
		else if ("Dairy".equals(category)) {
			foodCat = getDairy();
			rem = foodCat.get(idx);
		}
		else if ("Bakery".equals(category)) {
			foodCat = getBakery();
			rem = foodCat.get(idx);
		}
		
		foods.remove(rem);
	}
	
	public void increaseFoodPriceByCent(int idx, String category){
		
		if (idx < 0 || idx >= foods.size()) {
			throw new IllegalArgumentException("Invalid index");
		}
		
		if ("Vegetable".equals(category)) {
			double newPrice = getVegetables().get(idx).getPrice() + 0.01;
			getVegetables().get(idx).setPrice(newPrice);
		}
		else if ("Fruit".equals(category)) {
			double newPrice = getFruits().get(idx).getPrice() + 0.01;
			getFruits().get(idx).setPrice(newPrice);
		}
		else if ("Meat".equals(category)) {
			double newPrice = getMeats().get(idx).getPrice() + 0.01;
			getMeats().get(idx).setPrice(newPrice);
		}
		else if ("Dairy".equals(category)) {
			double newPrice = getDairy().get(idx).getPrice() + 0.01;
			getDairy().get(idx).setPrice(newPrice);
		}
		else if ("Bakery".equals(category)) {
			double newPrice = getBakery().get(idx).getPrice() + 0.01;
			getBakery().get(idx).setPrice(newPrice);
		}
		else {
			throw new IllegalArgumentException("Invalid food category");
		}
		
		
	}
	
	public void increaseFoodPriceByDollar(int idx, String category){
		
		if (idx < 0 || idx >= foods.size()) {
			throw new IllegalArgumentException("Invalid index");
		}
		
		if ("Vegetable".equals(category)) {
			double newPrice = getVegetables().get(idx).getPrice() + 1.00;
			getVegetables().get(idx).setPrice(newPrice);
		}
		else if ("Fruit".equals(category)) {
			double newPrice = getFruits().get(idx).getPrice() + 1.00;
			getFruits().get(idx).setPrice(newPrice);
		}
		else if ("Meat".equals(category)) {
			double newPrice = getMeats().get(idx).getPrice() + 1.00;
			getMeats().get(idx).setPrice(newPrice);
		}
		else if ("Dairy".equals(category)) {
			double newPrice = getDairy().get(idx).getPrice() + 1.00;
			getDairy().get(idx).setPrice(newPrice);
		}
		else if ("Bakery".equals(category)) {
			double newPrice = getBakery().get(idx).getPrice() + 1.00;
			getBakery().get(idx).setPrice(newPrice);
		}
		else {
			throw new IllegalArgumentException("Invalid food category");
		}
		
		
	}
	
	public void incrementFoodStock(int idx, String category){
		
		if (idx < 0 || idx >= foods.size()) {
			throw new IllegalArgumentException("Invalid index");
		}
		
		if ("Vegetable".equals(category)) {
			int newStock = getVegetables().get(idx).getStock() + 1;
			getVegetables().get(idx).setStock(newStock);
		}
		else if ("Fruit".equals(category)) {
			int newStock = getFruits().get(idx).getStock() + 1;
			getFruits().get(idx).setStock(newStock);
		}
		else if ("Meat".equals(category)) {
			int newStock = getMeats().get(idx).getStock() + 1;
			getMeats().get(idx).setStock(newStock);
		}
		else if ("Dairy".equals(category)) {
			int newStock = getDairy().get(idx).getStock() + 1;
			getDairy().get(idx).setStock(newStock);
		}
		else if ("Bakery".equals(category)) {
			int newStock = getBakery().get(idx).getStock() + 1;
			getBakery().get(idx).setStock(newStock);
		}
		else {
			throw new IllegalArgumentException("Invalid food category");
		}
		
		
	}
	
	public void decrementFoodStock(int idx, String category){
		
		if (idx < 0 || idx >= foods.size()) {
			throw new IllegalArgumentException("Invalid index");
		}
		
		if ("Vegetable".equals(category)) {
			int newStock = getVegetables().get(idx).getStock() - 1;
			getVegetables().get(idx).setStock(newStock);
		}
		else if ("Fruit".equals(category)) {
			int newStock = getFruits().get(idx).getStock() - 1;
			getFruits().get(idx).setStock(newStock);
		}
		else if ("Meat".equals(category)) {
			int newStock = getMeats().get(idx).getStock() - 1;
			getMeats().get(idx).setStock(newStock);
		}
		else if ("Dairy".equals(category)) {
			int newStock = getDairy().get(idx).getStock() - 1;
			getDairy().get(idx).setStock(newStock);
		}
		else if ("Bakery".equals(category)) {
			int newStock = getBakery().get(idx).getStock() - 1;
			getBakery().get(idx).setStock(newStock);
		}
		else {
			throw new IllegalArgumentException("Invalid food category");
		}
		
		
	}
	
	
	
	
	public ArrayList<Food> sorted(String sortField, String category) {
		ArrayList<Food> ret = new ArrayList<Food>();
		
		if ("Vegetable".equals(category)) {
			ret = getVegetables();
		}
		else if ("Fruit".equals(category)) {
			ret = getFruits();
		}
		else if ("Meat".equals(category)) {
			ret = getMeats();
		}
		else if ("Dairy".equals(category)) {
			ret = getDairy();
		}
		else if ("Bakery".equals(category)) {
			ret = getBakery();
		}
		else {
			throw new IllegalArgumentException("Invalid food category for sort");
		}
		
		
		if ("name".equals(sortField)) {
			FoodNameSort n = new FoodNameSort();
			n.sort(ret);
		}
		else if ("price".equals(sortField)) {
			FoodPriceSort p = new FoodPriceSort();
			p.sort(ret);
		}
		else if ("stock".equals(sortField)) {
			FoodStockSort s = new FoodStockSort();
			s.sort(ret);
		}
		else {
			throw new IllegalArgumentException("Invalid sort instructions");
		}
		
		return ret;
	}
	
	
	public void clearStock() {
		instance = new Stock();
	}
	
	
	
}
