package zrx.com.DesignPatterns.bridgePattern;

/**
 * Description
 * RRemote
 * <p>
 * Data
 * 19:32
 *
 * @author zrx
 * @version 1.0
 */

public class RRemote implements Remote {
    TV tv;

    public RRemote(TV tv) {
        this.tv = tv;
    }

    @Override
    public void on() {
        System.out.println("RRemote on");
        tv.onTv();
    }

    @Override
    public void off() {
        System.out.println("RRemote off");
        tv.offTv();
    }
}
