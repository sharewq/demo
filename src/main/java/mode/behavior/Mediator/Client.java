package mode.behavior.Mediator;

/**
 * 中介者(Mediator)模式
 * 1.中介者模式本质：
 * <p>
 * 解耦多个同事对象之间的交互关系。每个对象都持有中介者对象的引用，只跟中介者对象打交道。我们通过中介者对象统一管理这些交互关系。
 * 2.开发中常见场景：
 * <p>
 * MVC模式(其中的C，控制器就是一个中介者对象。M和V都和他打交道)。
 * 窗口游戏程序，窗口软件开发中窗口对象也是一个中介对象。
 * Created by Think on 2017/11/28.
 */
public class Client {
    public static void main(String[] args) {
        AbstractColleague collA = new ColleagueA();
        AbstractColleague collB = new ColleagueB();

        AbstractMediator am = new Mediator(collA, collB);
        System.out.println("==========通过设置A影响B==========");
        collA.setNumber(1000, am);
        System.out.println("collA的number值为：" + collA.getNumber());
        System.out.println("collB的number值为A的10倍：" + collB.getNumber());

        System.out.println("==========通过设置B影响A==========");
        collB.setNumber(1000, am);
        System.out.println("collB的number值为：" + collB.getNumber());
        System.out.println("collA的number值为B的0.1倍：" + collA.getNumber());
    }
}
