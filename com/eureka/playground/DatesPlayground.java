package com.eureka.playground;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DatesPlayground {
    public static void main(String[] args) throws ParseException {
        //Old way to deal with Dates in Java
        Date date = new Date();
        System.out.println("date obj default is: " + date);
        System.out.println("Present time from date obj: " + date.getTime());

        //Instant will deal with UTC Dates
        Instant now = Instant.now();
        System.out.println("Instant value now: " + now);
        Instant instant = now.minusSeconds(600);
        System.out.println("Instant minus 10 mins: " + instant);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Singapore")));
        Date dateobject = simpleDateFormat.parse("2024-01-29 02:00:00");
        System.out.println("Date parsed using simple date format: " + dateobject);
        System.out.println("The month in date obj is: " + dateobject.getMonth());

        //New way to deal with Dates in Java
        LocalDate localDate = LocalDate.now();
        System.out.println("The Present Date: " + localDate);
        System.out.println("Present date reduced by 10 days: " + localDate.minusDays(10));
        System.out.println("Present date reduced by 5 months: " + localDate.minusMonths(5));
        System.out.println("Present date added by 2 days: " + localDate.plusDays(2));

        //New way to deal with TimeStamp in Java
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Present date and time: " + localDateTime);
        System.out.println("Added 120 mins to present time: " + localDateTime.plusMinutes(120));
        System.out.println(localDateTime.minusHours(2));

        LocalDate parsedDate = LocalDate.parse("2024-02-03", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("This date: " + parsedDate);
        System.out.println("Adding 30 days to this: " + parsedDate.plusDays(30));

    }
}
