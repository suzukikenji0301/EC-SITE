package jp.co.example.ecommerce_a.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.ecommerce_a.domain.Order;
import jp.co.example.ecommerce_a.domain.User;
import jp.co.example.ecommerce_a.form.InsertCartForm;
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
	private HttpSession session;  
	
	@Autowired
	private ShopCartService shopCartService;
	
	/**
	 * 一覧を表示します.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/showCartList")
	private String showCartList(Model model) {
		User user = (User) session.getAttribute("user");
		Order order = null;
		
		if(user != null) {
			 order = shopCartService.showCartList(user.getId());
		}else {
			 order = shopCartService.showCartList(session.hashCode());
		}
		
		model.addAttribute(order);
		return "cart_list";
	}
	
	/**
	 * オーダーアイテム情報の追加を行います.
	 * 
	 * @param insertCartForm
	 * @return
	 */
	@PostMapping("/insertItem")
	private String insertItem(InsertCartForm insertCartForm) {
		insertCartForm.setItemId(1);
		insertCartForm.setQuantity(2);
		insertCartForm.setSize("M");
		List<Integer> toppingList = new ArrayList<>();
		toppingList.add(1);
		toppingList.add(2);
		insertCartForm.setToppingList(toppingList);
		shopCartService.insertItem(insertCartForm);
		return "redirect:/shopCart/showCartList";
	}
	
	/**
	 * オーダーアイテム情報を削除します.
	 * 
	 * @param orderItemId
	 * @return
	 */
	@PostMapping("/deleteItem")
	private String deleteItem(Integer orderItemId) {
		shopCartService.deleteItem(orderItemId);
		return "redirect:/shopCart/showCartList";
	}
}
