package mode.create.Prototype;

/**
 * 深拷贝与浅拷贝。
 * Object类的clone方法只会拷贝对象中的基本的数据类型
 * （8种基本数据类型byte,char,short,int,long,float,double，boolean），对于数组、容器对象、引用对象等都不会拷贝，这就是浅拷贝。
 * 如果要实现深拷贝，必须将原型模式中的数组、容器对象、引用对象等另行拷贝
 * Created by Think on 2017/11/22.
 */
public class Client {
    public static void main(String[] args) {
        ConcretePrototype cp = new ConcretePrototype();
        System.out.println("start : " + System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            ConcretePrototype cloneCp = (ConcretePrototype) cp.clone();
            cloneCp.show();
            System.out.println(cloneCp);
        }
        System.out.println("end : " + System.currentTimeMillis());
    }
}
