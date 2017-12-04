package mode.struct.Combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 分店
 * Created by Think on 2017/11/23.
 */
public class MarketBranch extends Market {
    // 加盟店列表
    List<Market> list = new ArrayList<Market>();

    public MarketBranch(String name) {
        this.name = name;
    }

    @Override
    public void add(Market market) {
        list.add(market);
    }

    @Override
    public void remove(Market market) {
        list.remove(market);
    }

    @Override
    public void PayByCard() {
        System.out.println("name : " + name + "消费,积分已累加入该会员卡");
        for (Market m : list) {
            m.PayByCard();
        }
    }

}
