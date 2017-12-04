package mode.struct.Adapter;

/**
 * 测试类-适配器模型
 *     5.1 优点
 * 　　　　5.1.1 通过适配器，客户端可以调用同一接口，因而对客户端来说是透明的。这样做更简单、更直接、更紧凑。
 * 　　　　5.1.2 复用了现存的类，解决了现存类和复用环境要求不一致的问题。
 * 　　　　5.1.3 将目标类和适配者类解耦，通过引入一个适配器类重用现有的适配者类，而无需修改原有代码。
 * 　　　　5.1.4 一个对象适配器可以把多个不同的适配者类适配到同一个目标，也就是说，同一个适配器可以把适配者类和它的子类都适配到目标接口。
 * 　　5.2 缺点
 * 　　　　对于对象适配器来说，更换适配器的实现过程比较复杂。
 * Created by Think on 2017/11/23.
 */
public class ClientTest {
    public static void main(String[] args) {
        // 使用普通功能类
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.request();

        // 使用特殊功能类，即适配类
        Target adapter = new Adapter();
        adapter.request();
    }
}
