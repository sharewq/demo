package mode.behavior.Observed;

/**
 * 观察者模式
 * 适用场景
 * 1) 当一个抽象模型有两个方面, 其中一个方面依赖于另一方面。将这二者封装在独立的对象中以使它们可以各自独立地改变和复用。
 * 2) 当对一个对象的改变需要同时改变其它对象, 而不知道具体有多少对象有待改变。
 * 3) 当一个对象必须通知其它对象，而它又不能假定其它对象是谁。换言之, 你不希望这些对象是紧密耦合的。
 * <p>
 * 应用
 * 珠宝商运送一批钻石，有黄金强盗准备抢劫，珠宝商雇佣了私人保镖，警察局也派人护送，于是当运输车上路的时候，强盗保镖警察都要观察运输车一举一动，
 * 抽象的观察者
 * Created by Think on 2017/11/24.
 */
public class Test {
    public static void main(String[] args) {
        Observed observed = new Observed();

        Security security = new Security();
        Police police = new Police();
        Thief thief = new Thief();

        observed.addWatcher(security);
        observed.addWatcher(police);
        observed.addWatcher(thief);

        observed.notifyWachers();
    }
}
