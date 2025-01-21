package com.example.demo.customer.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import jakarta.transaction.Transactional;

@SpringBootTest
public class CustomerRepositoryTest {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	//@Test
	@DisplayName("고객등록")
	
	//롤백을 넣으려면 추가 
	//@Transactional
	//@Rollback 
	public void insert() {
		//given
		Customer customer = new Customer("홍길동","010-1245-1245");
		
		//방법 2 setter 사용하기
//		Customer customer = new Customer();
//		 customer.setName("홍길동");
//		 customer.setPhone("0101111");
		
		//when
		customerRepository.save(customer);
		//then
		//단건조회결과와 비교 
		Optional<Customer> result = customerRepository.findById(1L);
		assertThat( result.get().getName() ).isEqualTo("홍길동");
	}
	
	//@Test
	@DisplayName("고객수정")
	public void update() {
		//given
		Customer customer = new Customer("홍길동","010-1245-1245");
		customerRepository.save(customer);
		
		//when
		Optional<Customer> result = customerRepository.findById(1L);
		result.get().setPhone("2222-3333");
		customerRepository.save(result.get());
		
		//save에 기본키가 있으면 = 등록 , 없는 경우 = 수정 
		
		//then
		//단건조회결과와 비교 
		
		//assertThat( result.get().getName() ).isEqualTo("홍길동");
	}
	
	//@Test
	@DisplayName("이름검색")
	public void findByName() {
		String name = "%M%";
		String phone = "%0%";
		//List<Customer>list = customerRepository.findByNameLike(name);
		List<Customer>list = customerRepository.findByNameLikeOrPhoneLikeOrderByNameDesc(name,phone);
		
		
		System.out.println(list);
		//Customer@630a647c 이렇게 나오는 이유는 문자 변환이 안된거임 그래서 Customer.java에 source > toString 넣어줘야 함
	}
	
	//@Test
	public void findById() {
		Long id = 1L;
		String phone = "111";
		Optional<Customer> customer = customerRepository.findById(id,phone);
		System.out.println(customer.get());
	}
	
	
		@Test
		@DisplayName("고객등록")
		public void insertUpdate() {
			//given
			Customer customer = new Customer("홍길동","010-1245-1245");
			
			//when
			customerRepository.save(customer);
			addressRepository.save(Address
					                .builder()
					                .address("대구")
					                //.customer(customer)
					                .build());
			
			System.out.println("id:"+customer.getId());
			
			//then
			Optional<Customer> result = customerRepository.findById(1L);
			Optional<Address> address = addressRepository.findById(1L);
			System.out.println("address:"+ address);
			assertThat( result.get().getName() ).isEqualTo("홍길동");
		}
}
