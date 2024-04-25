package test;

import java.util.*;



public class MyClass extends MySuperclass {

                        public static void main(String args[] ) {

 

                        MyClass object = new MyClass( );

                        StringTokenizer tokens = new StringTokenizer (object.msg.text,"--");

                        while (tokens.hasMoreTokens())

                                    System.out.println(tokens.nextToken());

}

} // end of MyClass