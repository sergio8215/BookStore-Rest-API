package com.book.store.xyz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.book.store.xyz.security.SecurityService;
import com.book.store.xyz.security.SecurityServiceImpl;
import com.book.store.xyz.user.UserService;
import com.book.store.xyz.user.UserServiceImpl;
import com.book.store.xyz.user.UserValidator;

@Configuration
@ComponentScan("com.book.store.xyz.*")
@EnableWebMvc
public class SpringWebConfiguration implements WebMvcConfigurer {
	
	@Bean
	 public InternalResourceViewResolver getInternalResourceViewResolver() {
	 System.out.println("llega");
	 InternalResourceViewResolver resolve = new InternalResourceViewResolver();
	 resolve.setPrefix("/WEB-INF/view/");
	 resolve.setSuffix(".jsp");
	 return resolve;

	}
	
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	
	@Bean
	public SecurityService securityService() {
		return new SecurityServiceImpl();
	}
	
	@Bean
	public UserValidator userValidator() {
		return new UserValidator();
	}
}
