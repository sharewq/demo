package mode.create.AbsFactory;

/**
 * 创建工厂的接口
 * Created by Think on 2017/11/20.
 */
public interface AbstractFactory {
    //制造发动机
    public Engine createEngine();
    //制造空调
    public Aircondition createAircondition();
}
