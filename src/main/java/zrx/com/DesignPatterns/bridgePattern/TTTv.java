package zrx.com.DesignPatterns.bridgePattern;

/**
 * Description
 * TTTv
 * <p>
 * Data
 * 19:31
 *
 * @author zrx
 * @version 1.0
 */

public class TTTv implements TV {
    @Override
    public void onTv() {
        System.out.println("open TTTV");
    }

    @Override
    public void offTv() {
        System.out.println("off TTTV");
    }
}
