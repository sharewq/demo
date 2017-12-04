package mode.create.AbsFactory;

/**
 * 宝马523系列
 * Created by Think on 2017/11/20.
 */
public class FactoryBMW523 implements AbstractFactory {
    @Override
    public Engine createEngine() {
        return new EngineB();
    }

    @Override
    public Aircondition createAircondition() {
        return new AirconditionB();
    }
}
