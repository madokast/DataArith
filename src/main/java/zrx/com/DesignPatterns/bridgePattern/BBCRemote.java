package zrx.com.DesignPatterns.bridgePattern;

/**
 * Description
 * BBCRemote
 * <p>
 * Data
 * 19:31
 *
 * @author zrx
 * @version 1.0
 */

public class BBCRemote implements Remote {
    TV tv;

    public BBCRemote(TV tv) {
        this.tv = tv;
    }

    @Override
    public void on() {
        System.out.println("BBCRemote on");
        tv.offTv();
    }

    @Override
    public void off() {
        System.out.println("BBCRemote off");
        tv.offTv();
    }
}
