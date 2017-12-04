package mode.create.AbsFactory;

/**
 * Created by Think on 2017/11/20.
 */
public class FactoryBMW320 implements AbstractFactory {
    @Override
    public Engine createEngine() {
        return new EngineA();
    }

    @Override
    public Aircondition createAircondition() {
        return new AirconditionA();
    }
}
