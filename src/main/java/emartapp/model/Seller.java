package emartapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Seller 
{
	@Id
	@Column(name="sellerId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int sellerId;

	@Column(name="sellerName")
	String sellerName;
	
	@Column(name="sellerAddress")
	String sellerAddress;
	
	@Column(name="sellerEmail")
	String sellerEmail;
	
	@Column(name="sellerPassword")
	String sellerPassword;
	
	@Column(name="sellerGST")
	String sellerGST;
	
	@Column(name="sellerContact")
	String sellerContact;
	
	@Column(name = "sellerCompany")
	String sellerCompany;
	
	@Column(name = "sellerCompanyDesc")
	String sellerCompanyDesc;
	
	@Column(name = "sellerWebsite")
	String sellerWebsite;
	
	@OneToMany(mappedBy = "seller")
	List<Stock> stocks = new ArrayList<Stock>();
	
	public Seller() {}

	public Seller(String sellerName, String sellerAddress, String sellerEmail, String sellerPassword, String sellerGST,
			String sellerContact, String sellerCompany, String sellerCompanyDesc, String sellerWebsite) {
		this.sellerName = sellerName;
		this.sellerAddress = sellerAddress;
		this.sellerEmail = sellerEmail;
		this.sellerPassword = sellerPassword;
		this.sellerGST = sellerGST;
		this.sellerContact = sellerContact;
		this.sellerCompany = sellerCompany;
		this.sellerCompanyDesc = sellerCompanyDesc;
		this.sellerWebsite = sellerWebsite;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}

	public String getSellerGST() {
		return sellerGST;
	}

	public void setSellerGST(String sellerGST) {
		this.sellerGST = sellerGST;
	}

	public String getSellerContact() {
		return sellerContact;
	}

	public void setSellerContact(String sellerContact) {
		this.sellerContact = sellerContact;
	}

	public String getSellerCompany() {
		return sellerCompany;
	}

	public void setSellerCompany(String sellerCompany) {
		this.sellerCompany = sellerCompany;
	}

	public String getSellerCompanyDesc() {
		return sellerCompanyDesc;
	}

	public void setSellerCompanyDesc(String sellerCompanyDesc) {
		this.sellerCompanyDesc = sellerCompanyDesc;
	}

	public String getSellerWebsite() {
		return sellerWebsite;
	}

	public void setSellerWebsite(String sellerWebsite) {
		this.sellerWebsite = sellerWebsite;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + ", sellerAddress=" + sellerAddress
				+ ", sellerEmail=" + sellerEmail + ", sellerPassword=" + sellerPassword + ", sellerGST=" + sellerGST
				+ ", sellerContact=" + sellerContact + ", sellerCompany=" + sellerCompany + ", sellerCompanyDesc="
				+ sellerCompanyDesc + ", sellerWebsite=" + sellerWebsite + "]";
	}
	
}
