package emartapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import emartapp.model.Buyer;
import emartapp.service.BuyerService;
import emartapp.service.SellerService;

@Controller
@RequestMapping("/buyer")
public class BuyerController 
{
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private SellerService sellerService;

	@GetMapping("/list")
	public String listBuyers(Model model)
	{
		List<Buyer> buyers = buyerService.findAll();
		model.addAttribute("buyers", buyers);
		model.addAttribute("isBuyer", buyerService.isBuyer());
		model.addAttribute("isSeller", sellerService.isSeller());
		return "buyer-list";
	}
	
	@GetMapping("/signup")
	public String buyerSignup(Model model)
	{
		Buyer theBuyer = new Buyer();
		model.addAttribute("theBuyer", theBuyer);
		model.addAttribute("isBuyer", buyerService.isBuyer());
		model.addAttribute("isSeller", sellerService.isSeller());
		return "buyer-signup-form";
	}
	
	@PostMapping("/save")
	public String saveBuyer(@ModelAttribute("theBuyer") Buyer theBuyer)
	{
		theBuyer.setBuyerPassword("{noop}" + theBuyer.getBuyerPassword());
		buyerService.createBuyer(theBuyer);
		return "redirect:/user/login";
	}
}
