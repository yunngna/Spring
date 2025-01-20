package com.example.demo;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LamdaTest {
	@Test
	public void sort() {
		List<SampleVO>list = Arrays.asList(
				                            new SampleVO("홍길동", 10),
				                            new SampleVO("김유신", 20),
				                            new SampleVO("최기자", 15)
				                            );
		
		//Collections.sort(list,new SampleCompare());
		//sort() 가 기본 타입이 아닌 경우 클래스를 출력 하는 경우 따로 class를 implement 받아서 만들어 줘야 한다. 
 		//System.out.println(list);
 		
 		
 		//익명클래스
 		Collections.sort(list, new Comparator<SampleVO>() {
 			//생성 
 			@Override
 			public int compare(SampleVO o1, SampleVO o2) {
 				//return o1.age - o2.age;
 				return o2.getName().compareTo(o1.getName());
 				
 				
 			}
 			
 			
 		});
 		System.out.println(list);
 		
 		//new Comparator<SampleVO>() 클래스 선언 + {} 생성 을 동시에 해준다.
 		
 		
 		
 		// 람다(lambda) 식으로 변경 (자바스크립트 화살표 함수 = 자바 람다식) = implements 된 class의 override가 1개 인 경우만 사용
 		Collections.sort(list, (SampleVO o1, SampleVO o2) -> {
 		
 				//return o1.age - o2.age;
 				return o2.getName().compareTo(o1.getName());
 	
 		});
 		System.out.println(list);
	}

}

class SampleCompare implements Comparator<SampleVO>{

	@Override
	public int compare(SampleVO o1, SampleVO o2) {
		//return o1.age - o2.age;
		return o2.getName().compareTo(o1.getName());
	}
	
}
