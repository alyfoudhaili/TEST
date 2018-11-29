package com.example.demo;

import java.util.stream.Stream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.dao.Product;
import com.example.dao.ProductRepository;

@SpringBootApplication
public class Tp1Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx=(ApplicationContext) SpringApplication.run(Tp1Application.class, args);
		
		ProductRepository productrepository=ctx.getBean(ProductRepository.class);
		Stream.of("A","B","C").forEach(s->productrepository.save(new Product(s)));
		productrepository.findAll().forEach(s->System.out.println(" id"+s.getId()+"  des :"+s.getDesignation()));
	
	}
}
