package mode.behavior.Bridge;

/**
 * 定义Abstraction Person类
 * Created by Think on 2017/11/28.
 */
public abstract class Person {
    private Clothing clothing;  //衣服
    private String type;        //类型

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
