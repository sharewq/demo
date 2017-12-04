package mode.behavior.Duty;

/**
 * 职责链模式
 * 使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系，
 * 将这个对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理他为止。
 *
 * Created by Think on 2017/11/24.
 */
public class Client {
    public static void main(String[] args) {
        //总经理
        Handler h1 = new GeneralManager();
        //部门经理
        Handler h2 = new DeptManager();
        //项目经理
        Handler h3 = new ProjectManager();

        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        //开始测试--项目经理
        String test1 = h3.handleRequest("张三", 300);
        System.out.println("test1 = " + test1);

        String test2 = h3.handleRequest("李四", 300);
        System.out.println("test2 = " + test2);
        System.out.println("---------------------------------------");

        String test3 = h3.handleRequest("张三", 700);
        System.out.println("test3 = " + test3);
        String test4 = h3.handleRequest("李四", 700);
        System.out.println("test4 = " + test4);
        System.out.println("---------------------------------------");

        String test5 = h3.handleRequest("张三", 1500);
        System.out.println("test5 = " + test5);
        String test6 = h3.handleRequest("李四", 1500);
        System.out.println("test6 = " + test6);
    }
}
