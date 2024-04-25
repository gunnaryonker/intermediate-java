package Code2;

public class Faculty extends CommunityPeople {

	private String typeofemployment;
	
	//One default constructor that takes nothing as input(set typeofemployment to unemployed as default)
	public Faculty() {
		super();
		typeofemployment = "Unemployed";
	}
	//Call constructor of parent class using super()
	public String getEmployment() {
		return typeofemployment;
	}
	public void setEmployment(String typeofemployment) {
		this.typeofemployment = typeofemployment;
	}
	//a void method toString which prints the type of employment
	public void jobPrint() {
		System.out.println("Type of Employment: " + typeofemployment.toString());
	}	
} //End of Faculty class
