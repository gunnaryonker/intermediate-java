package test2;

public class MyStringClass {

	int mystery (int number) {

	       int result = 0;   

	        while (number > 0) {

	               number /= 10;

	               result ++;

	       }

	       return result;

	}

}
