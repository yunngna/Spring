package com.example.demo.customer.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//인터페이스끼리 상속 = extends (CustomerDTO 의 id (기본키) 타입 Long)
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	 public List<Customer> findByNameLike(String keyword);
	 
	 //이름도 like or phone like order by _____ desc
	 public List<Customer> findByNameLikeOrPhoneLikeOrderByNameDesc(String name,String phone);
	 
	 
	 //직접 만드는 경우 (쿼리)
	 @Query("select c from Customer c where id = :id and phone = :phone order by name desc")
	 // 여기서 Customer = 테이블 이름이 아니라 DTO 의 네임을 적어줘야 한다. 
	 public Optional<Customer> findById(@Param("id") Long id,
			 							@Param("phone") String phone); 
	                                    //@Param 으로 이름 지정후 쿼리에 적용 해 준다. (@Param("id") -> where id = :id)
	 
}
