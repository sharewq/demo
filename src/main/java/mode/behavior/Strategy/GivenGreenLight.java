package mode.behavior.Strategy;

/**
 * 求吴国太开绿灯放行
 * Created by Think on 2017/11/23.
 */
public class GivenGreenLight implements Strategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开个绿灯，放行");
    }
}
