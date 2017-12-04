package mode.struct.Adapter;

/**
 * 适配器类，继承了被适配类，同时实现标准接口
 * 通过适配器，实现调同一个方法，实现不同的实现
 * Created by Think on 2017/11/23.
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        super.specificRequest();
    }
}
