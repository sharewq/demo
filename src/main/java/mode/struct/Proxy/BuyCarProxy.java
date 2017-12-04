package mode.struct.Proxy;

/**
 * 声明一个买车代理汽车4S店，同样也实现买车接口，必须接受客户下单
 * Created by Think on 2017/11/23.
 */
public class BuyCarProxy implements IBuyCar {

    private Customer customer;

    public BuyCarProxy(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void buyCar() {
        int cash = customer.getCash();
        if (cash < 100000) {
            System.out.println(" 你的钱不够买一辆车");
            return;
        }
        customer.buyCar();
    }
}
