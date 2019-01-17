package com.rice.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.extern.log4j.Log4j;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Log4j
public class DateUtil {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parse(String date) throws ParseException {
        if (Validation.isEmpty(date)) {
            return null;
        }
        return sdf.parse(date);
    }

    public static String format(Date date) {
        if (Validation.isEmpty(date)) {
            return null;
        }
        return sdf.format(date);
    }

    /**
     * 日期转时间戳
     *
     * @param date
     * @return
     */
    public static Integer transForMilliSecond(Date date) {
        if (date == null) return null;
        return (int) (date.getTime() / 1000);
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static Integer currentTimeStamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /**
     * 日期字符串转时间戳
     *
     * @param dateStr
     * @return
     */
    public static Integer transForMilliSecond(String dateStr) throws ParseException {
        Date date = DateUtil.parse(dateStr);
        return date == null ? null : DateUtil.transForMilliSecond(date);
    }

    /**
     * 时间戳转日期
     *
     * @param ms 毫秒
     * @return
     */
    public static Date transForDate(Long ms) {
        if (ms == null) {
            ms = (long) 0;
        }
        long msl = (long) ms * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date temp = null;
        if (ms != null) {
            try {
                String str = sdf.format(msl);
                temp = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }

    /**
     * 时间戳转日期
     *
     * @param s 秒
     * @return
     */
    public static Date transForDatejjj(Long s) {
        if (s == null) {
            s = (long) 0;
        }
        return new Date(s.longValue());
    }

    public static DateTime withYearMonthDay(Date day) {
        DateTime dateTime = new DateTime(day);
        return new DateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), 0, 0);
    }

    public static List<Integer> a() {
        int index = 0;
        List<Integer> idList = Lists.newArrayList();
        idList.add(++index);
        idList.add(++index);
        return  idList;
    }

    public static void main(String[] args) {
        Set<String> billIds = Sets.newHashSet();
        String s = "1,2";
        String[] t = s.split(",");
        System.out.println(t);
        for (int i = 0; i < t.length; i++) {
            billIds.add(t[i]);
        }
        System.out.println(billIds.contains("3"));
    }

}
