package DateTimeExcerise;

import java.time.LocalDate;

public class DateExercise {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate yesterday = localDate.minusDays(1);
        LocalDate tomorrow  = localDate.plusDays(1);
        System.out.println("Current Date   "+ localDate);
        System.out.println("Previous Date  "+ yesterday);
        System.out.println("Coming Date    "+ tomorrow);
    }

}
