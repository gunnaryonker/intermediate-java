import java.io.FileInputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TestingCode {
	public static void main(String args[]) {
	
		try {

            int array[][] = new int[3][3];

            int total = 0;

            for (int i=0; i<array.length; i++)

                        for (int j=0; j< array.length; j++) {

                                    array[i][j] = i*j;

                                    total += array[i][j];

                        }

            total *= array[3][3];

            System.out.println(" Value =" + total);

}

catch (Exception e) {

            System.err.println(" Error in computing the total");

}
	}
	}
