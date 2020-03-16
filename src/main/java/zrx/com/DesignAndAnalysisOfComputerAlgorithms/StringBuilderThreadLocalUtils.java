package zrx.com.DesignAndAnalysisOfComputerAlgorithms;

/**
 * Description
 * StringBuilder 的线程局部对象的工具类
 * <p>
 * Data
 * 17:20
 *
 * @author zrx
 * @version 1.0
 */

public class StringBuilderThreadLocalUtils {
    //带有初始化的线程局部对象
    private static final ThreadLocal<StringBuilder> stringBuilderThreadLocal =
            ThreadLocal.withInitial(StringBuilder::new);

    /**
     * 对这个局部 StringBuilder append
     * @param info 信息
     * @return 这个 StringBuilder
     */
    public static StringBuilder append(Object info){
        return stringBuilderThreadLocal.get().append(info);
    }

    /**
     * 对这个局部 StringBuilder append 带上换行
     * @param info 信息
     * @return 这个 StringBuilder
     */
    public static StringBuilder appendLine(Object info){
        return stringBuilderThreadLocal.get().append(info).append("\n");
    }

    /**
     * 清楚 StringBuilder 获取它的toString
     * @return toString
     */
    public static String toStringAndClear(){
        StringBuilder stringBuilder = stringBuilderThreadLocal.get();
        String s = stringBuilder.toString();
        stringBuilder.delete(0,stringBuilder.length());
        return s;
    }
}
