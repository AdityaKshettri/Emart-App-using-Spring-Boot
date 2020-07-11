package emartapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import emartapp.model.Buyer;
import emartapp.model.Cart;
import emartapp.model.Orders;
import emartapp.model.Product;
import emartapp.service.BuyerService;
import emartapp.service.CartService;
import emartapp.service.OrderService;
import emartapp.service.SellerService;

@Controller
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/list")
	public String getOrders(Model model)
	{
		Buyer currentBuyer = buyerService.getCurrentBuyer();
		List<Orders> orders = currentBuyer.getOrders();
		model.addAttribute("orders", orders);
		model.addAttribute("isBuyer", buyerService.isBuyer());
		model.addAttribute("isSeller", sellerService.isSeller());
		return "orders";
	}
	
	@GetMapping("")
	public String order()
	{
		Orders order = new Orders();
		Buyer currentBuyer = buyerService.getCurrentBuyer();
		Cart theCart = currentBuyer.getCart();
		List<Product> products = theCart.getProducts();
		List<Product> orderProducts = new ArrayList<Product>(products);
		order.setProducts(orderProducts);
		order.setBuyer(currentBuyer);
		orderService.save(order);
		theCart.removeCartProducts();
		cartService.save(theCart);
		return "redirect:/order/list";
	}
}
