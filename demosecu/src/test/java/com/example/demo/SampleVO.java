package com.example.demo;

public class SampleVO {
	String name;
	int age;
	
	//constructor using field
	public SampleVO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//toString 
	 @Override
	public String toString() {
		return "SampleVO [name=" + name + ", age=" + age + "]";
	}
	//getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
