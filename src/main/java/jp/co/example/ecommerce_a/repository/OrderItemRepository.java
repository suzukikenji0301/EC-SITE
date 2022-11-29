package jp.co.example.ecommerce_a.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.example.ecommerce_a.domain.OrderItem;
import jp.co.runy.bbs.separated.domain.SeparatedComment;

/**
 * order_itemsテーブルを操作するリポジトリ.
 * 
 * @author moriharanariki
 *
 */
@Repository
public class OrderItemRepository {
	
	/**
	 * OrderItemオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<OrderItem> ORDER_ITEM_ROW_MAPPER = (rs, i) -> {
		OrderItem orderItem = new OrderItem(); 
		orderItem.setId(rs.getInt("id"));
		orderItem.setItemId(rs.getInt("item_id"));
		orderItem.setOrderId(rs.getInt("order_id"));
		orderItem.setQuantity(rs.getInt("quantity"));
		orderItem.setSize(rs.getString("size"));
		return orderItem;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	/**
	 * オーダーアイテム情報を追加します.
	 * 
	 * @param orderItem
	 */
	public OrderItem insert(OrderItem orderItem) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(orderItem);
		String sql = "insert into order_items(item_id,order_id,quantity,size)"
				+ "values(:itemId, :orderId, :quantity, size);";
		template.update(sql, param);
		return orderItem;
	}
	
	/**
	 * オーダーアイテム情報を削除します.
	 * 
	 * @param orderItemId
	 */
	public void deleteById(Integer orderItemId) {
		String deleteSql = "DELETE FROM order_items WHERE id=:orderItemID";
		SqlParameterSource param = new MapSqlParameterSource().addValue("orderItemID", orderItemId);
		template.update(deleteSql, param);
	}
	
	public List<OrderItem> findByOrderId(int orderId) {
		String sql = "SELECT id,item_id,order_id,quantity,size FROM order_items WHERE order_id=:orderId ORDER BY id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("orderId", orderId);
		List<OrderItem> orderItemList = template.query(sql, param, ORDER_ITEM_ROW_MAPPER);
		return orderItemList;
	}
	
}
