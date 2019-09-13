package com.msalihkocak.date;

public class DateUtil {
    /**
     * Is leap year
     * @param year 4 digit year
     * @return true if year is a leap year
     */

    public static boolean isLeapYear(int year) {
        return isDivisible(year, 4) &&
                (!isDivisible(year, 100) || isDivisible(year,400));
    }

    private static boolean isDivisible(int number, int divisor){
        return number % divisor == 0;
    }

    public static boolean returnTrue() {
        return true;
    }
}
