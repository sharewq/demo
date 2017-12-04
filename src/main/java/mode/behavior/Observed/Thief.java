package mode.behavior.Observed;

/**
 * 警察
 * Created by Think on 2017/11/24.
 */
public class Thief implements Watcher{
    @Override
    public void update() {
        System.out.println("运输车有行动，强盗准备动手");
    }
}
