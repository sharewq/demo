package mode.create.Factory;

/**
 * 简单工厂模式+工厂方法模式
 * Created by Think on 2017/11/20.
 */
public class Customer {
    public static void main(String[] args) {
        Factory factory = new Factory();
        BMW bmw320 = factory.createBMW(320);
        BMW bmw523 = factory.createBMW(523);
    }
}
