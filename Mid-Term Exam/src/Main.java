
public class Main {
	@SuppressWarnings("removal")
	public static void main(String args[]) {
		
		int items[][] = { { 1 }, { 2, 3, 4, 5 }, { 6, 7 } };
		
		Foo a = new Foo();

        Bar b = new Bar( );
        
        b.f( );  is legal 
        
        b.g((new Integer(3)).toString());
	}
	
	
}


