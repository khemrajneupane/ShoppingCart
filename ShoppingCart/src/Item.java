//Item Object that has parameter of Product object and product quantity.

public class Item {
	private Product product;
	private int quantity;

	public Item() {
		product = null;
		quantity = 0;
	}

	public Item(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQantity() {
		return quantity;
	}

	public double getSubtotal() {
		return product.getProductPrice() * quantity;
	}

}
