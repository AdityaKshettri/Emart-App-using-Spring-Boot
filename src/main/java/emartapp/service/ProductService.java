package emartapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emartapp.dao.ProductDAO;
import emartapp.model.Product;

@Service
public class ProductService 
{
	@Autowired
	private ProductDAO productDAO;
	
	public Product findByProductId(int id)
	{
		return productDAO.findByProductId(id);
	}
	
	public List<Product> findAll()
	{
		return productDAO.findAll();
	}
	
	public void save(Product theProduct)
	{
		productDAO.save(theProduct);
	}
	
	
}
