package mode.struct.Exterior;

/**
 * 门面模式
 *  使用门面模式还有一个附带的好处，就是能够有选择性地暴露方法。
 *  一个模块中定义的方法可以分成两部分，一部分是给子系统外部使用的，
 *  一部分是子系统内部模块之间相互调用时使用的。
 *  有了Facade类，那么用于子系统内部模块之间相互调用的方法就不用暴露给子系统外部了。
 *
 *  门面模式的优点：
 　　●　　松散耦合
 　　门面模式松散了客户端与子系统的耦合关系，让子系统内部的模块能更容易扩展和维护。
 　　●　　简单易用
 　　门面模式让子系统更加易用，客户端不再需要了解子系统内部的实现，也不需要跟众多子系统内部的模块进行交互，只需要跟门面类交互就可以了。
 *  Created by Think on 2017/11/23.
 */
public class Client {
    public static void main(String[] args) {
        ModuleFacade M = new ModuleFacade();
        M.test();

    }
}
