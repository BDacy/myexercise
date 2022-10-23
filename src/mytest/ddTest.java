package mytest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ddTest {
    //日期与时间
    @Test
    public void demo01() throws ParseException {
        Date date=new Date();
        System.out.println(date);
        //指的是从1970年1月1日    00:00:00走到此刻的总的毫秒数，应该是很大的
        long time = date.getTime();
        System.out.println(time);
        //日期转换
        //y年 M月 d日 H时 m分 s秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 - HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
        System.out.println(sdf.format(time));
        Date parse = sdf.parse("2022年10月1日 - 12:00:11");
        System.out.println(parse);
        //日期
        System.out.println();
        Calendar cal=Calendar.getInstance();
        System.out.println(cal.getTime());
        System.out.println(cal.get(1));
        System.out.println(cal.get(2));
        System.out.println(cal.get(3));
    }
}
