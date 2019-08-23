package info.ilkinabdullayev.basic.lesson3;


import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;

import static java.time.Month.*;

public class DateTimeApp {


    public static void main(String[] args) {
        DateTimeApp dateTimeApp = new DateTimeApp();
        dateTimeApp.initLocalDateSamples();
        dateTimeApp.initLocalTimeSamples();
        dateTimeApp.initLocalDateTimeSamples();
       // dateTimeApp.initZoneIdSamples();
        dateTimeApp.initZonedDateTimeSamples();
    }

    private void initLocalDateSamples() {
        LocalDate now = LocalDate.now();
        System.out.println("Now:" + now);

        LocalDate localDate = LocalDate.of(2019, APRIL, 29);
        System.out.println("LocalDate.of(2019, APRIL, 29):" + localDate);

        //invalid date
        try {
            LocalDate.of(2019, FEBRUARY, 29);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        now = now.withYear(2012);
        System.out.println("Now:" + now);

        now = now.with(ChronoField.MONTH_OF_YEAR, 11);
        System.out.println("Now:" + now);

        String previousDate = localDate.toString();
        localDate = localDate.plusDays(2);
        System.out.println(previousDate + " + 2 days:" + localDate);

        previousDate = localDate.toString();
        localDate = localDate.plus(1, ChronoUnit.MONTHS);
        System.out.println(previousDate + " + 1 month:" + localDate);

        previousDate = localDate.toString();
        localDate = localDate.minus(Period.ofYears(1));
        System.out.println(previousDate + " - 1 year:" + localDate);
    }

    private void initLocalTimeSamples() {
        LocalTime now = LocalTime.now();
        System.out.println("Now:" + now);

        LocalTime localTime = LocalTime.of(02, 22);
        System.out.println("LocalTime.of(02, 22):" + localTime);


        //invalid time
        try {
            LocalTime.of(28, 32);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        now = now.withHour(2);
        System.out.println("Now:" + now);

        now = now.with(ChronoField.HOUR_OF_DAY, 20);
        System.out.println("Now:" + now);

        String previousTime = localTime.toString();
        localTime = localTime.plusHours(4);
        System.out.println(previousTime + " + 4 hours:" + localTime);

        previousTime = localTime.toString();
        localTime = localTime.plus(1, ChronoUnit.MINUTES);
        System.out.println(previousTime + " + 1 minute:" + localTime);

        previousTime = localTime.toString();
        localTime = localTime.minus(Duration.ofSeconds(82));
        System.out.println(previousTime + " - 82 seconds:" + localTime);
    }

    private void initLocalDateTimeSamples() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now:" + now);

        LocalDate nowDate = now.toLocalDate();
        System.out.println("nowDate:" + nowDate);

        LocalTime nowTime = now.toLocalTime();
        System.out.println("nowTime:" + nowTime);

        LocalDateTime localDateTime = LocalDateTime.of(2010, AUGUST, 12, 1, 23, 22);
        System.out.println("LocalDateTime.of(2010, AUGUST, 12, 1, 23, 22):" + localDateTime);

        System.out.println("localDateTime.getHour():" + localDateTime.getHour());


        localDateTime = localDateTime.plusDays(23)
                .minusMonths(3)
                .plusNanos(200000)
                .plusHours(22)
                .plusYears(2);
        System.out.println("You can't calculate manually whether the result is ok. Can you? :) New localDateTime:" + localDateTime);
    }

    private void initZoneIdSamples() {
        ZoneId.getAvailableZoneIds()
                .stream()
                .sorted()
                .forEach(System.out::println);

        ZoneId defaultZoneID = ZoneId.systemDefault();
        System.out.println("defaultZoneID:" + defaultZoneID);
    }

    private void initZonedDateTimeSamples() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("Now:" + now);

        //what time is it in Japan?
        ZoneId japanZone = ZoneId.of("Japan");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(japanZone);
        System.out.println("Japan ZonedDateTime:" + zonedDateTime);

        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        System.out.println("zonedDateTime.toLocalDateTime():" + localDateTime);

        zonedDateTime = ZonedDateTime.of(localDateTime, japanZone);
        System.out.println("ZonedDateTime:" + zonedDateTime);
    }
}

