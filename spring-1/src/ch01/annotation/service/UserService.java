package ch01.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ch01.annotation.repository.UserRepository;

@Service
public class UserService {

	// @Autowired
	// // 值接指定裝備哪個bean切記第一個字要小寫
	// @Qualifier("userRepositoryImpl")
	private UserRepository userRepository;

	// @Autowired
	// @Qualifier("userRepositoryImpl")
	// public void setUserRepository(UserRepository userRepository) {
	// this.userRepository = userRepository;
	// }

	@Autowired
	public void setUserRepository(@Qualifier("userRepositoryImpl") UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void add() {
		System.out.println("UserService add ...");
		userRepository.save();
	}
}
