package mode.behavior.Iterator;

/**
 * 迭代器模式
 * <p>
 * 迭代器模式的优点有：
 * 简化了遍历方式，对于对象集合的遍历，还是比较麻烦的，对于数组或者有序列表，我们尚可以通过游标来取得，
 * 但用户需要在对集合了解很清楚的前提下，自行遍历对象，但是对于hash表来说，用户遍历起来就比较麻烦了。
 * 而引入了迭代器方法后，用户用起来就简单的多了。
 * 可以提供多种遍历方式，比如说对有序列表，我们可以根据需要提供正序遍历，倒序遍历两种迭代器，
 * 用户用起来只需要得到我们实现好的迭代器，就可以方便的对集合进行遍历了。
 * 封装性良好，用户只需要得到迭代器就可以遍历，而对于遍历算法则不用去关心。
 * <p>
 * 迭代器模式的缺点：
 * 对于比较简单的遍历（像数组或者有序列表），使用迭代器方式遍历较为繁琐，大家可能都有感觉，像ArrayList，
 * 我们宁可愿意使用for循环和get方法来遍历集合。
 * 迭代器模式的适用场景
 * 迭代器模式是与集合共生共死的，一般来说，我们只要实现一个集合，就需要同时提供这个集合的迭代器，就像java中的Collection，List、Set、Map等，
 * 这些集合都有自己的迭代器。假如我们要实现一个这样的新的容器，当然也需要引入迭代器模式，给我们的容器实现一个迭代器。
 * Created by Think on 2017/11/28.
 */
public class ClientTest {
    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add("小明");
        ag.add("小红");
        ag.add("小刚");
        Iterator it = ag.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            System.out.println(str);
        }
    }
}
