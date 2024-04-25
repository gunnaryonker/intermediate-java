package Project4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * Author: Gunnar Yonker
 * File: FileReport.java
 * Description: Class file that can be called to, that will print out the required formatting for project 4
 */

public class FileReport {

	private ArrayList<Skater> skaters;
	
	public FileReport() {
		super();
		this.skaters = new ArrayList<Skater>();
	}
	//getters and setters
	public ArrayList<Skater> getSkaters(){
		return skaters;
	}
	public void setSkaters(ArrayList<Skater> skaters) {
		this.skaters = skaters;
	}
	
	public void fullPrint()	{
		//Find the youngest male
		Skater youngm = skaters.get(0);
		for(int i=0; i<this.skaters.size(); i++) {
				if(this.skaters.get(i).getAge() < youngm.getAge() && this.skaters.get(i).getGender().equals("M")) {
						youngm = this.skaters.get(i);
				}
		}
		System.out.println("Youngest skater in Mens Event(event code = M): " + youngm.getName() + " " + youngm.getAge());
		//Find the youngest female
		Skater youngf = skaters.get(0);
		for(int i=0; i<this.skaters.size(); i++) {
				if(this.skaters.get(i).getAge() < youngf.getAge() && this.skaters.get(i).getGender().equals("F")) {
						youngf = this.skaters.get(i);
				}
		}
		System.out.println("Youngest skater in Ladies Event(event code = L): " + youngf.getName() + " " + youngf.getAge());
		
		//Convert the height to inches for each skater
		int[] totheight = new int[skaters.size()];
		for(int i=0; i<this.skaters.size(); i++) {
			String temp = skaters.get(i).getHeight();
			String[] words = temp.split("[']");
			//Convert feet to inches and add the existing inches
			String hint = words[1].replaceAll("^\"|\"$", "");
			int tempfeet = Integer.parseInt(words[0]);
			int tempinches = Integer.parseInt(hint);
			totheight[i] = (tempfeet*12) + tempinches;
		}
		//Find the shortest male skater
		Skater mminheight = skaters.get(0);
		int minh = totheight[0];
		for(int i=0; i<this.skaters.size()-1; i++) {
			if(totheight[i] < minh && this.skaters.get(i).getGender().equals("M")) {
					mminheight = this.skaters.get(i);
					minh = totheight[i];
				}
			else {
				continue;
			}
		}
		//Find the tallest male skater
		Skater mmaxheight = skaters.get(0);
		int maxh = totheight[0];
		for(int i=0; i<this.skaters.size()-1; i++) {
			if(totheight[i] > maxh && this.skaters.get(i).getGender().equals("M")) {
				mmaxheight = this.skaters.get(i);
				maxh = totheight[i];
			}
			else {
				continue;
			}
		}
		System.out.println("Height range for Men skaters: " + mminheight.getHeight() + " - " + mmaxheight.getHeight());
		
		//Find the shortest female skater
		Skater fminheight = skaters.get(0);
		int fminh = totheight[0];
		for(int i=0; i<this.skaters.size()-1; i++) {
			if(totheight[i] < fminh && this.skaters.get(i).getGender().equals("F")) {
					fminheight = this.skaters.get(i);
					fminh = totheight[i];
				}
			else {
				continue;
			}
		}
		//Find the tallest female skater
		Skater fmaxheight = skaters.get(0);
		int fmaxh = totheight[0];
		for(int i=0; i<this.skaters.size()-1; i++) {
			if(totheight[i] > fmaxh && this.skaters.get(i).getGender().equals("F")) {
				fmaxheight = this.skaters.get(i);
				fmaxh = totheight[i];
			}
			else {
				continue;
			}
		}
		System.out.println("Height range for Ladies skaters: " + fminheight.getHeight() + " - " + fmaxheight.getHeight());
		
		//List of all the states where skaters are from(no duplicate values)
		System.out.println("");
		System.out.println("List of States Skaters are from:");
		System.out.println("--------------------------------");
		Set<String> states = new HashSet<String>();
		for(int i=0; i<this.skaters.size(); i++) {
			String tempstate = this.skaters.get(i).getState();
			states.add(tempstate);
		}
		for (String stateprints : states) {
		    System.out.println(stateprints);
		}
	}
}
