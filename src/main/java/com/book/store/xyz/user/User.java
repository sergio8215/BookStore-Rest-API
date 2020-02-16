package com.book.store.xyz.user;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.book.store.xyz.user.role.Role;

import lombok.Data;

@Data
@Entity
public class User {
	
	private @Id @GeneratedValue long id;
	private String name;
	private String username;
	private String password;
	
	@Transient
	private String passwordConfirm;
	
	@ManyToMany
	private Set<Role> roles;
	
}
