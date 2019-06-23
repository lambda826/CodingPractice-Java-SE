package javaSe.java8.datatimes;

import static utils.Print.print;
/*

Immutable
Plain date without the time
Doesn't carry any information about the time zone

*/

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class _001_LocalDate {

	public static void main(String[] args) {

		print("Use LocaDate ======");
		// Obtain the current date from the system clock
		LocalDate today = LocalDate.now();
		print(today);
		// Create an instance by using the of static factory method
		LocalDate date = LocalDate.of(2017, 9, 21);
		print(date);
		print("      Year: " + date.getYear());
		print("     Month: " + date.getMonth());
		print("     Month: " + date.getMonthValue());
		print("   Day of Month: " + date.getDayOfMonth());
		print("    Day of Week: " + date.getDayOfWeek());
		print("Length of Month: " + date.lengthOfMonth());
		print("    Is Leapyear: " + date.isLeapYear());
		print();
		print("      Year: " + date.get(ChronoField.YEAR));
		print("     Month: " + date.get(ChronoField.MONTH_OF_YEAR));
		print("   Day of Month: " + date.get(ChronoField.DAY_OF_MONTH));
		print();

		print("Use LocalTime ======");
		LocalTime time = LocalTime.of(13, 45, 20); // 13:45:20
		print(time);
		print("                             Hour: " + time.getHour());
		print("    Minute: " + time.getMinute());
		print("    Second: " + time.getSecond());
		print();

		print("Use LocalDateTime ======");
		LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		LocalDateTime dt3 = date.atTime(13, 45, 20);
		LocalDateTime dt4 = date.atTime(time);
		LocalDateTime dt5 = time.atDate(date);
		LocalDate date1 = dt1.toLocalDate();
		LocalTime time1 = dt1.toLocalTime();
		print();

		print("Use instant ======");
		Instant instant = Instant.ofEpochSecond(44 * 365 * 86400);
		Instant now = Instant.now();
		print();

	}

}
