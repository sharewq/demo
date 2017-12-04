package mode.behavior.Order;

/**
 * 关机命令ConcreteCommand
 * Created by Think on 2017/11/28.
 */
public class CommandOff implements Command {
    private Tv tv;

    public CommandOff(Tv tv) {
        this.tv = tv;
    }


    @Override
    public void execute() {
        tv.trunOff();
    }
}
