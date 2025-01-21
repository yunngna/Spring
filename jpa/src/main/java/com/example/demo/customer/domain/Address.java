package com.example.demo.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@Builder
@Getter //도메인 entity 에는 setter 사용 안하고 getter만 사용한다.
@NoArgsConstructor
@AllArgsConstructor


public class Address {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 
	 private String zipcode;
	 private String address;
	 private String detail_address;
	 
//	 @OneToOne
//	 @JoinColumn(name = "customer_id")
//	 Customer customer;
	 
	 
 
}
