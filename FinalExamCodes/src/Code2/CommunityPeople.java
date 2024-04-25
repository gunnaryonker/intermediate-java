package Code2;

public class CommunityPeople {

	private String name;
	private int age;
	
	//One default constructor that takes nothing as input and initializes name to an empty string and age equals to zero
	public CommunityPeople() {
		name = "";
		age = 0;
	}
	//get and set methods for name and age
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
	
	//void method toString() which print out the name and age of CommunityPeople class
	public void namePrint() {
		System.out.println("Name: " + name.toString() + "\nAge: " + age);
	}
} //End of CommunityPeople class
