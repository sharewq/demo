package mode.struct.Combination;

/**
 * Created by Think on 2017/11/23.
 */
public abstract class Market {
    public String name;

    public abstract void add(Market market);

    public abstract void remove(Market market);

    public abstract void PayByCard();
}
