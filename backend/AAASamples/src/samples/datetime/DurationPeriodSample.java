package samples.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class DurationPeriodSample {

	public static void main(String[] args) {
		// Instant, Duration, Period
		Instant timer = Instant.now();
		System.out.println(timer.getEpochSecond());
		// A moment is generally an indefinite, short period of time,
		// but historically it was a medieval unit equivalent to 90 seconds.
		// Today, it commonly refers to a few seconds to a few minutes,
		// Duration is time based amount in nano second, second, hours, minutes
		// Duration is compatible with LocalDate and LocalTime
		Duration moment = Duration.ofSeconds(90);
		// will give 1min and skip 0.30 part
		System.out.println(moment.toMinutes());

		// Period is date based amount in days months years
		// Period is only compatible with LocalDate
		Period twoDays = Period.ofDays(2);
		// will give 0 because its less than one month
		System.out.println(twoDays.toTotalMonths());
		System.out.println(moment.toString());
		System.out.println(twoDays.toString());

		LocalTime timeNow = LocalTime.now();
		LocalTime timeNowPlusHour = timeNow.plusHours(1);

		// LocalDate - LocalDate wont work because it does not have time component,
		// Duration needs time component
		Duration diff = Duration.between(timeNow, timeNowPlusHour);
		System.out.println(diff);

		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		// Period takes only Date components
		Period days = Period.between(today, tomorrow);
		System.out.println(days);
	}
}
