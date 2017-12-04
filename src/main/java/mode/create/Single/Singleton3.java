package mode.create.Single;

/**
 * 静态内部类
 * 既实现了线程安全，又避免了同步带来的性能影响
 * Created by Think on 2017/11/20.
 */
public class Singleton3 {

    public String username;
    public String password;


    private Singleton3() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void pritInfo() {
        System.out.println("username : " + username + " password :" + password);
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static final Singleton3 getSingleton() {
        return SingletonHolder.INSTANCE;
    }


}
