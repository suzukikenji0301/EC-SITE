package jp.co.example.ecommerce_a.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.example.ecommerce_a.domain.Order;

@Repository
public class OrderRepository {

	
	public Order load(Integer orderId) {
		String sql ="SELECT id,item_id,order_id,quantity,size FROM order_items WHERE values(:id,:item_id,:quantity,:size);";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		
		
	}
	 

}
