package com.geesoo.bookSearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
		 	// h2 console 사용을 위한 설정 
		    http.csrf().ignoringAntMatchers("/console/**");
		    http.headers().frameOptions().sameOrigin();

		 	http
	            .authorizeRequests()
	            	.antMatchers("/console/**").permitAll()
	            	/* .antMatchers("/books/**").permitAll() */ 
	                .antMatchers("/home","/create","/regist","/account/**").permitAll()
	                .antMatchers("/admin/**").hasRole("ADMIN")
	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .loginPage("/login")
	                .permitAll()
	                .and()
	            .logout()
	                .permitAll();
	    }

	 @Bean
	 public PasswordEncoder passwordEncoder()
	 {
		 return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 }
}
