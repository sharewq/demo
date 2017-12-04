package book.jvm;

/**
 * Created by Think on 2017/10/31.
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oo = new JavaVMStackSOF();
        try {
            oo.stackLeak();
        } catch (Throwable e) {
            System.out.println(oo.stackLength);
            throw e;
        }

    }
}
