package mode.behavior.Observed;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的被观察者
 * Created by Think on 2017/11/24.
 */
public class Observed implements Watched {

    private List<Watcher> list = new ArrayList<>();

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWacher(Watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWachers() {
        for (Watcher watcher : list) {
            watcher.update();
        }
    }
}
