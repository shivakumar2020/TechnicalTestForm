package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommonUtil {
	public static boolean isPastDate(String dateStr) {
		 DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateStr,dateFormat);
		return date.isBefore(LocalDate.now());
	}
	public static boolean isFutureDate(String dateStr) {
		 DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateStr,dateFormat);
		return date.isAfter(LocalDate.now());
	}
	public static void waitForMilSeconds(long milsec) {
		try {
			Thread.sleep(milsec);
		} catch (InterruptedException e) {
			
		}
	}
}
