package ch01.generic.di;

import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {
	static {
		System.out.println("new UserService .....");
	}
}
