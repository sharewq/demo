package mode.struct.Exterior;

/**
 * 门面模块
 * Created by Think on 2017/11/23.
 */
public class ModuleFacade {
    ModuleA a = new ModuleA();
    ModuleB b = new ModuleB();
    ModuleC c = new ModuleC();

    //示意方法，满足客户端需要的功能
    public void test() {
        a.a1();
        b.b1();
        c.c1();
    }
}
