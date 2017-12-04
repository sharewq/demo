package mode.create.Prototype;

import java.util.ArrayList;

/**
 * 原型模式
 * 用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。
 * 需要重复地创建相似对象时可以考虑使用原型模式
 * Created by Think on 2017/11/22.
 */
public class Prototype1 implements Cloneable {
    //深拷贝例子
    private ArrayList list = new ArrayList();

    public Prototype1 clone() {
        Prototype1 prototype1 = null;
        try {
            prototype1 = (Prototype1) super.clone();

            //深拷贝例子
            list = (ArrayList) this.list.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype1;
    }


}
