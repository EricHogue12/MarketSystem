package market.stock;

public class Dairy extends Food {

	public static int dairyCounter = 0;
	public final static int MAX_DAIRY = 10;
	
	public Dairy(String name, boolean byWeight, int stock, double price) {
		super(name, byWeight, stock, price);
		dairyCounter++;
	}
	
}
