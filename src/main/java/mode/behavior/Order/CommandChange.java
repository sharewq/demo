package mode.behavior.Order;

/**
 * 频道切换命令ConcreteCommand
 * Created by Think on 2017/11/28.
 */
public class CommandChange implements Command {
    private Tv tv;

    private int channel;

    public CommandChange(Tv tv, int channel) {
        this.tv = tv;
        this.channel = channel;
    }

    @Override
    public void execute() {
        tv.changeChannel(channel);
    }
}
