package jp.co.example.ecommerce_a.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.ecommerce_a.form.OrderForm;
import jp.co.example.ecommerce_a.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("")
	public String order(@Validated OrderForm orderForm, BindingResult result) {
		LocalDateTime localDateTime = LocalDateTime.now();
		localDateTime = localDateTime.plusHours(3);
		Timestamp userOrderTimestamp = orderForm.getDeliveryTimestamp();
		LocalDateTime userOrderTime = userOrderTimestamp.toLocalDateTime();
		if(!localDateTime.isAfter(userOrderTime)) {
			result.rejectValue("deliveryDate", "", "今から3時間後の日時をご入力ください");
		}
		
		if(result.hasErrors()) {
			return "orderConfirm";
		}
		orderService.update(orderForm);
		return "order_finished";
	}

}
