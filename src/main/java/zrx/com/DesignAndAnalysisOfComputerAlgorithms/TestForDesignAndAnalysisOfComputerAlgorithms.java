package zrx.com.DesignAndAnalysisOfComputerAlgorithms;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 执行标注了改注解的方法
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestForDesignAndAnalysisOfComputerAlgorithms {
    String value();
    String[] detailInfo() default {};
    int repeat() default 1;
    int page();
}