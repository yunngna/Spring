package com.example.demo.customer.domain;

import org.springframework.data.jpa.repository.JpaRepository;
//인터페이스끼리 상속 = extends (AddressDTO 의 id (기본키) 타입 Long)
public interface AddressRepository 
		extends JpaRepository<Address,Long> {

}
