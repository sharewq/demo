package book.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Think on 2017/10/31.
 */
public class Testcontroller {
    static class OOMObject {

    }

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }


}
