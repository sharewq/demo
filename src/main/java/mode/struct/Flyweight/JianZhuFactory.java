package mode.struct.Flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Think on 2017/11/23.
 */
public class JianZhuFactory {
    private static final Map<String, TiYuGuan> tygs = new HashMap<String, TiYuGuan>();

    public static TiYuGuan getTyg(String yudong) {
        TiYuGuan tyg = tygs.get(yudong);
        if (null == tyg) {
            tyg = new TiYuGuan(yudong);
            tygs.put(yudong, tyg);
        }
        return tyg;
    }

    public static int getSize() {
        return tygs.size();
    }

}
