package emartapp.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Buyer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "buyerId")
	private int buyerId; 
	
	@Column(name = "buyerName")
	private String buyerName;

	@Column(name="buyerEmail")
    String buyerEmail;
    
	@Column(name="buyerPassword")
    String buyerPassword;
    
	@Column(name="buyerPhone")
	String buyerPhone;
	
	@CreationTimestamp
	Date createdDateTime;
	
	@OneToOne
	private Cart cart;
	
	@OneToMany(mappedBy = "buyer")
	private List<Orders> orders = new ArrayList<Orders>();

	public Buyer() {}

	public Buyer(String buyerName, String buyerEmail, String buyerPassword, String buyerPhone) {
		this.buyerName = buyerName;
		this.buyerEmail = buyerEmail;
		this.buyerPassword = buyerPassword;
		this.buyerPhone = buyerPhone;
	}

	@Override
	public String toString() {
		return "Buyer [buyerId=" + buyerId + ", buyerName=" + buyerName + ", buyerEmail=" + buyerEmail
				+ ", buyerPassword=" + buyerPassword + ", buyerPhone=" + buyerPhone + ", createdDateTime=" + createdDateTime + "]";
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getBuyerPassword() {
		return buyerPassword;
	}

	public void setBuyerPassword(String buyerPassword) {
		this.buyerPassword = buyerPassword;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Orders order)
	{
		this.orders.add(order);
	}
	
	public void removeOrder(Orders order)
	{
		this.orders.remove(order);
	}
}
