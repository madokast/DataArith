package zrx.com.DesignPatterns.bridgePattern;

/**
 * Description
 * RACTv
 * <p>
 * Data
 * 19:30
 *
 * @author zrx
 * @version 1.0
 */

public class RACTv implements TV {
    @Override
    public void onTv() {
        System.out.println("打开RACTv");
    }

    @Override
    public void offTv() {
        System.out.println("关闭RACTv");
    }
}
