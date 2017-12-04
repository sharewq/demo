package mode.behavior.Observed;

/**
 * 被观察者
 * Created by Think on 2017/11/24.
 */
public interface Watched {
    /**
     * 添加观察者
     *
     * @param watcher
     */
    void addWatcher(Watcher watcher);

    /**
     * 移除观察者
     *
     * @param watcher
     */
    void removeWacher(Watcher watcher);

    /**
     * 通知观察者
     */
    void notifyWachers();
}
