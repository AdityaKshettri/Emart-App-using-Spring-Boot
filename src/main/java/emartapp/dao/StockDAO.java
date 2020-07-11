package emartapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emartapp.model.Stock;

@Repository
public interface StockDAO extends JpaRepository<Stock, Integer>
{
	public Stock findByStockId(int stockId);
}
