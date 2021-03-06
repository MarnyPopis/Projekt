import java.util.ArrayList;
import java.util.List;

public class ItemManager {
private List<Product> listProducts = new ArrayList<Product>();
private DoUsers dbProducts = new DoUsers();
	
	public Product createProducts (String name, String price, int amount) {
		return new Product (name, price, amount);
	}
	
	public void addProduct (Product Product) throws Exception {
		dbProducts.addProduct(Product);
		listProducts.add(Product);
	}
	
	public void removeProduct (Product Product) {
		listProducts.remove(Product);
	}
	
	public void removeProduct (int ProductIndex) {
		listProducts.remove(ProductIndex);
	}
	
	public List<Product> getProduct () {
		return listProducts;
	}
}