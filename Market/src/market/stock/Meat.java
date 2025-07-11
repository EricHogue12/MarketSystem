package market.stock;

/**
 * Meat food category 
 */
public class Meat extends Food {

	public static int meatCounter = 0;
	public final static int MAX_MEATS = 10;
	
	public Meat(String name, boolean byWeight, int stock, double price) {
		super(name, byWeight, stock, price);
		meatCounter++;
	}
	
}
