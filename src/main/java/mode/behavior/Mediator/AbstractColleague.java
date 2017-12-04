package mode.behavior.Mediator;

/**
 * Created by Think on 2017/11/28.
 */
public abstract class AbstractColleague {
    protected int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public abstract void setNumber(int number,AbstractMediator am);
}
