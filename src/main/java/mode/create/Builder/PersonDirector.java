package mode.create.Builder;

/**
 * 角色Directo
 * Created by Think on 2017/11/20.
 */
public class PersonDirector {
    public Person constructPerson(PersonBuilder pb) {
        pb.buildHead();
        pb.buildBody();
        pb.buildFoot();
        return pb.buildPerson();
    }
}
