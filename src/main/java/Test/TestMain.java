package Test;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Think on 2017/10/30.
 */
public class TestMain {
    public static void main(String[] args) {
        //func1();
        String str = format(new Date(), "yyyy-MM-dd hh:mm:ss");

        /*toDate("20171117");
        "".equals("b");
        Integer a = 1;
        "1".equals(a);*/

        //func2();
//        func3();
        func4();
        System.out.println("dec");
    }

    public static void func4() {
        String str = "1";
        if ("1".equals(str)) {
            System.out.println("11");
        }
    }

    public static void func3() {
        User a = new User("张三");
        User b = new User("张三");

        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }


    public static void func2() {
        for (int i = 0; i <= 0; i++) {
            for (int j = 0; j <= 0; j++) {
                for (int k = 0; k <= 3; k++) {
                    System.out.println("i= " + i + " j= " + j + " k= " + k);
                }
            }
        }
    }


    public static void func1() {
        int x = 4;
        System.out.println((x > 4) ? 99.0 : 9);//-> 9.0
        /**
         * 看到99.0了没有，结果需要和这个类型一致。
         * 这个是scjp题目啊
         */
    }

    public static String format(Date date, String pattern) {
        return date == null ? "" : (new DateTime(date)).toString(pattern);
    }

    public static Date toDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyyMMdd");
        try {
            Date date1 = sdf.parse(" 20080710");
            return date1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
