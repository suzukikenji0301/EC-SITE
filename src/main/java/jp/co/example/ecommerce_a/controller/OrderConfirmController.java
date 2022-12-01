package jp.co.example.ecommerce_a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import jp.co.example.ecommerce_a.domain.Order;
import jp.co.example.ecommerce_a.form.OrderForm;
import jp.co.example.ecommerce_a.service.OrderConfirmService;

@Controller
@RequestMapping("/orderConfirm")
public class OrderConfirmController {

	@Autowired
	private OrderConfirmService orderConfirmService;
	
	@Autowired
	private RestTemplate restTemplate;
//
//	public String post(String url, String json) {
//		RequestEntity.BodyBuilder builder = RequestEntity.post(uri(url));
//		RequestEntity<String> request = builder.contentType(MediaType.APPLICATION_JSON_UTF8).body(json);
//		ResponseEntity<String> response = this.rest.exchange(request, String.class);
//		return response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;
//	}
//
//	private static final URI uri( String url ) {
//	    try {
//	        return new URI( url );
//	    }
//	    catch ( Exception ex ) {
//	        throw new RuntimeException( ex );
//	    }
//
//	/**
//	 * WebAPIのURL
//	 */
//	final String url = "http://153.127.48.168:8080/sample-credit-card-web-api/credit-card/payment";

	/**
	 * 注文確認画面を表示する.
	 * 
	 * @param orderId オーダーID
	 * @return 注文確認画面
	 */
	@RequestMapping("/")
	public String orderConfirm(Integer orderId, Model model) {
		Order order = orderConfirmService.orderConfirm(orderId);
		model.addAttribute("order", order);

		return "order_confirm";
	}
}
