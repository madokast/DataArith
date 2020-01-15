package zrx.com.DesignPatterns.ResponsibilityChainPattern;

import java.util.Date;

/**
 * Description
 * AbstractLogger
 * <p>
 * Data
 * 14:48
 *
 * @author zrx
 * @version 1.0
 */

public class AbstractLogger {
    private AbstractLogger nextLogger;

    public AbstractLogger setNextLogger(AbstractLogger logger){
        this.nextLogger = logger;
        return nextLogger;
    }

    public void printChain(){
        System.out.print(LEVEL+" ");
        AbstractLogger t = nextLogger;
        while (t!=null){
            System.out.print(t.LEVEL+" ");
            t = t.nextLogger;
        }
        System.out.println();
    }

    private final String LEVEL;

    public AbstractLogger(String LEVEL) {
        this.LEVEL = LEVEL;
    }

    public void log(String level, String msg){
        if(level.equals(LEVEL))
            System.out.println(new Date() +" "+LEVEL+"["+msg+"]");
        else if(nextLogger!=null)
            nextLogger.log(level,msg);
    }

    public static final String INFO = "INFO";
    public static final String BUG = "BUG";
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROR";

}
