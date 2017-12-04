package mode.behavior.Mediator;

/**
 * Created by Think on 2017/11/28.
 */
public class ColleagueB extends AbstractColleague {
    @Override
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.AaffectB();
    }
}
