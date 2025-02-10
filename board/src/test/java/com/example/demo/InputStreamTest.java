package com.example.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputStreamTest {
	//@Test
	//@DisplayName("파일입력")
	public void test1() throws IOException {
		//키보드 입력을 파일로 저장 (파일 관련된 메소드는 예외처리 필요)
		FileOutputStream fw = new FileOutputStream("c:/Temp/data.txt"); //파일 생성
		
		int readByte;
		while((readByte = System.in.read()) != -1) { //ctrl + z  종료
			fw.write(readByte);
		}
		fw.close();
	}
	
//	@Test 
//	@DisplayName("파일읽기")
	public void test2() throws IOException {
		//키보드 입력을 파일로 저장 (파일 관련된 메소드는 예외처리 필요)
		FileInputStream fi = new FileInputStream("c:/Temp/data.txt"); //파일 생성
		
		int readByte;
		while((readByte = fi.read()) != -1 ) { //ctrl + z  종료
			System.out.print((char)readByte);
		}
		fi.close();
		
	}
	
//	@Test 
//	@DisplayName("파일복사")
//	FileInputStream , FileOutputStream 둘다 필요
//	public void test3() throws IOException {
//	
//		FileOutputStream fi = new FileOutputStream("c:/Temp/data.txt");
//		FileInputStream fo = new FileInputStream("c:/Temp/data.txt"); 
//		
//		int readByte;
//		while((readByte = fi.read()) != -1 ) { 
//			fo.write(readByte);
//		}
//		fi.close();
//		fo.close();
//		
//	}
	
	
	
	
}
