package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Class CommonUtil.
 */
public class CommonUtil {
	
	/**
	 * Checks if is past date.
	 *
	 * @param dateStr the date str
	 * @return true, if is past date
	 */
	public static boolean isPastDate(String dateStr) {
		 DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateStr,dateFormat);
		return date.isBefore(LocalDate.now());
	}
	
	/**
	 * Checks if is future date.
	 *
	 * @param dateStr the date str
	 * @return true, if is future date
	 */
	public static boolean isFutureDate(String dateStr) {
		 DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateStr,dateFormat);
		return date.isAfter(LocalDate.now());
	}
	
	/**
	 * Wait for mil seconds.
	 *
	 * @param milsec the milsec
	 */
	public static void waitForMilSeconds(long milsec) {
		try {
			Thread.sleep(milsec);
		} catch (InterruptedException e) {
			
		}
	}
}
