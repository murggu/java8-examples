package com.murggu.java8.samples.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author Aitor Murguzur
 */
public class LocalDateTime1 {

    /**
     * LocalDateTime is immutable and combines date and time in a single instance
     */
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2015, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        System.out.println(dayOfWeek);

        Month month = dateTime.getMonth();
        System.out.println(month);

        long minuteOfDay = dateTime.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        Instant instant = dateTime
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);


        DateTimeFormatter formatter =
                DateTimeFormatter
                        .ofPattern("MMM dd, yyyy - HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2015 - 07:13", formatter);
        String string = parsed.format(formatter);
        System.out.println(string);
    }
 }
