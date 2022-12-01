package jp.co.example.ecommerce_a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.ecommerce_a.domain.Contact;
@Service
@Transactional
public class InsertContactService {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * お問合せ情報を取得します.
	 * 
	 * Contactオブジェクトを生成するローマッパー
	 */
	private static final RowMapper<Contact> USER_ROW_MAPPER = new BeanPropertyRowMapper<>(Contact.class);

	/**
	 * お問合せ情報を挿入します.
	 * 
	 * @param contact お問合せ情報
	 */
	public void insertContact(Contact contact) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(contact);
		String sql = "insert into contacts(name,fullName,mailAddress,telephone,gender,inquiryDetails) values(:name,:fullName,:mailAddress,:telephone,:gender,:inquiryDetails);";
		template.update(sql, param);
	}
}
