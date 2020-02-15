package com.book.store.xyz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	
	private @Id @GeneratedValue long id;
	private String name;
	private String userName;
	private int rol; // Enum with the rols
	
	/**
	 * @param id
	 * @param name
	 * @param userName
	 * @param rol
	 */
	public User(String name, String userName, int rol) {
		this.name = name;
		this.userName = userName;
		this.rol = rol;
	}
}
