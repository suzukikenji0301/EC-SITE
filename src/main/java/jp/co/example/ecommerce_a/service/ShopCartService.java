package jp.co.example.ecommerce_a.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.ecommerce_a.domain.Order;
import jp.co.example.ecommerce_a.form.InsertCartForm;

/**
 * Order,OrderItem,OrderToppingリポジトリを操作するサービスクラス.
 * 
 * @author moriharanariki
 *
 */
@Service
@Transactional
public class ShopCartService {
	
	public Order showCartList(Integer userId) {
		return null;
	}
	
	public void insertItem(InsertCartForm insertCartForm) {
		
	}
	
	public void deleteItem(Integer orderItemId) {
		
	}
}
