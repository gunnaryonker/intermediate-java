package Project4;

/*
 * Author: Gunnar Yonker
 * File: Person.java
 * Description: Class file with the constructor, getters and setters for the person information objects
 */

public class Person {
		protected String name;
		protected int age;
		protected String height;
		protected String gender;
		protected String state;

		public Person() {
			super();
		}
		
		public Person(String name, int age, String height, String gender, String state) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.gender = gender;
		this.state = state;
	}
		
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
	
	public String getHeight() {
		return height;
	}
	
	public void setHeight(String height) {
		this.height = height;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
}