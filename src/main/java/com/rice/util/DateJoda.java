package com.rice.util;

import org.joda.time.DateTime;

import java.math.BigDecimal;
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


    public static void main(String[] args) {
//        BigDecimal amt = new BigDecimal(380.10);
//        BigDecimal[] results = amt.divideAndRemainder(BigDecimal.valueOf(3));
//        amt.setScale(4,BigDecimal.ROUND_HALF_UP);
//        System.out.println( IsZero(String.valueOf(amt)));

        BigDecimal aveSellPrice=new BigDecimal("126.6667");
        BigDecimal setnum=new BigDecimal(3);
        BigDecimal sellPrice=aveSellPrice.multiply(setnum);
        BigDecimal finalSellPrice=sellPrice;
        sellPrice = sellPrice.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(sellPrice);
        try {
            BigDecimal d = sellPrice.divide(aveSellPrice);
        } catch (ArithmeticException e) {
            String msg = e.getMessage();
            if (msg.indexOf("Non-terminating") > -1) {
                System.out.println("Non-terminating");//无穷


            }
        }
        sellPrice = finalSellPrice.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(sellPrice);

    }
}
