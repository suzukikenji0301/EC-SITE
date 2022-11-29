package jp.co.example.ecommerce_a.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
<<<<<<< HEAD
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
=======
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
>>>>>>> develop
import org.springframework.stereotype.Repository;

import jp.co.example.ecommerce_a.domain.Topping;

/**
<<<<<<< HEAD
 * toppingsテーブルを操作するRepositoryクラス.
 * 
 * @author kumagaimayu
=======
 * toppingテーブルを操作するリポジトリ.
 * 
 * @author moriharanariki
>>>>>>> develop
 *
 */
@Repository
public class ToppingRepository {
<<<<<<< HEAD

	@Autowired
	private NamedParameterJdbcTemplate template;

=======
	
	/**
	 * Toppingオブジェクトを生成するローマッパー.
	 * 
	 */
>>>>>>> develop
	private static final RowMapper<Topping> TOPPING_ROW_MAPPER = (rs, i) -> {
		Topping topping = new Topping();
		topping.setId(rs.getInt("id"));
		topping.setName(rs.getString("name"));
		topping.setPriceM(rs.getInt("price_m"));
		topping.setPriceL(rs.getInt("price_l"));
		return topping;
	};
<<<<<<< HEAD

	/**
	 * トッピング一覧を取得する.
	 * 
	 * @return トッピング一覧
	 */
	public List<Topping> findAll() {
		String sql = "SELECT id, name, price_m, price_l FROM toppings;";
		SqlParameterSource param = new MapSqlParameterSource();
		List<Topping> toppingList = template.query(sql, param, TOPPING_ROW_MAPPER);
=======
	
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
>>>>>>> develop
		return toppingList;
	}
}
