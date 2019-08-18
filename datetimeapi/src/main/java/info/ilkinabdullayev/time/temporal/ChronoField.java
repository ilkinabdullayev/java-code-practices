package info.ilkinabdullayev.time.temporal;

import info.ilkinabdullayev.time.Year;

public enum ChronoField {
    YEAR("Year", ValueRange.of(Year.MIN_VALUE, Year.MAX_VALUE)),
    MONTH_OF_YEAR("MonthOfYear", ValueRange.of(1, 12)),
    DAY_OF_MONTH("DayOfMonth", ValueRange.of(1, 28, 31));

    private final String name;
    private final ValueRange range;

    ChronoField(String name, ValueRange range) {
        this.name = name;
        this.range = range;
    }

    public long checkValidValue(long value) {
        return range().checkValidValue(value, this);
    }

    @Override
    public String toString() {
        return name;
    }

    //TemporalField
    ValueRange range() {
        return range;
    }
}
