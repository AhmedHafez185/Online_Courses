package net.ahmed.app.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	public static boolean compareBirthDate(LocalDate birthDate) {
        LocalDate comparedDate = LocalDate.parse("1996-01-01");
        return birthDate.isBefore(comparedDate);
	}
        public static boolean checkStartDate(LocalDate starthDate) {
        LocalDate comparedDate = LocalDate.now();
        return starthDate.isAfter(comparedDate);
	}
        
        public static boolean compareStartEndDate(LocalDate startDate,LocalDate endDate) {
        return startDate.isBefore(endDate);
	}
}
