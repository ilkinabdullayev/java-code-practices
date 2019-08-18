package info.ilkinabdullayev;

import info.ilkinabdullayev.time.LocalDate;
import info.ilkinabdullayev.time.Month;

public class Main {

    public static void main(String[] args) {
        LocalDate localDate  = LocalDate.of(2019, 03, 27);
        System.out.println(localDate);

        LocalDate localDate2  = LocalDate.of(2019, Month.FEBRUARY, 29);
        System.out.println(localDate2);

        LocalDate localDate3  = LocalDate.of(2019, Month.FEBRUARY, 30);
        System.out.println(localDate3);

        LocalDate localDate4  = LocalDate.of(2019, Month.APRIL, 31);
        System.out.println(localDate4);
      //s  java.time.LocalDate.of()
    }
}
