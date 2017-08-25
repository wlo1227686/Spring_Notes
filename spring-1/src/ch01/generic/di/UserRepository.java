package ch01.generic.di;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends BaseRepository<User> {
	static {
		System.out.println("new UserRepository .....");
	}
}
