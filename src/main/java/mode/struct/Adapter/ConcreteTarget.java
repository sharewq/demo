package mode.struct.Adapter;

/**
 * 具体目标类，只提供普通功能
 * Created by Think on 2017/11/23.
 */
public class ConcreteTarget implements Target {

    @Override
    public void request() {
        System.out.println("普通类 具有 普通功能...");
    }
}
