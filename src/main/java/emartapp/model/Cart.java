package emartapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart 
{
	@Id
	@Column(name = "cartId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@ManyToMany
	@JoinTable(name = "CART_PRODUCT",
		joinColumns = @JoinColumn(name = "cartId"),
		inverseJoinColumns = @JoinColumn(name = "productId"))
	private List<Product> products = new ArrayList<Product>();
	
	@OneToOne(mappedBy = "cart")
	private Buyer buyer;

	public Cart() {}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + "]";
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public void addProductToCart(Product product) {
		this.products.add(product);
	}

	public void removeProductFromCart(Product product) {
		this.products.remove(product);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void removeCartProducts() {
		this.products.removeAll(products);
	}
	
}
