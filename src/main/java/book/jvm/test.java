package book.jvm;

/**
 * Created by Think on 2017/10/31.
 */
public class test {
    public static void main(String[] args) {
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);



    }
}
