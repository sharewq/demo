package mode.behavior.Order;

/**
 * 测试类--命令模式
 * 总结
 * 1.命令模式的本质是对命令进行封装，将发出命令的责任和执行命令的责任分割开。
 * 2.每一个命令都是一个操作：请求的一方发出请求，要求执行一个操作；接收的一方收到请求，并执行操作。
 * 3.命令模式允许请求的一方和接收的一方独立开来，使得请求的一方不必知道接收请求的一方的接口，更不必知道请求是怎么被接收，以及操作是否被执行、何时被执行，以及是怎么被执行的。
 * 4.命令模式使请求本身成为一个对象，这个对象和其他对象一样可以被存储和传递。
 * 5.命令模式的关键在于引入了抽象命令接口，且发送者针对抽象命令接口编程，只有实现了抽象命令接口的具体命令才能与接收者相关联。
 * <p>
 * Created by Think on 2017/11/28.
 */
public class ClientTest {
    public static void main(String[] args) {
        //命令接收者Receiver
        Tv tv = new Tv();
        //开机
        CommandOn commandOn = new CommandOn(tv);

        //关机
        CommandOff commandOff = new CommandOff(tv);

        //换频道
        CommandChange commandChange = new CommandChange(tv, 2);

        //控制器
        Control control = new Control(commandOn, commandOff, commandChange);
        control.turnOn();
        control.turnOff();
        control.changeChannel();
    }
}
