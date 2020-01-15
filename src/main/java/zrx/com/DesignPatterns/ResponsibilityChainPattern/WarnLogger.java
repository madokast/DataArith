package zrx.com.DesignPatterns.ResponsibilityChainPattern;

/**
 * Description
 * WarnLogger
 * <p>
 * Data
 * 14:56
 *
 * @author zrx
 * @version 1.0
 */

public class WarnLogger extends AbstractLogger {
    public WarnLogger() {
        super(AbstractLogger.WARN);
    }
}
