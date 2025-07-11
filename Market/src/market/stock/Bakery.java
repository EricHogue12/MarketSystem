package market.stock;

/**
 * Bakery food category
 */
public class Bakery extends Food {

	public static int bakeryCounter = 0;
	public final static int MAX_BAKERY = 10;
	
	public Bakery(String name, boolean byWeight, int stock, double price) {
		super(name, byWeight, stock, price);
		bakeryCounter++;
	}
	
}
