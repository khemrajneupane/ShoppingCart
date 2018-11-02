
import java.text.DecimalFormat;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShoppingCart {
	// private ArrayList<Item> itemList = new ArrayList<Item>();// Throws error:
	// Exception in thread "main" java.util.ConcurrentModificationException.
	// Because ArrayList does not support concurrency activities especially
	// deleting, adding etc. Hence, the bese
	// solution is to create a CopyOnWriteArrayList.
	private CopyOnWriteArrayList<Item> itemList = new CopyOnWriteArrayList<Item>();

	public ShoppingCart() {

	}

	public void add(Product product, int quantity) {

		itemList.add(new Item(product, quantity));
	}

	public void remove(Product product) {
		for (Item item : itemList) {
			if (product.equals(item.getProduct())) {
				itemList.remove(item);
			}
		}
	}

	public double getTotalPrice() {
		double total = 0.00;
		for (Item items : itemList) {
			total += items.getSubtotal();
		}
		return total;
	}

	public String toString() {
		String message1 = "";
		if (itemList.isEmpty()) {
			message1 = "There are no items in the shopping cart";
		} else {
			DecimalFormat twoDecimal = new DecimalFormat("0.00");
			double total = 0.00;
			double grandTotal = 0.00;
			double priceUnit = 0.00;
			String message = "";
			for (Item item : itemList) {
				total = item.getSubtotal();
				priceUnit = item.getProduct().getProductPrice();

				message += item.getProduct().getProductNum() + ": " + item.getProduct().getProductName()
						+ ", quantity: " + item.getQantity() + ", unit price: " + twoDecimal.format(priceUnit)
						+ ", subtotal: " + twoDecimal.format(total) + "\n";
				grandTotal += total;
			}
			System.out.print("\n=== Shopping cart ===\n");

			return message + "TOTAL PRICE: " + twoDecimal.format(grandTotal) + " euros";
		}
		return message1;
	}

}