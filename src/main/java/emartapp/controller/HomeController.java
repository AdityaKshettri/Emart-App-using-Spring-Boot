package emartapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import emartapp.service.BuyerService;
import emartapp.service.SellerService;

@Controller
public class HomeController 
{
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/")
	public String index(Model model)
	{
		if(buyerService.isBuyer()) {
			return "redirect:/seller/list";
		}
		else if(sellerService.isSeller()) {
			return "redirect:/stock/list";
		}
		return "redirect:/";
	}
}
