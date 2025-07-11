package market.stock;

/**
 * Fruit food category 
 */
public class Fruit extends Food {

	public static int fruitCounter = 0;
	public final static int MAX_FRUITS = 10;
	
	public Fruit(String name, boolean byWeight, int stock, double price) {
		super(name, byWeight, stock, price);
		fruitCounter++;
	}
	
}
