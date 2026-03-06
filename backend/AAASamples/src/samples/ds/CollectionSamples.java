package samples.ds;

import java.util.*;
import java.util.concurrent.*;

public class CollectionSamples {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(1);// index 0
		list.add(4);// index 1
		list.add(1, 3); // adds to index one and shifts rest
		list.set(1, 2); // sets to index 1 i.e replace
		System.out.println(list);

		List<String> list2 = new LinkedList<>();
		list2.add("test");
		list2.add("testtest");
		list2.add("testtesttest");
		list2.remove(2);

		List<Integer> list3 = new Vector<>();
		list3.add(1);// index 0
		list3.add(4);// index 1
		list3.add(1, 3); // adds to index one and shifts rest
		list3.set(1, 2); // sets to index 1 i.e replace
		System.out.println(list3);

		List<Integer> stack = new Stack<>();
		stack.add(1); // index 0
		stack.add(4); // index 1
		stack.add(1, 3); // adds to index one and shifts rest
		stack.set(1, 2); // sets to index 1 i.e replace
		stack.remove(Integer.valueOf(4));
		stack.add(3); // index 1
		System.out.println(stack);

		List<Integer> cow = new CopyOnWriteArrayList<>();
		cow.add(1);// index 0
		cow.add(4);// index 1
		cow.add(1, 3); // adds to index one and shifts rest
		cow.set(1, 2); // sets to index 1 i.e replace
		System.out.println(cow);

		Map<String, Integer> map = new HashMap<>();
		map.put("testVal1", 123);
		map.put("testVal2", 321);
		map.put("testVal3", 234);
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}

		Map<String, Integer> cmap = new ConcurrentHashMap<>();
		cmap.put("testVal1", 123);
		cmap.put("testVal2", 321);
		cmap.put("testVal3", 234);
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
		cmap.values().stream().forEach(System.out::println);
		
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);// added
		set1.add(1);// duplicate
		set1.add(2);//added
		set1.add(2);//duplicate
		set1.add(null);//allows null
		set1.stream().forEach(System.out::println);

		StringBuilder sbu = new StringBuilder(); // not synchronized, so not thread safe
		StringBuffer sbf = new StringBuffer(); // synchronized so thread safe
		sbu.append("\nsbu a string ");
		sbu.append("sbu another string ");

		sbf.append("\nsbf a string ");
		sbf.append("sbf another string ");

		sbf.append(sbu);
		System.out.println(sbf);

		// autoCloses as sc implements closeable which implements autoClose
//		try(Scanner sc = new Scanner(System.in)){
//			String s = sc.nextLine();
//			System.out.println(s);
//		}

	}
}
