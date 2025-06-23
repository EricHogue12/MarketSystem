package market.stock;


public class Vegetable extends Food {
	
	public static int vegetableCounter = 0;
	public final static int MAX_VEGETABLES = 10;
	
	public Vegetable(String name, boolean byWeight, int stock, double price) {
		super(name, byWeight, stock, price);
		vegetableCounter++;
	}
	
	
}
