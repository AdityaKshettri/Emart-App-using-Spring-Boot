package emartapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import emartapp.model.Product;
import emartapp.model.Stock;
import emartapp.service.BuyerService;
import emartapp.service.ProductService;
import emartapp.service.SellerService;

@Controller
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/list")
	public String getProducts(Model model)
	{
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		model.addAttribute("isBuyer", buyerService.isBuyer());
		model.addAttribute("isSeller", sellerService.isSeller());
		return "product-list";
	}
	
	@GetMapping("/add")
	public String addProduct(Model model)
	{
		Product theProduct = new Product();
		model.addAttribute("theProduct", theProduct);
		model.addAttribute("isBuyer", buyerService.isBuyer());
		model.addAttribute("isSeller", sellerService.isSeller());
		return "product-add-form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("theProduct") Product theProduct, Model model)
	{
		productService.save(theProduct);
		Stock theStock = new Stock();
		model.addAttribute("theStock", theStock);
		model.addAttribute("theProduct", theProduct);
		model.addAttribute("isBuyer", buyerService.isBuyer());
		model.addAttribute("isSeller", sellerService.isSeller());
		return "stock-form";
	}
	
}
