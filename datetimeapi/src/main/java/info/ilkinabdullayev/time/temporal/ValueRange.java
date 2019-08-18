package info.ilkinabdullayev.time.temporal;

import info.ilkinabdullayev.time.DateTimeException;

import java.io.Serializable;

public final class ValueRange implements Serializable {

    private static final long serialVersionUID = -7317881728594519368L;

    private final long minSmallest;
    private final long minLargest;
    private final long maxSmallest;
    private final long maxLargest;

    private ValueRange(long minSmallest, long minLargest, long maxSmallest, long maxLargest) {
        this.minSmallest = minSmallest;
        this.minLargest = minLargest;
        this.maxSmallest = maxSmallest;
        this.maxLargest = maxLargest;
    }

    public static ValueRange of(long min, long max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }

        return new ValueRange(min, min, max, max);
    }

    public static ValueRange of(long min, long maxSmallest, long maxLargest) {
        return of(min, min, maxSmallest, maxLargest);
    }

    public static ValueRange of(long minSmallest, long minLargest, long maxSmallest, long maxLargest) {
        if (minSmallest > minLargest) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        }
        if (maxSmallest > maxLargest) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (minLargest > maxLargest) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new ValueRange(minSmallest, minLargest, maxSmallest, maxLargest);
    }

    public long checkValidValue(long value, ChronoField chronoField) {
        //Questions:Q1: Why is boolean checked as below
        if (isValidValue(value) == false) {
            throw new DateTimeException(getInvalidFieldMessage(chronoField, value));
        }

        return value;
    }

    public boolean isValidValue(long value) {
        return (value >= getMinimum() && value <= getMaximum());
    }

    private String getInvalidFieldMessage(ChronoField field, long value) {
        return "Invalid value for " + field + " (valid values " + this + "): " + value;
    }

    public long getMinimum() {
        return minSmallest;
    }

    public long getLargestMinimum() {
        return minLargest;
    }

    public long getSmallestMaximum() {
        return maxSmallest;
    }

    public long getMaximum() {
        return maxLargest;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ValueRange) {
            ValueRange other = (ValueRange) obj;
            return minSmallest == other.minSmallest && minLargest == other.minLargest &&
                    maxSmallest == other.maxSmallest && maxLargest == other.maxLargest;
        }
        return false;
    }


    @Override
    public int hashCode() {
        long hash = minSmallest + (minLargest << 16) + (minLargest >> 48) +
                (maxSmallest << 32) + (maxSmallest >> 32) + (maxLargest << 48) +
                (maxLargest >> 16);
        return (int) (hash ^ (hash >>> 32));
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(minSmallest);
        if (minSmallest != minLargest) {
            buf.append('/').append(minLargest);
        }
        buf.append(" - ").append(maxSmallest);
        if (maxSmallest != maxLargest) {
            buf.append('/').append(maxLargest);
        }
        return buf.toString();
    }
}
