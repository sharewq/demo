package mode.behavior.Status;

/**
 * Created by Think on 2017/11/28.
 */
public class OrderedState implements State {
    @Override
    public void handle() {
        System.out.println("房间已被预订");
    }
}
