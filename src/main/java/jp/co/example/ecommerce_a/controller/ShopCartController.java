package jp.co.example.ecommerce_a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.ecommerce_a.service.ShopCartService;

/**
 * オーダー情報を操作するコントローラー.
 * 
 * @author moriharanariki
 *
 */
@Controller
@RequestMapping("/shopCart")
public class ShopCartController {
	
	@Autowired
	private ShopCartService shopCartService;
	
	@GetMapping("/showCartList")
	private String showCartList() {
		return "cart_list";
	}
	
	@PostMapping("/insertItem")
	private String insertItem() {
		return "redirect:/shopCart/showCartList";
	}
	
	@PostMapping("/deleteItem")
	private String deleteItem() {
		return "redirect:/shopCart/showCartList";
	}
}
