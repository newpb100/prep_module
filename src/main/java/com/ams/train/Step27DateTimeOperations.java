package com.ams.train;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Step27DateTimeOperations {

    public static void main(String[] args) {

        // Получение текущей даты времени
        // https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java
        // 1.
        System.out.println("Варианты получения текущих даты и времени");
        System.out.println(System.currentTimeMillis());
        // System.currentTimeMillis() задает "системное" время. Хотя обычно системные часы устанавливаются на (номинальный) UTC,
        // будет разница (дельта) между локальными часами UTC и истинным UTC. Размер дельты зависит от того, насколько хорошо (и как часто) системные часы синхронизированы с UTC.

        // 2.
        Date dt1 = new Date();
        System.out.println("new Date()                             = " + dt1);
        // 3.
        Calendar cl = Calendar.getInstance();
        System.out.println("Calendar.getInstance()                 = " + cl.getTime());
        // 4.
        System.out.println("joda.time.DateTime                     = " + new org.joda.time.DateTime());
        // 5.
        System.out.println("LocalDateTime.now()                    = " + LocalDateTime.now());
        // Обратите внимание, что LocalDateTime не включает в выводе часовой пояс.
        // Как сказано в javadoc: "Он не может представлять момент в строке времени без дополнительной информации, такой как смещение или часовой пояс".
        // Однако, при запросе времени можно указать явно таймзону, для которой мы запрашиваем время
        ZoneId z = ZoneId.of("America/Montreal");
        System.out.println("LocalDateTime.now(America/Montreal)    = " + LocalDateTime.now(z));

        // Если надо выставить конкретное время, то делается через перегруженный метод of()
        System.out.println("LocalDateTime.of(2009-10-1T23:11)      = " + LocalDateTime.of(2009,10,1,23,11));

        // Чтобы получить текущий момент в UTC с разрешением в наносекундах, используйте Instant class.
        // .. что такое "с разрешением в наносекундах" ?
        Instant ins = Instant.now();
        System.out.println("Instant.now()          = " + ins);
        System.out.println("ins.getNano()          = " + ins.getNano());

        // 6.
        // Еще один интересный метод
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println("ZonedDateTime.now = " + zdt);



        // Прибавить вычесть количество дней от текущей даты и вывести дату с форматированием
        // https://stackoverflow.com/questions/11882926/how-to-subtract-x-day-from-a-date-object-in-java

        // 1. Через Calendar - Date - SimpleDateFormat
        Calendar calCurPlusMonth = Calendar.getInstance();
        calCurPlusMonth.setTime(new Date());
        calCurPlusMonth.add(Calendar.DATE, 30);

        System.out.println();
        System.out.println(new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").format(calCurPlusMonth.getTime()));

        // 2. Через LocalDateTime - Date - SimpleDateFormat
        LocalDateTime ldt = LocalDateTime.now().minusDays(300);
        Date outdate = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").format(outdate.getTime()));

        // 3. Через LocalDateTime - DateTimeFormatter
        System.out.println("3 - LocalDateTime - DateTimeFormatter");
        LocalDateTime ldt2 = LocalDateTime.now().minusDays(300);
        System.out.println(ldt2.format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")));

        System.out.println("3 - LocalDateTime - DateTimeFormatter - Europe/Paris");
        LocalDateTime ldt3 = LocalDateTime.now(ZoneId.of("Europe/Paris")).minusDays(300);
        System.out.println(ldt3.format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")));



        // Проверяем, calendarDate.setTimeInMillis и curDate.getTime() используют время в мс от 1970-01-01 ?
        Calendar calendarDate = new GregorianCalendar();
        Date curDate = new Date();

        calendarDate.setTimeInMillis(curDate.getTime());

        System.out.println("");
        System.out.println(curDate);                    // Wed Oct 02 23:08:51 MSK 2024
        System.out.println(calendarDate.getTime());     // Wed Oct 02 23:08:51 MSK 2024

        System.out.println(curDate.getTime());                      // 1727899731576
        System.out.println(calendarDate.getTimeInMillis());         // 1727899731576

        System.out.println(calendarDate.equals(curDate));           // false - несмотря на то, что в мс они совпадают
                                                                    // вероятно, из-за сравнения Calendar и Date
        Calendar calendar_curDate = new GregorianCalendar();
        calendar_curDate.setTimeInMillis(curDate.getTime());

        System.out.println(calendarDate.equals(calendar_curDate));   // true


        // Часовые пояса
        calendarDate = new GregorianCalendar();
        ZoneId zoneId = ZoneId.systemDefault();
        ZoneId zoneIdTimeZoned = ZoneId.of("Europe/Amsterdam");

        LocalDateTime datetime = Instant.ofEpochMilli(calendarDate.getTimeInMillis()).atZone(zoneId).toLocalDateTime();
        LocalDateTime datetimeTimeZoned = Instant.ofEpochMilli(calendarDate.getTimeInMillis()).atZone(zoneIdTimeZoned).toLocalDateTime();

        System.out.println();
        System.out.println(datetime);
        System.out.println(datetimeTimeZoned);

    }
}
