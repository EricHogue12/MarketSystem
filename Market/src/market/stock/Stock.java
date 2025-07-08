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
	
	public int getStockCount() {
		int ret = 0;
		for (Food f: foods) {
			ret += f.getStock();
		}
		return ret;
	}
	
	public int itemCount() {
		return foods.size();
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
	
	public void reduceFoodPrice(int idx, String category){
		
		if (idx < 0 || idx >= foods.size()) {
			throw new IllegalArgumentException("Invalid index");
		}
		
		if ("Vegetable".equals(category)) {
			getVegetables().get(idx).setPrice(0.25);
		}
		else if ("Fruit".equals(category)) {
			getFruits().get(idx).setPrice(0.25);
		}
		else if ("Meat".equals(category)) {
			getMeats().get(idx).setPrice(0.25);
		}
		else if ("Dairy".equals(category)) {
			getDairy().get(idx).setPrice(0.25);
		}
		else if ("Bakery".equals(category)) {
			getBakery().get(idx).setPrice(0.25);
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
	
	public void incrementFoodStockTen(int idx, String category){
		
		if (idx < 0 || idx >= foods.size()) {
			throw new IllegalArgumentException("Invalid index");
		}
		
		if ("Vegetable".equals(category)) {
			int newStock = getVegetables().get(idx).getStock() + 10;
			getVegetables().get(idx).setStock(newStock);
		}
		else if ("Fruit".equals(category)) {
			int newStock = getFruits().get(idx).getStock() + 10;
			getFruits().get(idx).setStock(newStock);
		}
		else if ("Meat".equals(category)) {
			int newStock = getMeats().get(idx).getStock() + 10;
			getMeats().get(idx).setStock(newStock);
		}
		else if ("Dairy".equals(category)) {
			int newStock = getDairy().get(idx).getStock() + 10;
			getDairy().get(idx).setStock(newStock);
		}
		else if ("Bakery".equals(category)) {
			int newStock = getBakery().get(idx).getStock() + 10;
			getBakery().get(idx).setStock(newStock);
		}
		else {
			throw new IllegalArgumentException("Invalid food category");
		}
		
	}
	
	public void reduceFoodStock(int idx, String category){
		
		if (idx < 0 || idx >= foods.size()) {
			throw new IllegalArgumentException("Invalid index");
		}
		
		if ("Vegetable".equals(category)) {
			getVegetables().get(idx).setStock(1);
		}
		else if ("Fruit".equals(category)) {
			getFruits().get(idx).setStock(1);
		}
		else if ("Meat".equals(category)) {
			getMeats().get(idx).setStock(1);
		}
		else if ("Dairy".equals(category)) {
			getDairy().get(idx).setStock(1);
		}
		else if ("Bakery".equals(category)) {
			getBakery().get(idx).setStock(1);
		}
		else {
			throw new IllegalArgumentException("Invalid food category");
		}
		
		
	}
	
	
	
	
	public String[] sorted(String sortField, String category) {
		String[] ret;
		
		
		if ("name".equals(sortField)) {
			FoodNameSort n = new FoodNameSort();
			n.sort(foods);
		}
		else if ("price".equals(sortField)) {
			FoodPriceSort p = new FoodPriceSort();
			p.sort(foods);
		}
		else if ("stock".equals(sortField)) {
			FoodStockSort s = new FoodStockSort();
			s.sort(foods);
		}
		else {
			throw new IllegalArgumentException("Invalid sort instructions");
		}
		
		if ("Vegetable".equals(category)) {
			ret = new String[getVegetables().size()];
			for (int i = 0; i < getVegetables().size(); i++) {
				ret[i] = getVegetables().get(i).getName();
			}
		}
		else if ("Fruit".equals(category)) {
			ret = new String[getFruits().size()];
			for (int i = 0; i < getFruits().size(); i++) {
				ret[i] = getFruits().get(i).getName();
			}
		}
		else if ("Meat".equals(category)) {
			ret = new String[getMeats().size()];
			for (int i = 0; i < getMeats().size(); i++) {
				ret[i] = getMeats().get(i).getName();
			}
		}
		else if ("Dairy".equals(category)) {
			ret = new String[getDairy().size()];
			for (int i = 0; i < getDairy().size(); i++) {
				ret[i] = getDairy().get(i).getName();
			}
		}
		else if ("Bakery".equals(category)) {
			ret = new String[getBakery().size()];
			for (int i = 0; i < getBakery().size(); i++) {
				ret[i] = getBakery().get(i).getName();
			}
		}
		else {
			throw new IllegalArgumentException("Invalid food category for sort");
		}
		
		return ret;
		
	}
	
	
	
	public void resetStock() {
		instance = new Stock();
	}
	
	
	
}
