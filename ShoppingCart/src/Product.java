
public class Product {
	private int productNum;
	private double productPrice;
	private String productName;

	public Product() {
		productNum = 0;
		productPrice = 0.00;
		productName = "";
		
	}
	public Product(int productNum, String productName, double productPrice) {
		this.productNum = productNum;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	
	public int getProductNum() {
		return productNum;
	}

	public double getProductPrice() {
		
		return productPrice;
	}

	public String getProductName() {
		return productName;
	}

}
