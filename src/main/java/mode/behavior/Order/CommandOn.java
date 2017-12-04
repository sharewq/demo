package mode.behavior.Order;

/**
 * 开机命令ConcreteCommand
 * Created by Think on 2017/11/28.
 */
public class CommandOn implements Command {
    private Tv tv;

    public CommandOn(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}
