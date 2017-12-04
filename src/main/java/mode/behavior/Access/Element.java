package mode.behavior.Access;

/**
 * Created by Think on 2017/11/28.
 */
public abstract class Element {

    public abstract void accept(IVisitor visitor);

    public abstract void doSomething();
}
