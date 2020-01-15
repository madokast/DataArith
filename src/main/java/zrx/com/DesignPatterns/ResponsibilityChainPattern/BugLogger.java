package zrx.com.DesignPatterns.ResponsibilityChainPattern;

/**
 * Description
 * BugLogger
 * <p>
 * Data
 * 14:55
 *
 * @author zrx
 * @version 1.0
 */

public class BugLogger extends AbstractLogger {
    public BugLogger() {
        super(AbstractLogger.BUG);
    }
}
