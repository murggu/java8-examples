package com.murggu.java8.samples.datetime;

import java.sql.Date;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * @author Aitor Murguzur
 */
public class ClockAndLocalTime {


    public static void main(String[] args) {

        clockSamples();
        localTimeSamples();
    }

    private static void localTimeSamples() {
        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);

        LocalTime zurichLocalTime = LocalTime.now(ZoneId.of("Europe/Zurich"));
        LocalTime athensLocalTime = LocalTime.now(ZoneId.of("Europe/Athens"));

        System.out.println(zurichLocalTime);
        System.out.println(athensLocalTime);

        long hoursBetween = ChronoUnit.HOURS.between(zurichLocalTime, athensLocalTime);
        System.out.println(hoursBetween);

        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime midnight = LocalTime.MIDNIGHT;
        System.out.println(midnight);

        LocalTime lunchTime = LocalTime.of(13, 00, 00);
        System.out.println(lunchTime);

        DateTimeFormatter ukFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.UK);
        LocalTime ukTime = LocalTime.parse("21:59", ukFormatter);
        System.out.println(ukTime);
    }

    private static void clockSamples() {
        // Clock is aware of timezone and replaces System.currentTimeMillis()
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());

        // Instant can be used to create legacy java.util.Date objects
        Instant instant = clock.instant();
        System.out.println("legacy date :" + Date.from(instant));
    }
}
