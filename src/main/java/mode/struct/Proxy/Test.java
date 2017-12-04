package mode.struct.Proxy;

/**
 * 创建一个客户端，模拟一次买车
 * Created by Think on 2017/11/23.
 */
public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setCash(12000);
        BuyCarProxy buyCarProxy = new BuyCarProxy(customer);
        buyCarProxy.buyCar();
    }
}
