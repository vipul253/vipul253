package samples.interview;

import java.util.HashMap;
import java.util.Map;

public class UrlShortenerSample {

	private static final String BASE_URL = "https://short.io/";
	private static long counter = 1; // Auto-incremental ID
	private static Map<String, String> urlMap = new HashMap<>();
	private static Map<String, String> reverseMap = new HashMap<>();

	public static String shortenUrl(String longUrl) {
		if (reverseMap.containsKey(longUrl)) {
			return reverseMap.get(longUrl);
		}
		String shortKey = encodeBase62(counter);
		counter++;
		urlMap.put(shortKey, longUrl);
		reverseMap.put(longUrl, shortKey);
		return BASE_URL + shortKey;
	}

	public static String getLongUrl(String shortUrl) {
		String shortKey = shortUrl.replace(BASE_URL, "");
		return urlMap.getOrDefault(shortKey, "URL not found");
	}

	private static String encodeBase62(long number) {
		final String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			sb.append(characters.charAt((int) (number % characters.length())));
			number /= characters.length();
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		String tiny = UrlShortenerSample.shortenUrl("https://codexbook.medium.com/f10de870");
		System.out.println(tiny);
		
	}
}
