package mode.struct.Proxy;

/**
 * Created by Think on 2017/11/23.
 */
public class Customer implements IBuyCar {

    private int cash;  //买车钱

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public void buyCar() {
        System.out.println("买了花费的钱。 "+cash+" 元");
    }
}
