package mode.behavior.Access;

/**
 * Created by Think on 2017/11/28.
 */
public class ConcreteElement2 extends Element {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void doSomething() {
        System.out.println("这是元素2");
    }
}
