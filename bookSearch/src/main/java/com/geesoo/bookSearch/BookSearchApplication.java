package com.geesoo.bookSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class) //EnversRevisionRepositoryFactoryBean 인스턴스 생성
@SpringBootApplication
public class BookSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookSearchApplication.class, args);
	}

}
