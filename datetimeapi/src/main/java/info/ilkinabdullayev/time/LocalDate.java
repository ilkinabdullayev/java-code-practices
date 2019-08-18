package info.ilkinabdullayev.time;

import java.util.Objects;

import static info.ilkinabdullayev.time.temporal.ChronoField.YEAR;
import static info.ilkinabdullayev.time.temporal.ChronoField.MONTH_OF_YEAR;
import static info.ilkinabdullayev.time.temporal.ChronoField.DAY_OF_MONTH;

public final class LocalDate {

    private final int year;
    private final int month;
    private final int day;

    private LocalDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static LocalDate of(
            int year,
            Month month,
            int dayOfMonth
    ) {
        YEAR.checkValidValue(year);
        Objects.requireNonNull(month, "month");
        DAY_OF_MONTH.checkValidValue(dayOfMonth);
        return create(year, month.getValue(), dayOfMonth);
    }

    public static LocalDate of(
            int year,
            int month,
            int dayOfMonth
    ) {
        YEAR.checkValidValue(year);
        MONTH_OF_YEAR.checkValidValue(month);
        DAY_OF_MONTH.checkValidValue(dayOfMonth);
        return create(year, month, dayOfMonth);
    }


    private static LocalDate create(int year, int month, int dayOfMonth) {
        if (dayOfMonth > 28) {
            int dom = 31;
            switch (month) {
                case 2:
                    dom = LocalDate.isLeapYear(year) ? 29 : 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    dom = 30;
                    break;
            }

            if (dayOfMonth > dom) {
                if (dayOfMonth == 29) {
                    throw new DateTimeException("Invalid Date 'February 29' as " + year + " is not a leap year");
                } else {
                    throw new DateTimeException("Invalid Date '" + Month.of(month).name() + " " + dayOfMonth + "'");
                }
            }
        }




        return new LocalDate(year, month, dayOfMonth);
    }

    //IsoChronology
    public static boolean isLeapYear(int prolepticYear) {
        return ((prolepticYear & 3) == 0) && ((prolepticYear % 100) != 0 || (prolepticYear % 400) == 0);
    }


    @Override
    public String toString() {
        return String.format("%d-%d-%d", year, month, day);
    }
}

