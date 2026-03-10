package samples.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFileSample {
	public static void main(String[] args) {
		// Specify the name of the file you want to read
		String fileName = "F:\\vipDev\\workspace1\\input.txt";

		// Use try-with-resources to ensure the BufferedReader and FileReader are closed
		// automatically
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;

			// Read each line of the file until the end is reached (readLine() returns null)
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// Handle exceptions such as FileNotFoundException or other I/O errors
			System.err.println("Error reading file: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
