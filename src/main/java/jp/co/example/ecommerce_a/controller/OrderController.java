package jp.co.example.ecommerce_a.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.ecommerce_a.domain.LoginUser;
import jp.co.example.ecommerce_a.form.OrderForm;
import jp.co.example.ecommerce_a.service.OrderService;

/**
 * 注文情報を操作するコントローラー.
 * 
 * @author Hirabuki
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	/**
	 * 注文します.
	 * 
	 * @param orderForm 注文情報格納用フォーム
	 * @param result エラー情報格納用
	 * @return 正常系→注文完了画面へ遷移　異常系→注文確認画面へ遷移しエラー分表示
	 */
	@PostMapping("")
	public String order(@Validated OrderForm orderForm, BindingResult result, @AuthenticationPrincipal LoginUser loginUser) {
		
		orderForm.setOrderId(String.valueOf(loginUser.getUser().getId()));
		
//		テスト用sysoutたち
		System.out.println(orderForm.getDestinationName());
		System.out.println(orderForm.getDestinationEmail());
		System.out.println(orderForm.getDestinationZipcode());
		System.out.println(orderForm.getDestinationAddress());
		System.out.println(orderForm.getDistinationTel());
		System.out.println(orderForm.getDeliveryDate());
		System.out.println(orderForm.getDeliveryTime());
		System.out.println(orderForm.getPaymentMethod());
		System.out.println("オーダーID=" + orderForm.getOrderId());
		System.out.println("タイムスタンプ=" + orderForm.getDeliveryTimestamp());
		System.out.println("ログインユーザー名" + loginUser.getUser().getName());
//	ここまで
		
		
		
		LocalDateTime localDateTime = LocalDateTime.now();
		localDateTime = localDateTime.plusHours(3);
		Timestamp userOrderTimestamp = orderForm.getDeliveryTimestamp();
		LocalDateTime userOrderTime = userOrderTimestamp.toLocalDateTime();
		if(!localDateTime.isAfter(userOrderTime)) {
			result.rejectValue("deliveryDate", "", "今から3時間後の日時をご入力ください");
		}
		
//		if(result.hasErrors()) {
//			return "orderConfirm";
//		}
		orderService.update(orderForm);
		return "order_finished";
	}

}
