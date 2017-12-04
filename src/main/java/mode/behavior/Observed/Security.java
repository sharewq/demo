package mode.behavior.Observed;

/**
 * 具体的观察者
 * 保镖
 * Created by Think on 2017/11/24.
 */
public class Security implements Watcher {

    @Override
    public void update() {
        System.out.println("运输车有行动，保安贴身保护");
    }
}
