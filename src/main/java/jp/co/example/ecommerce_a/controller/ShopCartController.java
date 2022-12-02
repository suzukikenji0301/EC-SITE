package jp.co.example.ecommerce_a.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.ecommerce_a.domain.LoginUser;
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
	private String showCartList(Model model, @AuthenticationPrincipal LoginUser loginUser) {

		User user = null;
		Order order = null;

		if (loginUser != null) {
			user = loginUser.getUser();
		}

		if (user != null) {
			order = shopCartService.showCartList(user.getId());
		} else {
			order = shopCartService.showCartList(session.hashCode());
		}

		System.out.println("コントローラーの処理" + session.hashCode());

		System.out.println("--------------" + order.toString());

		double tax = order.getCalcTotalPrice();
		tax = tax / 1.1;
		tax = tax * 0.1;
		model.addAttribute("order", order);
		model.addAttribute("tax", tax);
		model.addAttribute("totalPrice", order.getCalcTotalPrice());

		model.addAttribute("order", order);
		return "cart_list";
	}

	/**
	 * オーダーアイテム情報の追加を行います.
	 * 
	 * @param insertCartForm
	 * @return
	 */
	@PostMapping("/insertItem")
	private String insertItem(InsertCartForm insertCartForm, Integer itemId,
			@AuthenticationPrincipal LoginUser loginUser) {
		insertCartForm.setItemId(itemId);
		insertCartForm.setQuantity(insertCartForm.getQuantity());
		insertCartForm.setSize(insertCartForm.getSize());
		insertCartForm.setToppingList(insertCartForm.getToppingList());
		shopCartService.insertItem(insertCartForm, loginUser);
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
