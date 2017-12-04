package mode.behavior.Template;

/**
 * Created by Think on 2017/11/24.
 */
public abstract class AbstractPerson {
    public void prepareGotoSchool() {
        dressUp();
        eatBreakfast();
        takeThings();
    }

    protected abstract void dressUp();

    protected abstract void eatBreakfast();

    protected abstract void takeThings();

}
