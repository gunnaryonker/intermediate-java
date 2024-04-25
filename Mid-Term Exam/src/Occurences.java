
public class Occurences {
	public static void main(String args[]) {
		String text = "After declaring the Java threat a top priority, Microsoft sought to acquire, invest in, or close deals with several companies to take mindshare away from Java , according to internal Microsoft documents. As part of the strategy, Microsoft sought deals with Metrowerks, Apple Computer, Hewlett-Packard, and Fujitsu for the fight against Java .";
		int javacount = 0;
		int microsoftcount = 0;
		String [] temp = text.trim().split("\\s+");
		//Count occurences of "Java" and "Microsoft"
		while(true) {
			for(int i=0; i<temp.length; i++) {
				if(temp[i].equals("Java")) {
					javacount ++;
				}
				else if(temp[i].equals("Microsoft")) {
					microsoftcount ++;
				}
				else {
					continue;
				}
			}
			break;
		}
		//Print out the count
		System.out.println("The number of occurences of Java is " + javacount + " and the number of occurences of Microsoft is " + microsoftcount);
	}
}
