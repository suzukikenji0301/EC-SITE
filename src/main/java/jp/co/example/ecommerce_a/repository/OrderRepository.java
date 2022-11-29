package jp.co.example.ecommerce_a.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.example.ecommerce_a.domain.Order;
import jp.co.example.ecommerce_a.domain.OrderItem;
import jp.co.example.ecommerce_a.domain.OrderTopping;

/**
 * ordersテーブルを操作するリポジトリ.
 * 
 * @author moriharanariki
 *
 */
@Repository
public class OrderRepository {

	/**
	 * articlesとcommentsテーブルを結合したものからarticleリストを作成する.
	 * articleオブジェクト内にはcommentリストを格納する。
	 */
	private static final ResultSetExtractor<List<Order>> ORDER_RESULT_SET_EXTRACTOR = (rs) -> {
		// オーダー情報が入るorderListを生成
		List<Order> orderList = new LinkedList<Order>();
		List<OrderItem> orderItemList = null;
		List<OrderTopping> orderToppingList = null;
		// 前の行のorderIDを退避しておく変数
		long beforeOrderId = 0;

		while (rs.next()) {
			// 現在検索されているorderIDを退避
			int nowOrderId = rs.getInt("id");

			// 現在のorderIdと前のorderIdが違う場合はorderオブジェクトを生成
			if (nowOrderId != beforeOrderId) {
				Order order = new Order();
				order.setId(nowOrderId);
				order.setUserId(rs.getInt("user_id"));
				order.setStatus(rs.getInt("status"));
				order.setTotalPrice(rs.getInt("total_price"));
				order.setOrderDate(rs.getDate("order_date"));
				order.setDestinationName(rs.getString("destination_name"));
				order.setDestinationEmail(rs.getString("destination_email"));
				order.setDestinationZipcode(rs.getString("destination_zipcode"));
				order.setDestinationAddress(rs.getString("destination_address"));
				order.setDistinationTel(rs.getString("destination_tel"));
				order.setDeliveryTime(rs.getTimestamp("delivery_time"));
				order.setPaymentMethod(rs.getInt("payment_method "));
				// 空のオーダーアイテムリストを作成しオーダーオブジェクトにセットしておく
				orderItemList = new ArrayList<OrderItem>();
				order.setOrderItemList(orderItemList);
				// オーダーアイテムがセットされていない状態のorderオブジェクトをarticleListオブジェクトにadd
				orderList.add(order);
			}

			// オーダー情報だけあってorderItemがない場合はCommentオブジェクトは作らない
			if (rs.getInt("order_item_id") != 0) {
				OrderItem orderItem = new OrderItem();
				orderItem.setId(rs.getInt("order_item_id"));
				orderItem.setItemId(rs.getInt("item_id"));
				orderItem.setOrderId(rs.getInt("order_id"));
				orderItem.setQuantity(rs.getInt("quantity"));
				orderItem.setSize(rs.getString("size"));

				orderItem.setItem(null);
				orderToppingList = new ArrayList<OrderTopping>();
				orderItem.setOrderToppingList(orderToppingList);
				// オーダーアイテム情報をオーダーオブジェクト内にセットされているorderItemListに直接addしている(参照型なのでこのようなことができる)
				orderItemList.add(orderItem);
			}

			// オーダーアイテム情報だけあってorderToppingがない場合はorderToppingオブジェクトは作らない.
			if (rs.getInt("order_topping_id") != 0) {
				OrderTopping orderTopping = new OrderTopping();
				orderTopping.setId(rs.getInt("order_topping_id"));
				orderTopping.setToppingId(rs.getInt("topping_id"));
				orderTopping.setOrderItemId(rs.getInt("order_item_id"));
				orderTopping.setTopping(null);
				// オーダートッピング情報をオーダーアイテムオブジェクト内にセットされているorderToppingListに直接addしている(参照型なのでこのようなことができる)
				orderToppingList.add(orderTopping);
			}

			// 現在の記事IDを前の記事IDを入れる退避IDに格納
			beforeOrderId = nowOrderId;
		}
		return orderList;

	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * オーダー情報を追加します.
	 * 
	 * @param order
	 * @return オーダー情報
	 */
	public Order insert(Order order) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(order);
		String sql = "insert into orders(user_id,status,totalPrice,orderDate,destination_name,destination_email,destination_zipcode,destination_address,destination_tel,delivery_time,payment_method)"
				+ "values(:userId,:status,:totalPrice,:orderDate,:destinationName,:destinationEmail,:destinationZipcode,:destinationAddress,:destinationTel,:deliveryTime,:paymentMethod);";
		template.update(sql, param);
		return order;
	}

	/**
	 * userIdとstatus情報からオーダー情報を検索致します.
	 * 
	 * @param userId ユーザーID
	 * @param status ステータス0
	 * @return オーダー情報
	 *//*
		 * public Order findByUserIdAndStatus(Integer userId, Integer status) { String
		 * sql =
		 * "SELECT id,user_id,status,totalPrice,orderDate,destination_name,destination_email,destination_zipcode,destination_address,destination_tel,delivery_time,payment_method FROM orders "
		 * + "WHERE user_id=:userId and status=:status"; SqlParameterSource param = new
		 * MapSqlParameterSource().addValue("userId", userId).addValue("status",
		 * status); }
		 */

	/**
	 * オーダー情報を更新します.
	 * 
	 * @param order
	 * @return オーダー情報
	 */
	public void update(Order order) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(order);

		String updateSql = "UPDATE orders SET id=:id,user_id=:userId,status=:status,total_price=:totalPrice,order_date=:orderDate,:destinationName,:destinationEmail,destination_zipcode=:destinationZipcode,destination_address:destinationAddress,"
				+ "destination_tel=:destinationTel,delivery_time=:deliveryTime,payment_method=:paymentMethod";
		template.update(updateSql, param);
	}

	public List<Order> findAll() {
		String sql = "SELECT a.id, a.name, a.content, com.id com_id, com.name com_name, com.content com_content,com.article_id com_article_id "
				+ "FROM articles a LEFT JOIN comments com ON a.id = com.article_id ORDER BY a.id DESC, com.id;";
		List<Order> orderList = template.query(sql, ORDER_RESULT_SET_EXTRACTOR);

		return orderList;
	}

}
