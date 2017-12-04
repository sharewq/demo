package mode.behavior.Strategy;

/**
 * 策略模式
 * 优点
 * 1、可以动态的改变对象的行为
 * 缺点
 * 1、客户端必须知道所有的策略类，并自行决定使用哪一个策略类
 * 2、策略模式将造成产生很多策略类
 * Created by Think on 2017/11/23.
 */
public class Test {
    public static void main(String[] args) {
        Context context;
        System.out.println("----------刚到吴国使用第一个锦囊---------------");
        context = new Context(new BackDoor());
        context.operate();
        System.out.println("\n");

        System.out.println("----------刘备乐不思蜀使用第二个锦囊---------------");
        context.setStrategy(new GivenGreenLight());
        context.operate();
        System.out.println("\n");

        System.out.println("----------孙权的追兵来了，使用第三个锦囊---------------");
        context.setStrategy(new BlackEnemy());
        context.operate();
        System.out.println("\n");
    }
}
