package jp.co.example.ecommerce_a.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jp.co.example.ecommerce_a.domain.Item;
import jp.co.example.ecommerce_a.domain.Topping;

/**
 * toppingテーブルを操作するリポジトリ.
 * 
 * @author moriharanariki
 *
 */
public class ToppingRepository {
	
	/**
	 * Toppingオブジェクトを生成するローマッパー.
	 * 
	 */
	private static final RowMapper<Topping> TOPPING_ROW_MAPPER = (rs, i) -> {
		Topping topping = new Topping();
		topping.setId(rs.getInt("id"));
		topping.setName(rs.getString("name"));
		topping.setPriceM(rs.getInt("price_m"));
		topping.setPriceL(rs.getInt("price_l"));
		return topping;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	/**
	 * 全件検索を行います。
	 * 
	 * @return
	 */
	public List<Topping> findAll() {
		String sql = "SELECT id,name,price_m, price_l FROM toppings ORDER BY price_m;";
		List<Topping> toppingList = template.query(sql, TOPPING_ROW_MAPPER);
		return toppingList;
	}
}
