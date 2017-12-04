package mode.behavior.Bridge;

/**
 * 马甲
 * Created by Think on 2017/11/28.
 */
public class Jacket extends Clothing {
    @Override
    public void personDressCloth(Person person) {
        System.out.println(person.getType() + "穿马甲");
    }
}
