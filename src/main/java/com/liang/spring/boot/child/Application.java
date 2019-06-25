package com.liang.spring.boot.child;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.servlet.MultipartConfigElement;

@EnableJpaAuditing
@SpringBootApplication
public class Application {


	@Bean
   public MultipartConfigElement multipartConfigElement() {

		MultipartConfigFactory factory = new MultipartConfigFactory();

		factory.setLocation("D:/kangping-child/tmp");//指定临时文件路径

		return factory.createMultipartConfig();
 }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



}
