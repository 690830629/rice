package com.rice.util;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public static DateTime withYearMonthDay(DateTime dateTime) {
        int year = dateTime.getYear();
        int month = dateTime.getMonthOfYear();
        int day = dateTime.getDayOfMonth();
        return new DateTime(year, month, day, 0,0);
    }
    public static boolean IsZero(String str){
        if(!str.contains(".")){
            return true;
        }

        String ttt = str.split(".")[0];
        if(ttt.charAt(1)=='0'){
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws ParseException {
        List<String> list= Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("13");
        String result=Joiner.on(";").join(list);
        System.out.println(result);
    }
}
