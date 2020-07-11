package emartapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emartapp.model.Buyer;

@Repository
public interface BuyerDAO extends JpaRepository<Buyer, Integer>
{
	public Buyer findByBuyerName(String buyerName);
}
