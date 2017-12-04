package mode.behavior.Order;

/**
 * 可以看作是遥控器Invoker
 * Created by Think on 2017/11/28.
 */
public class Control {
    private Command onCommand, offCommand, changeChannel;

    public Control(Command on, Command off, Command change) {
        this.onCommand = on;
        this.offCommand = off;
        this.changeChannel = change;
    }

    public void turnOn() {
        onCommand.execute();
    }

    public void turnOff() {
        offCommand.execute();
    }

    public void changeChannel() {
        changeChannel.execute();
    }

}
