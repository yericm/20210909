package com.example.juc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yeric
 * @description: 玩 ThreadLocal 的，没什么作用
 * @date 2021/10/12 21:08
 */
public class DateUtils {
    static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String nowDateStr = "2021-10-12 21:20:53";
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                try {
//                    DateUtils2.parseDate1(nowDateStr);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    DateUtils.parseDate2(nowDateStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }finally {
                // todo 怎么remove?
                }
            }).start();
        }
    }

    /**
     * 有问题的方式，除非方法加 synchronized
     * @param dateStr
     * @throws ParseException
     */
    public static void parseDate1(String dateStr) throws ParseException {
        Date date = sdf.parse(dateStr);
        System.out.println(date);
    }

    public static void parseDate2(String dateStr) throws ParseException {
        SimpleDateFormat sdf = threadLocal.get();
        Date date = sdf.parse(dateStr);
        System.out.println(date);
    }
}
