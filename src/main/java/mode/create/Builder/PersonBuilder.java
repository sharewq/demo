package mode.create.Builder;

/**
 * 根据对象的不同构建不同身体
 * Created by Think on 2017/11/20.
 */
public interface PersonBuilder {

    void buildHead();

    void buildBody();

    void buildFoot();

    Person buildPerson();
}
