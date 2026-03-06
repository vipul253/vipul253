package samples.general;

public class StringManipulation {

	/*
	 * In Java, string literals (created with double quotes, like "Hello") are
	 * stored in the String Constant Pool, which resides in the heap memory. This
	 * allows Java to reuse identical string values and save memory.
	 * 
	 * However, strings created using the new keyword (like new String("Hello")) are
	 * always created as new objects in the heap, outside the String Constant Pool.
	 * These are distinct objects even if their content is the same.
	 * 
	 * To add such a new string to the String Pool, you must explicitly use the
	 * intern() method: String s1 = new String("Hello"); String s2 = s1.intern();
	 * this adds to String Pool if not already present
	 * 
	 * Key Points: String literals → automatically go to the String Pool (in heap).
	 * new String(...) → creates object in heap, not in pool. intern() → forces a
	 * string into the pool, returning a reference to the pooled instance. This
	 * mechanism optimizes memory and performance through string interning.
	 */
	public static void main(String[] args) {

		// String Constant Pool contains only unique strings
		// "pool" added to String Constant Pool, which resides in the heap memory
		String a = "pool";
		// Same object by different name b pointing to same address in heap
		String b = "pool";

		System.out.println("a  " + a.hashCode() + " b " + b.hashCode());
		System.out.println("a == b " + (a == b ? "YES" : "NO"));
		System.out.println("a equals b " + (a.equals(b) ? "YES" : "NO"));
		System.out.println();

		// now we use new keyword and check, "pool" is not in String Pool, just in heap
		// new creates new Obj not in pool with diff id but same Hash value.
		String c = new String("pool");
		System.out.println("a  " + a.hashCode() + " c " + c.hashCode());
		// same hash becos string is same in pool
		System.out.println("a == c " + (a == c ? "YES" : "NO"));
		System.out.println("a equals c " + (a.equals(c) ? "YES" : "NO"));
		System.out.println();

		// now we use intern() and check
		// if "pool" is in string pool then return the reference
		String d = a.intern();
		System.out.println("a  " + a.hashCode() + " d " + d.hashCode());
		// same hash becos string is same in pool
		System.out.println("a == d " + (a == d ? "YES" : "NO"));
		System.out.println("a equals d " + (a.equals(d) ? "YES" : "NO"));
	}
}
