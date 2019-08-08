package com.rice.util;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author weigang.lu
 * @project maoyan-show-settlement
 * @package com.maoyan.show.settlement.utils
 * @date 17/8/23
 */
public class DateTimeUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_MILL_FORMAT = "yyyyMMddHHmmssSSS";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static Date parse(String date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static DateTime withYearMonthDay(Date day) {
        DateTime dateTime = new DateTime(day);
        return new DateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), 0, 0);
    }

    public static DateTime withYearMonthDay(DateTime dateTime) {
        return new DateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), 0, 0);
    }

    public static Date getFirstDayOfCurrentMonth() {
        DateTime dateNow = new DateTime();
        int year = dateNow.getYear();
        int month = dateNow.getMonthOfYear();
        return new DateTime(year, month, 1, 0, 0).toDate();
    }

    public static Date getSixteenDayOfCurrentMonth() {
        DateTime dateNow = new DateTime();
        int year = dateNow.getYear();
        int month = dateNow.getMonthOfYear();
        return new DateTime(year, month, 16, 0, 0).toDate();
    }

    public static Date getSixteenDayOfPreMonth() {
        DateTime dateNow = new DateTime();
        int year = dateNow.getYear();
        int month = dateNow.getMonthOfYear();
        return new DateTime(year, month, 16, 0, 0).minusMonths(1).toDate();
    }

    public static DateTime withYearMonthDayHour(DateTime dateTime) {
        int year = dateTime.getYear();
        int month = dateTime.getMonthOfYear();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHourOfDay();
        return new DateTime(year, month, day, hour, 0);
    }

}
