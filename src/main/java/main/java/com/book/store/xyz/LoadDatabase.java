package main.java.com.book.store.xyz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {
	
	@Bean
	CommandLineRunner initDatabase(BookRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Book(97831001, "Book1", "Author1")));
			log.info("Preloading " + repository.save(new Book(97831002, "Book2", "Author2")));
			log.info("Preloading " + repository.save(new Book(97831003, "Book3", "Author3")));
			log.info("Preloading " + repository.save(new Book(97831004, "Book4", "Author4")));
			log.info("Preloading " + repository.save(new Book(97831005, "Book5", "Author5")));
			log.info("Preloading " + repository.save(new Book(97831006, "Book6", "Author6")));
			log.info("Preloading " + repository.save(new Book(97831007, "Book7", "Author7")));
			log.info("Preloading " + repository.save(new Book(97831008, "Book8", "Author8")));
			log.info("Preloading " + repository.save(new Book(97831009, "Book9", "Author9")));
		};
	}
}
