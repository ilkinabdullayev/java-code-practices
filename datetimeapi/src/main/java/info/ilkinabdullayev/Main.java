package info.ilkinabdullayev;

import info.ilkinabdullayev.time.LocalDate;
import info.ilkinabdullayev.time.Month;

public class Main {

    public static void main(String[] args) {
        LocalDate localDate  = LocalDate.of(2019, 03, 27);
        System.out.println(localDate);

        LocalDate localDate2  = LocalDate.of(2019, Month.MARCH, 27);

       // java.time.LocalDate.of()
    }
}
