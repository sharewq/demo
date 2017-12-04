package mode.behavior.Strategy;

/**
 * 孙夫人断后，挡住追兵
 * Created by Think on 2017/11/23.
 */
public class BlackEnemy implements Strategy {
    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}
