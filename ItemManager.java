import java.util.ArrayList;
import java.util.List;

public class ItemManager {
private List<Product> Product = new ArrayList<Product>();
	
	public Product createProducts (String name, String price, int amount) {
		return new Product (name, price, amount);
	}
	
	public void add (Product Product) {
		Product.add(Product);
	}
	
	public void removeProduct (Product Product) {
		Product.remove(Product);
	}
	
	public void removeProduct (int ProduktIndex) {
		Product.remove(ProductIndex);
	}
	
	public List<Product> getItems () {
		return Product;
	}
}
