package mode.behavior.Bridge;

/**
 * 裤子
 * Created by Think on 2017/11/28.
 */
public class Trouser extends Clothing {
    @Override
    public void personDressCloth(Person person) {
        System.out.println(person.getType() + "穿裤子");
    }
}
