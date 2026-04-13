package samples.interview;

import java.util.ArrayList;

public class AutoBoxingSample {

	/*
	 * Wrapper class in Java is one whose object wraps or contains primitive data
	 * types. This leads to two key features: Autoboxing and Unboxing.
	 * 
	 * 1. Autoboxing The automatic conversion of primitive types to the object of
	 * their corresponding wrapper classes is known as autoboxing. For example:
	 * conversion of int to Integer, long to Long, double to Double, etc.
	 * 
	 * 2. Unboxing It is just the reverse process of autoboxing. Automatically
	 * converting an object of a wrapper class to its corresponding primitive type
	 * is known as unboxing. For example, conversion of Integer to int, Long to
	 * long, Double to double, etc.
	 */
	public static void main(String[] args) {

		// Creating an Integer Object with custom value say it be 10
		//Integer i = new Integer(10); depricated since J9
		Integer i = 10;
		// Unboxing the Object
		int i1 = i;

		// Print statements
		System.out.println("Value of i:" + i);
		System.out.println("Value of i1: " + i1);

		// Autoboxing of character
		Character gfg = 'a';

		// Auto-unboxing of Character
		char ch = gfg;

		// Print statements
		System.out.println("Value of ch: " + ch);
		System.out.println(" Value of gfg: " + gfg);
		
		// Creating an empty Arraylist of integer type
        ArrayList<Integer> al = new ArrayList<Integer>();

        // Adding the int primitives type values using add() method Autoboxing
        al.add(1);
        al.add(2);
        al.add(24);

        // Printing the ArrayList elements
        System.out.println("ArrayList: " + al);
	}
}
