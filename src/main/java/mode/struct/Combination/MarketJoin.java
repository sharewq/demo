package mode.struct.Combination;

/**
 * Created by Think on 2017/11/23.
 */
public class MarketJoin extends Market {

    public MarketJoin(String name) {
        this.name = name;
    }

    @Override
    public void add(Market market) {

    }

    @Override
    public void remove(Market market) {

    }

    @Override
    public void PayByCard() {
        System.out.println("name : " + name + "消费,积分已累加入该会员卡");
    }
}
