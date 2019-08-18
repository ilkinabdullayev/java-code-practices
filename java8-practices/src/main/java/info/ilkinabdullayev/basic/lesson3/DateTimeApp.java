package info.ilkinabdullayev.basic.lesson3;


import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAmount;

import static java.time.Month.*;

public class DateTimeApp {


    public static void main(String[] args) {
        DateTimeApp dateTimeApp = new DateTimeApp();

        LocalDate localDate = LocalDate.of(2019, 03, 27);
        LocalDate localDate2 = LocalDate.of(2019, 03, 27);
        localDate2 = LocalDate.of(2019, APRIL, 27);

        LocalDate localDate3 = LocalDate.now();
        LocalDate localDate4 = localDate3.withYear(2017);
        localDate4 = localDate3.with(
                ChronoField.DAY_OF_MONTH, 21
        );

        Period period = Period.ofDays(20);
        localDate = localDate.plus(period);

        System.out.println(localDate);

    }


}

