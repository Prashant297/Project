package DateTimeExcerise;

import java.time.*;

public class TimeExercise {
    public static void main(String[] args) {
                LocalDateTime  ldt = LocalDateTime.now();
                ZoneId  india = ZoneId.of("Asia/Kolkata");
                ZonedDateTime zone1  = ZonedDateTime.of(ldt, india);
                System.out.println("In India Central Time Zone:\t " + zone1);
                ZoneId  cuba = ZoneId.of("Cuba");
                ZonedDateTime zone2   = zone1.withZoneSameInstant(cuba);
                System.out.println("In Cuba Central Time Zone:\t"  + zone2);
    }
}

