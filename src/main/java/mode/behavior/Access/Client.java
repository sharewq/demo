package mode.behavior.Access;

import java.util.List;

/**
 * 访问者模式
 * 符合单一职责原则：凡是适用访问者模式的场景中，元素类中需要封装在访问者中的操作必定是与元素类本身关系不大且是易变的操作
 * ，使用访问者模式一方面符合单一职责原则，另一方面，因为被封装的操作通常来说都是易变的，
 * 所以当发生变化时，就可以在不改变元素类本身的前提下，实现对变化部分的扩展。
 * 扩展性良好：元素类可以通过接受不同的访问者来实现对不同操作的扩展。
 * 缺陷：
 * 增加新的元素类比较困难。
 * Created by Think on 2017/11/28.
 */
public class Client {
    public static void main(String[] args) {
        List<Element> list = ObjectStruture.getList();
        for (Element e : list) {
            e.accept(new Visitor());
            e.doSomething();
        }
    }
}
