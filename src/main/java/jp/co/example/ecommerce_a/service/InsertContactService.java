package jp.co.example.ecommerce_a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.ecommerce_a.domain.Contact;
import jp.co.example.ecommerce_a.domain.User;
import jp.co.example.ecommerce_a.repository.ContactRepository;
@Service
@Transactional
public class InsertContactService {

	@Autowired
	private ContactRepository contactRepository;

	/**
	 * お問合せ内容を送信します.
	 * 
	 * @param contact お問合せ内容
	 */
	public void insertContact(Contact contact) {
		contactRepository.insertContact(contact);
	}
}
