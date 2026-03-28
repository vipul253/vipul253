package samples.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListFailFastDemo {

	public static void main(String[] args) {
		// general array list is fail fast so does not support concurrent modification
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		System.out.println(list1);
		Iterator<Integer> itr1 = list1.iterator();
		while (itr1.hasNext()) {
			if (itr1.next() == 3) {
				//list.remove(3);// list.add(3,2) both will give java.util.ConcurrentModificationException
			}
		}
		//System.out.println(list1);
		
		//Fail Safe list from concurrency package
		List<Integer> list2 = new CopyOnWriteArrayList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		System.out.println(list2);
		Iterator<Integer> itr2 = list2.iterator();
		while (itr2.hasNext()) {
			if (itr2.next() == 3) {
				list2.remove(3-1);//0 based index
			}
		}
		System.out.println(list2);
	}
}
