package samples.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayBatchListExample {
	public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            originalList.add("Item " + i);
        }
        int batchSize = 3;
        List<List<String>> batches = new ArrayList<>();
        for (int i = 0; i < originalList.size(); i += batchSize) {
            int endIndex = Math.min(i + batchSize, originalList.size());
            List<String> batch = originalList.subList(i, endIndex);
            batches.add(batch);
        }
        for (List<String> batch : batches) {
            System.out.println(batch);
        }
        int[] originalArray = {1, 3, 2, 5, 4, 6, 8, 13, 15, 17, 19};
        arrayBatchSample(originalArray);
    }
	//in case of primitive [] array, as sublist return view of list not actual list.
	public static void arrayBatchSample(int[] originalArray) {
        int batchSize = 3;
        List<int[]> batches = new ArrayList<>();
        for (int i = 0; i < originalArray.length; i += batchSize) {
            int endIndex = Math.min(i + batchSize, originalArray.length);
            int[] batch = Arrays.copyOfRange(originalArray, i, endIndex);
            batches.add(batch);
        }
        for (int[] batch : batches) {
            System.out.println(Arrays.toString(batch));
        }
    }
}
