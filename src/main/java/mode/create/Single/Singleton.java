package mode.create.Single;

/**
 * 懒汉式单例类.在第一次调用的时候实例化自己
 * Created by Think on 2017/11/20.
 */
public class Singleton {
    private static Singleton single = null;

    private Singleton() {
    }

    /**
     *     静态工厂方法
     *          * @return

     */
    /*public static Singleton getInstance() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }*/

    /**
     * 双重检查锁定
     * @return
     */
    /*public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }*/

    /**
     * 添加同步锁，多线程下安全
     *
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }
}
