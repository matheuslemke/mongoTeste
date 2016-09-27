package util;

import java.util.Date;

public class DateParser {
    /**
     * Receives a string of date in format DD/MM/YY
     * 
     * @return date in format MM/DD/YY
     */
    @SuppressWarnings("deprecation")
    public static Date toUniversalFormat(String brazilDate) {
	String[] brazilDateArray = brazilDate.split("/");
	int day = Integer.valueOf(brazilDateArray[0]);
	int month = Integer.valueOf(brazilDateArray[1]) - 1;
	int year = Integer.valueOf(brazilDateArray[2]) + 100;
	return new Date(year, month, day);
    }

    /**
     * Receives a date in format MM/DD/YY
     * 
     * @return string of date in format DD/MM/YY
     */
    @SuppressWarnings("deprecation")
    public static String toBrazilFormat(Date universalDate) {
	StringBuilder sb = new StringBuilder();
	sb.append(universalDate.getDate());
	sb.append("/");
	sb.append(universalDate.getMonth() + 1);
	sb.append("/");
	sb.append(universalDate.getYear() + 1900);
	return sb.toString();
    }
}
