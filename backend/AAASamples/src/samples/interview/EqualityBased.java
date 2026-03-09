package samples.interview;

public class EqualityBased {

	public static void main(String[] args) {
		String a = "test";
		String b = "test";
		
		//true as it is string literal values
		System.out.println(a==b); 
		
		String c = new String("test");
		//false as c is new object in heap not in pool
		System.out.println(a==c);
		
		String d = new String("test");
		//false as c is new object in heap and d is also separare obj in heap
		System.out.println(d==c);
	}
}
