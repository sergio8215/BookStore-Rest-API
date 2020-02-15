package main.java.com.book.store.xyz;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Category {
	
	private @Id @GeneratedValue long id;
	private String categoryName;
	
	Category( String categoryName ){
		this.categoryName = categoryName;
	}
}
