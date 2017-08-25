package ch01.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch01.annotation.TestObject;

//@Repository("userRepository")
@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired(required = false)
	private TestObject testObject;

	@Override
	public void save() {
		System.out.println("UserRepository save ....");
		System.out.println(testObject);
	}

}
