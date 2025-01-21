package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.domain.CustomerRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	
	//@Bean
	 public	CommandLineRunner	demo(CustomerRepository	repository)	{
	 return	(args)	->	{
		 //	save	a	few	customers
		 repository.save(new Customer("Jack",	"010"));
		 repository.save(new Customer("Chloe",	"111"));
		 repository.save(new Customer("Kim",	"222"));
		 repository.save(new Customer("David",	"333"));
		 repository.save(new Customer("Michelle",	"444"));
		 //	fetch	all	customers
		 log.info("Customers	found	with	findAll():");
		 log.info("-------------------------------");
		 for	(Customer	customer	:	repository.findAll())	{
			 log.info(customer.toString());
		 }
		 log.info("");
	 	};
	}
}
