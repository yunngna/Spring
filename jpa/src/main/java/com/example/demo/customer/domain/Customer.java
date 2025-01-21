package com.example.demo.customer.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Getter;

@Getter // @data로 setter, getter둘다 안넣고 getter만 넣어준다.
@Entity //CustomerDTO 의 테이블을 형성 해준다.
//@Table(name="cust")// 생성되는 데이블 이름 변경

public class Customer {
	//생성자 만들기
	   public Customer(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	   //기본생성자 생성
	 public Customer() {}

	 //setPhone 만 setter 만들기
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

	@Id // 기본키 임을 알려준다 (기본키 = id)
	   @GeneratedValue(strategy = GenerationType.AUTO) //기본키에 seq을 생성  (GenerationType.auto = mysql,oracle에 따라 알아서 seq만들어 준다.)
	    private Long id;
	    
	   //@Column(name="username", length=50, nullable=false) // 컬럼의 조건을 변경 가능 하다.
	    private String name;
	    
	   //@Column(columnDefinition = "clob")//columnDefinition = 데이터 타입 지정
	    private String phone;  
	    
//	    @OneToOne
//	    @JoinColumn(name = "address_id") // address 의 id 컬럼으로 조인 
//	    Address address;
	    
	    //한사람당 여러개의 주소
//	    @OneToMany(mappedBy = "customer") //조인할 테이블
//	    List<Address> address;
    
	    @Transient // create 시 해당 컬럼은 빠지고 테이블 생성
 	    private String addr;
	    
	    @Transient
	    private String grade;
	    
	   
}
