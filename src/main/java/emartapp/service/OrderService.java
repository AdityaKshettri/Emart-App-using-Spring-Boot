package emartapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emartapp.dao.OrderDAO;
import emartapp.model.Orders;

@Service
public class OrderService 
{
	@Autowired
	private OrderDAO orderDAO;
	
	public void save(Orders theOrder)
	{
		orderDAO.save(theOrder);
	}
}
