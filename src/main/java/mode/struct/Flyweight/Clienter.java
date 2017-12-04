package mode.struct.Flyweight;

/**
 * Created by Think on 2017/11/23.
 */
public class Clienter {
    public static void main(String[] args) {
        String yudong = "足球";
        for (int i = 0; i < 10; i++) {
            TiYuGuan tyg = new JianZhuFactory().getTyg(yudong);
            tyg.setName("中国体育馆");
            tyg.setShape("圆形");
            tyg.use();
            System.out.println("对象池中对象数量为：" + JianZhuFactory.getSize());
        }
    }
}
