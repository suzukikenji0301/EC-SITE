package jp.co.example.ecommerce_a.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.example.ecommerce_a.domain.Order;

/**
 * ordersテーブルを操作するリポジトリ.
 * 
 * @author Hirabuki
 *
 */
@Repository
public class OrderRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * Orderオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<Order> ORDER_ROW_MAPPER = new BeanPropertyRowMapper<>(Order.class);

	/**
	 * 主キーからオーダー情報を取得します.
	 * 
	 * @param orderId 検索したいオーダーID
	 * @return 検索されたオーダー情報
	 */
	public Order load(Integer orderId) {
		String sql = "SELECT id, user_id, status, total_price, order_date, destination_name, destination_email, destination_zipcode, destination_address, destination_tel, delivery_time, payment_method FROM orders WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", orderId);
		Order order = template.queryForObject(sql, param, ORDER_ROW_MAPPER);
		return order;
	}

	/**
	 * オーダー情報を更新します.
	 */
	public void update(Order order) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(order);
		StringBuilder updateSqlBuilder = new StringBuilder("UPDATE orders");
		updateSqlBuilder.append("SET user_id=:userId, status=:status, total_price=:totalPrice, ");
		updateSqlBuilder.append(
				"order_date=:orderDate, destination_name=:destinationName, destination_email=:destinationEmail, ");
		updateSqlBuilder.append("destination_zipcode=:destinationZipcode, destination_address=:destinationAddress, ");
		updateSqlBuilder.append(
				"destination_tel=:distinationTel, delivery_time=:deliveryTime, payment_method=:paymentMethod, ");
		updateSqlBuilder.append("WHERE id=:id;");
		template.update(updateSqlBuilder.toString(), param);

	}

}
