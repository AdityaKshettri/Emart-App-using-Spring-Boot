package emartapp.model;

import java.sql.Date;
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
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Orders
{
	@Id
	@Column(name="orderId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderId;
	
	@Column(name="date")
	@CreationTimestamp
	Date date;

	@ManyToOne
	private Buyer buyer;

	@ManyToMany
	@JoinTable(name = "ORDER_PRODUCT",
		joinColumns = @JoinColumn(name = "orderId"),
		inverseJoinColumns = @JoinColumn(name = "productId"))
	private List<Product> products = new ArrayList<Product>();
	
	public Orders() {}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", date=" + date + ", products=" + products + "]";
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
}
