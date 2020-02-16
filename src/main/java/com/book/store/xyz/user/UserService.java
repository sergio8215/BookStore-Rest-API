package com.book.store.xyz.user;

public interface UserService {
	void save(User user);
	
	User findByUsername(String username);
}
