package mode.behavior.Status;


/**
 * 状态对象模式
 * 所谓对象的状态，通常指的就是对象实例的属性的值；
 * 而行为指的就是对象的功能，再具体点说，行为大多可以对应到方法上。
 * 状态模式的功能就是分离状态的行为，通过维护状态的变化，来调用不同状态对应的不同功能。
 * 也就是说，状态和行为是相关联的，它们的关系可以描述为：状态决定行为 。
 * Created by Think on 2017/11/28.
 */
public class ClientTest {
    public static void main(String[] args) {
        Control control = new Control();
        control.setState(new FreeState());
        control.setState(new OrderedState());
        control.setState(new LivedState());
    }
}
