package emartapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emartapp.dao.BuyerDAO;
import emartapp.model.Buyer;
import emartapp.model.User;

@Service
public class BuyerService 
{
	@Autowired
	private BuyerDAO buyerDAO;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userService;
	
	public List<Buyer> findAll() {
		return buyerDAO.findAll();
	}
	
	public void createBuyer(Buyer theBuyer)
	{
		save(theBuyer);
		User user = new User(theBuyer.getBuyerName(), theBuyer.getBuyerPassword(), "BUYER");
		userService.save(user);
		cartService.createBuyerCart(theBuyer);
	}
	
	public void save(Buyer theBuyer)
	{
		buyerDAO.save(theBuyer);
	}
	
	public Buyer getCurrentBuyer()
	{
		String currentUsername = userService.getCurrentUsername();
		Buyer currentBuyer = buyerDAO.findByBuyerName(currentUsername);
		return currentBuyer;
	}
	
	public boolean isBuyer()
	{
		if(getCurrentBuyer() == null) {
			return false;
		}
		return true;
	}
}
