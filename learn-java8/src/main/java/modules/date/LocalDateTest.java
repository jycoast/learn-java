package modules.date;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/3/11 9:55
 * 4
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        System.out.println(year);
        System.out.println(month);
        System.out.println(day);

        LocalDate localDate1 = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(localDate1);

        System.out.println("----------------------------------");
        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println("----------------------------------");
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = LocalDateTime.now().plusDays(1);

        Duration duration = Duration.between(from,to);

        long days = duration.toDays();
        long hours = duration.toHours();
        System.out.println(days);
        System.out.println(hours);

        System.out.println("-------------------------------");
        Period period1 = Period.between(LocalDate.now(), LocalDate.now().plusYears(1));
        System.out.println(period1.getDays());
    }
}
