package emartapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emartapp.model.Cart;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> 
{
	//public Cart findByBuyerId(int buyerId);
}
