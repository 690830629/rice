package com.rice.util;

import org.joda.time.DateTime;

import java.util.Date;

public class DateJoda {

    public static Date getFirstDayOfCurrentMonth() {
        DateTime dateNow = new DateTime();
        int year = dateNow.getYear();
        int month = dateNow.getMonthOfYear();
        return new DateTime(year, month, 1, 0, 0).toDate();
    }

    public static Date getSixteenDayOfPreMonth() {
        DateTime dateNow = new DateTime();
        int year = dateNow.getYear();
        int month = dateNow.getMonthOfYear();
        return new DateTime(year, month, 16, 0, 0).minusMonths(1).toDate();
    }
    public static Date getSixteenDayOfCurrentMonth() {
        DateTime dateNow = new DateTime();
        int year = dateNow.getYear();
        int month = dateNow.getMonthOfYear();
        return new DateTime(year, month, 16, 0, 0).toDate();
    }
    public static Date naturalBillBeginTime(int firstDay) {
        int dayOfMonth = DateTime.now().getDayOfMonth();
        Date date;
        if (dayOfMonth <= firstDay) {
            date = getSixteenDayOfPreMonth();
        } else {
            date = getFirstDayOfCurrentMonth();
        }
        return date;
    }

    public static  Date naturalBillEndTime(int firstDay) {
        int dayOfMonth = DateTime.now().getDayOfMonth();
        Date date;
        if (dayOfMonth <= firstDay) {
            date = getFirstDayOfCurrentMonth();
        } else {
            date = getSixteenDayOfCurrentMonth();
        }
        return withYearMonthDayHour(new DateTime(date)).minusSeconds(1).toDate();
    }
    public static DateTime withYearMonthDayHour(DateTime dateTime) {
        int year = dateTime.getYear();
        int month = dateTime.getMonthOfYear();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHourOfDay();
        return new DateTime(year, month, day, hour, 0);
    }


    public static void main(String[] args) {
        System.out.println(getFirstDayOfCurrentMonth());
        System.out.println( new DateTime(getFirstDayOfCurrentMonth()).minusSeconds(1).toDate());

    }
}
