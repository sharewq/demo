package mode.behavior.Status;

/**
 * Created by Think on 2017/11/28.
 */
public class Control {

    private State state;

    public void setState(State s){
        this.state=s;
        state.handle();
    }
}
