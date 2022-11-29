package jp.co.example.ecommerce_a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.ecommerce_a.domain.Order;
import jp.co.example.ecommerce_a.form.OrderForm;
import jp.co.example.ecommerce_a.repository.OrderRepository;

/**
 * 注文情報を操作するサービス.
 * 
 * @author Hirabuki
 *
 */
@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	/**
	 * 注文します.
	 * 
	 * @param orderForm 注文情報を受け取ったフォーム
	 */
	public void update(OrderForm orderForm) {
		Order order = orderRepository.load(orderForm.intGetOrderId());
		order.setTotalPrice(5);
		order.setDestinationName(orderForm.getDestinationName());
		order.setDestinationEmail(orderForm.getDestinationEmail());
		order.setDestinationZipcode(orderForm.getDestinationZipcode());
		order.setDestinationAddress(orderForm.getDestinationAddress());
		order.setDistinationTel(orderForm.getDistinationTel());
		order.setDeliveryTime(orderForm.getDeliveryTimestamp());

		if (orderForm.intGetPaymentMethod() == 1) {
			order.setPaymentMethod(1);
			order.setStatus(1);
		} else if (orderForm.intGetPaymentMethod() == 2) {
			order.setPaymentMethod(2);
			order.setStatus(2);
		}
		orderRepository.update(order);
	}

}
