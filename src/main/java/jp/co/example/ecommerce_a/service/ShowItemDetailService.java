package jp.co.example.ecommerce_a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.ecommerce_a.domain.Item;
import jp.co.example.ecommerce_a.repository.ItemRepository;
import jp.co.example.ecommerce_a.repository.ToppingRepository;

/**
 * 商品詳細を取得するServiceクラス.
 * 
 * @author kumagaimayu
 *
 */
@Service
@Transactional
public class ShowItemDetailService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ToppingRepository toppingRepository;

	/**
	 * 商品を1件検索します.
	 * 
	 * @param id 商品ID
	 * @return 商品
	 */
	public Item showItemDetail(Integer id) {
		Item item = new Item();
		item = itemRepository.findById(id);
		item.setToppingList(toppingRepository.findAll());
		return item;
	}
}
