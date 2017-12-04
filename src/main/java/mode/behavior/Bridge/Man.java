package mode.behavior.Bridge;

/**
 * Created by Think on 2017/11/28.
 */
public class Man extends Person {
    public Man() {
        setType("男人");
    }

    public void dress() {
        Clothing clothing = getClothing();
        clothing.personDressCloth(this);
    }
}
