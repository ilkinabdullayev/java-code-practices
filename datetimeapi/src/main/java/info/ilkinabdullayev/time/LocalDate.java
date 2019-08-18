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
        return new LocalDate(year, month.getValue(), dayOfMonth);
    }

    public static LocalDate of(
            int year,
            int month,
            int dayOfMonth
    ) {
        YEAR.checkValidValue(year);
        MONTH_OF_YEAR.checkValidValue(month);
        DAY_OF_MONTH.checkValidValue(dayOfMonth);
        return new LocalDate(year, month, dayOfMonth);
    }


    @Override
    public String toString() {
        return String.format("%d-%d-%d", year, month, day);
    }
}

