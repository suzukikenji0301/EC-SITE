package jp.co.example.ecommerce_a.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.example.ecommerce_a.domain.Order;

/**
 * orderテーブルを操作するリポジトリ.
 * 
 * @author moriharanariki
 *
 */
@Repository
public class OrderRepository {

	/**
	 * orderオブジェクトを生成するローマッパー.
	 * 
	 */
	private static final RowMapper<Order> ORDER_ROW_MAPPER = (rs, i) -> {
		Order order = new Order();
		order.setId(rs.getInt("id"));
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
		return order;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * オーダー情報を追加します.
	 * 
	 * @param order
	 * @return オーダー情報
	 */
	public void insert(Order order) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(order);
		String sql = "insert into orders(id,user_id,status,totalPrice,orderDate,destination_name,destination_email,destination_zipcode,destination_address,destination_tel,delivery_time,payment_method)"
				+ "values(:id,:userId,:status,:totalPrice,:orderDate,:destinationName,:destinationEmail,:destinationZipcode,:destinationAddress,:destinationTel,:deliveryTime,:paymentMethod);";
		template.update(sql, param);
	}
	
	/**
	 * userIdとstatus情報からオーダー情報を検索致します.
	 * 
	 * @param userId ユーザーID 
	 * @param status ステータス0
	 * @return オーダー情報
	 */
	public Order findByUserIdAndStatus(Integer userId, Integer status) {
		String sql = "SELECT id,user_id,status,totalPrice,orderDate,destination_name,destination_email,destination_zipcode,destination_address,destination_tel,delivery_time,payment_method FROM orders "
				+ "WHERE user_id=:userId and status=:status";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId).addValue("status", status);
		Order order = template.queryForObject(sql, param, ORDER_ROW_MAPPER);
		return order;
	}
	
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
	

}
