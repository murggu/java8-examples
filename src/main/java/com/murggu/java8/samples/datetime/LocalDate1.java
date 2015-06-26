package com.murggu.java8.samples.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * @author Aitor Murguzur
 */
public class LocalDate1 {

    public static void main(String[] args) {

        // LocalDate is immutable and works similar to LocalTime
        LocalDate today = LocalDate.now();
        System.out.println(today);

        // Each date manipulation returns a new date instance
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        System.out.println(tomorrow);

        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println(yesterday);

        LocalDate myBirthday = LocalDate.of(1986, Month.MARCH, 10);
        DayOfWeek dayOfWeek = myBirthday.getDayOfWeek();
        System.out.println(dayOfWeek);

        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale
                .GERMAN);
        LocalDate xmas = LocalDate.parse("24.12.2015", germanFormatter);
        System.out.println(xmas + " | " + xmas.getDayOfWeek());
    }
}
