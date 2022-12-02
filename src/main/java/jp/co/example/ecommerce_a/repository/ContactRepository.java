package jp.co.example.ecommerce_a.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.example.ecommerce_a.domain.Contact;

/**
 * @author kenji.suzuki
 *
 */
@Repository
public class ContactRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * Userオブジェクトを生成するローマッパー
	 */
//	private static final RowMapper<Contact> USER_ROW_MAPPER = new BeanPropertyRowMapper<>(Contact.class);

	/**
	 * お問合せ情報を挿入します.
	 * 
	 * @param contact お問合せ情報
	 */
	public void insertContact(Contact contact) {
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(contact);
		String sql = "insert into contacts(name,fullName,mailAddress,telephone,gender,inquiryDetails) values(:name,:fullName,:mailAddress,:telePhone,:gender,:inquiryDetails);";
		System.out.println(contact);
		template.update(sql, param);
	}
}
