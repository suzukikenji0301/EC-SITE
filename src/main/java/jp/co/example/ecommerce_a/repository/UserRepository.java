package jp.co.example.ecommerce_a.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.example.ecommerce_a.domain.User;

/**
 * usersテーブルを操作するリポジトリ.
 * 
 * @author Hirabuki
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * メールアドレスとパスワードから管理者情報を取得します.
	 * 
	 * Userオブジェクトを生成するローマッパー
	 */
	private static final RowMapper<User> USER_ROW_MAPPER = new BeanPropertyRowMapper<>(User.class);

	/**
	 * @param email    メールアドレス
	 * @param password パスワード
	 * @return ユーザー情報 存在しない場合はnullを返します
	 */
	public User findByMailAndPassword(String email, String password) {
		String sql = "SELECT id, name, email, password, zipcode, address, telephone FROM users WHERE email=:email AND password=:password;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email).addValue("password", password);
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		if (userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}

}
