package samples.general;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
	public static void main(String[] args) {
        /*To find anagrams i.e word with same count of each letter used e.g anagram / margana */
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(isAnagram(s1, s2));
        in.close();
    }
    public static String isAnagram(String s1, String s2) { 
        
        // Handle null strings
        if (s1 == null || s2 == null) {
            return "Not Anagrams";
        }

        // Remove whitespace and convert to lowercase for case-insensitive comparison
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        // If lengths are different, they cannot be anagrams
        if (s1.length() != s2.length()) {
            return "Not Anagrams";
        }

        // Convert strings to character arrays
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        
        // Sort the character arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        if(Arrays.equals(charArray1, charArray2)){
            return "Anagrams";
        }else{
            return "Not Anagrams";
        }
    }

}
