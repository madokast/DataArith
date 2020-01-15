package zrx.com.DesignPatterns.ResponsibilityChainPattern;

import zrx.com.MultiThread.MyTools;

/**
 * Description
 * 责任链设计模式
 * <p>
 * Data
 * 14:46
 *
 * @author zrx
 * @version 1.0
 */

public class ResponsibilityChainPatternLearn {
    private static AbstractLogger logger;
    static  {
        logger = new InfoLogger();

        logger.setNextLogger(new BugLogger())
                .setNextLogger(new WarnLogger())
                .setNextLogger(new ErrorLogger());
    }

    public static void learn(){
        //使用LOG演示责任链设计模式

        MyTools.printCurrentMethod(true);

        logger.printChain();

        logger.log(AbstractLogger.INFO,"info msg");
        logger.log(AbstractLogger.WARN,"warn msg");
        logger.log(AbstractLogger.BUG,"bug msg");
        logger.log(AbstractLogger.ERROR,"error msg");

    }
}
