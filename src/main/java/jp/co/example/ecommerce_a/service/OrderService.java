package jp.co.example.ecommerce_a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.ecommerce_a.domain.Order;
import jp.co.example.ecommerce_a.form.OrderForm;
import jp.co.example.ecommerce_a.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public void update(OrderForm orderForm) {
		Order order = orderRepository.load(orderForm.intGetOrderId());
		order.setDestinationName(orderForm.getDestinationName());
		order.setDestinationEmail(orderForm.getDestinationEmail());
		order.setDestinationZipcode(orderForm.getDestinationZipcode());
		order.setDestinationAddress(orderForm.getDestinationAddress());
		order.setDistinationTel(orderForm.getDistinationTel());
		order.setDeliveryTime(orderForm.getDeliveryTimestamp());
		orderRepository.update(order);
	}

}
