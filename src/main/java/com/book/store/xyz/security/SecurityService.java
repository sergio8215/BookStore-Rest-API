package com.book.store.xyz.security;

public interface SecurityService {
	
	String findLoggedInUsername();
	
	void autoLogin(String username, String password);
}
