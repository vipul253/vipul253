package samples.ds;

public class TestDS {

	public static void main(String[] args) {
		CustomHashMap<String, Integer> myMap = new CustomHashMap<>();
		
		myMap.put("bob", 67);
		myMap.put("satan",666);
		
		System.out.println(myMap.size());
		
		System.out.println("bob = "+myMap.get("bob"));
		System.out.println("satan = "+myMap.get("satan"));
		System.out.println("abcd = "+myMap.get("abcd")); // does not exist so null
		
		myMap.remove("satan");
		myMap.put("25thBam", 777);
		System.out.println("satan = "+myMap.get("satan")); // removed so null
		System.out.println("25thBam = "+myMap.get("25thBam"));
		System.out.println("abcd = "+myMap.remove("abcd")); //does not exist
		
		System.out.println(myMap.size());
		
	}
}
