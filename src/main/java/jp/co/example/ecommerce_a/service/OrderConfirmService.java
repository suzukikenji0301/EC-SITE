package jp.co.example.ecommerce_a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.ecommerce_a.domain.Order;
import jp.co.example.ecommerce_a.repository.OrderRepository;

/**
 * @author kenji.suzuki
 *
 */
@Service
@Transactional
public class OrderConfirmService {
	@Autowired
	private OrderRepository orderRepository;
	
	/**
	 * 注文情報を取得します.
	 * 
	 * @param orderId　Order ID
	 * @return　注文情報
	 */
	public Order orderConfirm(Integer orderId) {
		Order order = orderRepository.load(orderId);
		System.out.println(orderId);
		return order;
	}
}
