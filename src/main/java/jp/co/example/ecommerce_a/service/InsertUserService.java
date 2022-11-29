package jp.co.example.ecommerce_a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.ecommerce_a.domain.User;
import jp.co.example.ecommerce_a.repository.UserRepository;

@Service
@Transactional
public class InsertUserService {

	
		@Autowired
		private UserRepository userRepository;
			
			public void insertUser(User user) {
				userRepository.insert(user);
		}
	}
