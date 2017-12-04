package mode.create.Single;

/**
 * 饿汉式单例
 *  饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，
 *  以后不再改变，所以天生是线程安全的
 * Created by Think on 2017/11/20.
 */
public class Singleton2 {
    private static final Singleton2 single = new Singleton2();

    private Singleton2() {
    }

    /**
     * 静态工厂方法
     *
     * @return
     */
    public static Singleton2 getInstance() {
        return single;
    }
}
