package mode.behavior.Template;

/**
 * Created by Think on 2017/11/24.
 */
public class Student extends AbstractPerson {

    @Override
    protected void dressUp() {
        System.out.println("传校服");
    }

    @Override
    protected void eatBreakfast() {
        System.out.println("吃妈妈做好的早饭");
    }

    @Override
    protected void takeThings() {
        System.out.println("背书包，带上家庭作业和红领巾");
    }
}
