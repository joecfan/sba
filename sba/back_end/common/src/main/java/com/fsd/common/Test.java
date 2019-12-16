package com.fsd.common;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author: zhuhui bao
 * @date: 14:37 2019/12/10
 **/
public class Test {

    public static void main(String[] args) {
        String s = JSON.toJSONString(null);
        System.out.println(s);

        Date s1 = new Date();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date s2 = new Date();
        long d = DateUtil.betweenMs(s1,s2);

        System.out.println(d);
        System.out.println(s2.getTime()-s1.getTime());
        System.out.println(LocalDate.now());

        long l = 1000000;
        Integer i = 50000;

        System.out.println(l == i);

        LocalDateTime localDateTime1 = LocalDateTime.now();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime localDateTime2 = LocalDateTime.now();

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

        Duration duration = Duration.between(localDateTime1,localDateTime2);
        System.out.println(duration.toMillis());

        Duration duration2 = Duration.between(localDateTime2,localDateTime1);
        System.out.println(duration2.abs().toMillis());

        String info = format("该域名%s被访问了%s次.", "aaa" , "456");
        System.out.println(info);

    }

    private static String format(String message, String... ars) {
        String info = String.format(message, ars);
        return info;
    }
}
