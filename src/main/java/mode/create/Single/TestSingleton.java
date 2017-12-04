package mode.create.Single;

/**
 * Created by Think on 2017/11/20.
 */
public class TestSingleton {
    public static void main(String[] args) {
        Singleton3 sing1 = Singleton3.getSingleton();
        sing1.setUsername("张三");
        sing1.setPassword("123456");
        Singleton3 sing2 = Singleton3.getSingleton();
        sing2.setPassword("654321");
        sing1.pritInfo();
        sing2.pritInfo();
        System.out.println(sing1.equals(sing2));
    }
}
