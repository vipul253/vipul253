package samples.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;

public class LocalDateTimeSample {

	/*
	 * The Java Date and Time API, introduced in Java 8 under the java.time package,
	 * offers a robust, immutable, and thread-safe solution for handling date and
	 * time operations. It was designed to overcome the limitations of the older
	 * java.util.Date and java.util.Calendar
	 */
	public static void main(String[] args) {
		LocalDate today = LocalDate.now(); // Get current date
		LocalTime now = LocalTime.now(); // Get current time
		LocalDateTime todayNow = LocalDateTime.now();
		LocalDateTime specific = LocalDateTime.of(2023, Month.AUGUST, 28, 15, 0); // Create a specific date and time

		System.out.println(today);
		System.out.println(now);
		System.out.println(todayNow);
		System.out.println(specific);

		// all these are immutable so today.plusDays returns
		// a new object and does not change today
		LocalDate tomorrow = today.plusDays(1); // Add one day
		LocalTime after = now.plusHours(3); // Add 3 hours
		System.out.println(after);
		System.out.println(tomorrow);
		
		System.out.println(today.isAfter(tomorrow));
		System.out.println(today.isBefore(tomorrow));
		
		// by zones UTC GMT gg
		ZonedDateTime zone = ZonedDateTime.now();
		System.out.println(zone);
		
	}
}
