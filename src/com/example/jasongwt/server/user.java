package com.example.jasongwt.server;

import java.util.LinkedList;
import java.util.List;




public class user {
	private String name;
	private int age;
	
	private List<String> children = new LinkedList<String>();
	
	public user(String name, int age,List<String> children){
		this.name = name;
		this.age = age;
		this.children = children;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public List<String> getChildren(){
		return children;
	}
	public void setChildren(List<String> children){
		this.children = children;
	}
	
	
	
	
	
	
}
