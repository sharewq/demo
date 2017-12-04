package mode.create.Builder;

/**
 * 建造者模式：
 * 将一个复杂的对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 *  实用范围
 *  1、当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时。
 *  2、当构造过程必须允许被构造的对象有不同表示时。
 *
 * Created by Think on 2017/11/22.
 */
public class Test {
    public static void main(String[] args) {
        PersonDirector pd = new PersonDirector();

        Person woman = pd.constructPerson(new WomanBuilder());
        Person man = pd.constructPerson(new ManBuilder());

        System.out.println(woman.getHead() + woman.getBody() + woman.getFoot());
        System.out.println(man.getHead() + man.getBody() + man.getFoot());
    }
}
