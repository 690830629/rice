package com.rice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
   static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");

   public static Date parse(String date) throws ParseException {
       if(Validation.isEmpty(date)){
           return null;
       }
       return sdf.parse(date);
   }

    public static String format(Date date){
       if(Validation.isEmpty(date)){
           return null;
       }
       return sdf.format(date);
    }
    /**
     * 日期转时间戳
     * @param date
     * @return
     */
    public static Integer transForMilliSecond(Date date){
        if(date==null) return null;
        return (int)(date.getTime()/1000);
    }
    /**
     * 获取当前时间戳
     * @return
     */
    public static Integer currentTimeStamp(){
        return (int)(System.currentTimeMillis()/1000);
    }
    /**
     * 日期字符串转时间戳
     * @param dateStr
     * @return
     */
    public static Integer transForMilliSecond(String dateStr) throws ParseException {
        Date date = DateUtil.parse(dateStr);
        return date == null ? null : DateUtil.transForMilliSecond(date);
    }

    /**
     * 时间戳转日期
     * @param ms 毫秒
     * @return
     */
    public static Date transForDate(Long ms){
        if(ms==null){
            ms=(long)0;
        }
        long msl=(long)ms*1000;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date temp=null;
        if(ms!=null){
            try {
                String str=sdf.format(msl);
                temp=sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }
    /**
     * 时间戳转日期
     * @param s 秒
     * @return
     */
    public static Date transForDatejjj(Long s){
        if(s==null){
            s=(long)0;
        }
       return new Date(s.longValue());
    }

    public static void main(String[] args) {
        System.out.println(currentTimeStamp());

        Date str = DateUtil.transForDate(1529489880L);
        Date strq = DateUtil.transForDatejjj(1529489880000L);

        System.out.println(strq);
    }
}
