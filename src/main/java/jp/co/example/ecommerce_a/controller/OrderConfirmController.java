package jp.co.example.ecommerce_a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.ecommerce_a.domain.Order;
import jp.co.example.ecommerce_a.service.OrderConfirmService;

@RequestMapping("/")
public class OrderConfirmController {

	@Autowired
	private OrderConfirmService orderConfirmService;
	
	/**
	 * 注文確認画面を表示する.
	 * 
	 * @param orderId オーダーID
	 * @return　注文確認画面
	 */
	@RequestMapping("/orderConfirm")
	public String orderConfirm(Integer orderId,Model model) {
		Order order = orderConfirmService.orderConfirm(orderId);
		return "forward:/";
		
	}

}
