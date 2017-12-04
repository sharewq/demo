package mode.create.Builder;

/**
 * Created by Think on 2017/11/20.
 */
public class WomanBuilder implements PersonBuilder {
    Person person;

    public WomanBuilder() {
        person = new Woman();
    }

    @Override
    public void buildHead() {
        person.setHead("建造女人的头");
    }

    @Override
    public void buildBody() {
        person.setBody("建造女人的身体");

    }

    @Override
    public void buildFoot() {
        person.setFoot("建造女人的脚");
    }

    public Person buildPerson() {
        return person;
    }
}
