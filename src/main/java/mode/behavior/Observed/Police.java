package mode.behavior.Observed;

/**
 * 警察
 * Created by Think on 2017/11/24.
 */
public class Police implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，警察护航");
    }
}
