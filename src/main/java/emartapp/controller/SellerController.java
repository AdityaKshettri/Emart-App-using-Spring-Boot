package emartapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import emartapp.model.Seller;
import emartapp.model.Stock;
import emartapp.service.BuyerService;
import emartapp.service.SellerService;

@Controller
@RequestMapping("/seller")
public class SellerController 
{
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private BuyerService buyerService;

	@GetMapping("/list")
	public String listSellers(Model model)
	{
		List<Seller> sellers = sellerService.findAll();
		model.addAttribute("sellers", sellers);
		model.addAttribute("isSeller", sellerService.isSeller());
		model.addAttribute("isBuyer", buyerService.isBuyer());
		return "seller-list";
	}
	
	@GetMapping("/signup")
	public String formForAdd(Model model)
	{
		Seller theSeller = new Seller();
		model.addAttribute("theSeller", theSeller);
		model.addAttribute("isSeller", sellerService.isSeller());
		model.addAttribute("isBuyer", buyerService.isBuyer());
		return "seller-signup-form";
	}
	
	@PostMapping("/save")
	public String saveSeller(@ModelAttribute("theSeller") Seller theSeller)
	{
		theSeller.setSellerPassword("{noop}"+theSeller.getSellerPassword());
		sellerService.save(theSeller);
		return "redirect:/user/login";
	}
	
	@GetMapping("/{sellerId}/stock")
	public String getStocks(@PathVariable("sellerId") int sellerId, Model model)
	{
		Seller seller = sellerService.findBySellerId(sellerId);
		List<Stock> stocks = seller.getStocks();
		model.addAttribute("stocks", stocks);
		model.addAttribute("isSeller", sellerService.isSeller());
		model.addAttribute("isBuyer", buyerService.isBuyer());
		return "stock-list";
	}
}
