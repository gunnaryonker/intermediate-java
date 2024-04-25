package Code2;

public class Main {
	public static void main(String args[]) {
	//Create object person 1 of Community people class and another object object 1 of faculty
	CommunityPeople person1 = new CommunityPeople();
	Faculty object1 = new Faculty();
	//change the default name of faculty to "Greg Johnson" by using object1 and dot notation to call setName method
	object1.setName("Greg Johnson");
	//Change the default name of CommunityPeople class by using person1 and dot notation to call setName method
	//(changing name to john doe since it is not specified in prompt
	person1.setName("John Doe");

	//not specified in prompt, but both objects could use setAge
	//object1.setAge(23); person1.setAge(24)
	
	//object1 can have employment set
	//object1.setEmployment("Cashier");
	
	//Print call dot notations could be
	//object1.namePrint();
	//object1.jobPrint();
	//person1.namePrint();
	
	}
} //End of Main class