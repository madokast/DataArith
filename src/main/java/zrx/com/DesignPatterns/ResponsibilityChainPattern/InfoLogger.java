package zrx.com.DesignPatterns.ResponsibilityChainPattern;

/**
 * Description
 * InfoLogger
 * <p>
 * Data
 * 14:55
 *
 * @author zrx
 * @version 1.0
 */

public class InfoLogger extends AbstractLogger {
    public InfoLogger() {
        super(AbstractLogger.INFO);
    }
}
