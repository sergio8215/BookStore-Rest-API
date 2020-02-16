package com.book.store.xyz.user.role;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.book.store.xyz.user.User;

import lombok.Data;

@Data
@Entity
public class Role {
	
	private @Id @GeneratedValue long id;
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	
}
