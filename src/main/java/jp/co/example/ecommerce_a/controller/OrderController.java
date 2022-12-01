package jp.co.example.ecommerce_a.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import jp.co.example.ecommerce_a.domain.RequestCreditCardPaymentApi;
import jp.co.example.ecommerce_a.domain.ResponseCreditCardPaymentApi;
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

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * WebAPIのURL
	 */
	private static final String URL = "http://153.127.48.168:8080/sample-credit-card-web-api/credit-card/payment";

	/**
	 * 注文します.
	 * 
	 * @param orderForm 注文情報格納用フォーム
	 * @param result エラー情報格納用
	 * @return 正常系→注文完了画面へ遷移　異常系→注文確認画面へ遷移しエラー分表示
	 */
	@PostMapping("")
	public String order(@Validated OrderForm orderForm, BindingResult result) {
		LocalDateTime localDateTime = LocalDateTime.now();
		localDateTime = localDateTime.plusHours(3);
		Timestamp userOrderTimestamp = orderForm.getDeliveryTimestamp();
		LocalDateTime userOrderTime = userOrderTimestamp.toLocalDateTime();
		if(!localDateTime.isAfter(userOrderTime)) {
			result.rejectValue("deliveryDate", "", "今から3時間後の日時をご入力ください");
		}
		
		//クレカだったらの処理
		if(orderForm.getPaymentMethod().equals(2)) {
			//クレカのWebAPIを叩いてレスポンスを受け取る
			RequestCreditCardPaymentApi requestCreditCardPaymentApi = new RequestCreditCardPaymentApi();
			BeanUtils.copyProperties(orderForm, requestCreditCardPaymentApi);
			ResponseCreditCardPaymentApi responseCreditCardPaymentApi = restTemplate.postForObject(URL, requestCreditCardPaymentApi, ResponseCreditCardPaymentApi.class);
			//エラーが返ってきた時の分岐
			if(responseCreditCardPaymentApi.getError_code().equals(responseCreditCardPaymentApi)) {
				
			}
			//rejectValueでresultにセット
			
			
			return "orderConfirm";
		}
		
		
		
		if(result.hasErrors()) {
			return "orderConfirm";
		}
		
			
		}

	orderService.update(orderForm);

	return"order_finished";
}

}
