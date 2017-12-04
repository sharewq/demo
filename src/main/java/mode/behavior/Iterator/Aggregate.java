package mode.behavior.Iterator;

/**
 * Created by Think on 2017/11/28.
 */
public interface Aggregate {
    public void add(Object obj);

    public void remove(Object obj);

    public Iterator iterator();
}
