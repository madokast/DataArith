package zrx.com.DesignPatterns.ResponsibilityChainPattern;

/**
 * Description
 * ErrorLogger
 * <p>
 * Data
 * 14:56
 *
 * @author zrx
 * @version 1.0
 */

public class ErrorLogger extends AbstractLogger {
    public ErrorLogger() {
        super(AbstractLogger.ERROR);
    }
}
