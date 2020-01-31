package zrx.com.DesignAndAnalysisOfComputerAlgorithms;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import zrx.com.MultiThread.MyTools;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description
 * 开始学习算法设计与分析 第三版 清华大学出版社
 * 这是集中的测试类
 * 只有一个方法
 * <p>
 * Data
 * 18:39
 *
 * @author zrx
 * @version 1.0
 */

public class PackageTestAndInfo {
    //注解类
    private static final Class<? extends Annotation> ANNOTATION_CLASS =
            TestForDesignAndAnalysisOfComputerAlgorithms.class;

    public static void test() {
//        MyTools.printCurrentMethod(true);
        System.err.println("-------算法设计于分析全部练习");

        //获得所在包
        final Package rootPackage = PackageTestAndInfo.class.getPackage();

//        System.out.println("rootPackage = " + rootPackage);
//        System.out.println("rootPackage.getName() = " + rootPackage.getName());

        //扫描包下所有的类的所有的方法，得到带有注解TestForDesignAndAnalysisOfComputerAlgorithms的方法集合
        Set<Method> methodsAnnotatedWith = new Reflections(rootPackage.getName(), new MethodAnnotationsScanner())
                .getMethodsAnnotatedWith(ANNOTATION_CLASS);


//        System.out.println("typesAnnotatedWith = " + methodsAnnotatedWith);

        List<Method> methodsAnnotatedWithList = new ArrayList<>(methodsAnnotatedWith);
        methodsAnnotatedWithList.sort(Comparator.comparingInt(m ->
                ((TestForDesignAndAnalysisOfComputerAlgorithms) m.getAnnotation(ANNOTATION_CLASS)).page()
        ));

        methodsAnnotatedWithList.forEach(method -> {
        //获得这个方法的注解TestForDesignAndAnalysisOfComputerAlgorithms中的值
        TestForDesignAndAnalysisOfComputerAlgorithms annotation =
                (TestForDesignAndAnalysisOfComputerAlgorithms) method.getAnnotation(ANNOTATION_CLASS);

//            MyTools.printMsgWithThreadAndTime("[" + method + "]" + annotation.value());
        System.out.println("[" +
                (method.toString().substring(rootPackage.getName().toString().length(), method.toString().length() - 2)) + "]" +
                MyTools.pastTime() + "\n" +
                "《" + annotation.value() + "》--p." + annotation.page());
        if (annotation.detailInfo().length > 0) {
            Arrays.stream(annotation.detailInfo()).forEach(System.out::println);
        }


        //获得这个方法所在的类
        Class<?> thisClass = method.getDeclaringClass();

        try {
            //实例化类
            Constructor<?> constructor = thisClass.getConstructor(null);
            Object instance = constructor.newInstance();

            //重复
            MyTools.justDoIt(annotation.repeat(), () -> {
                //执行方法
                Object ret = null;
                try {
                    ret = method.invoke(instance);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.err.println("测试" + method + "出现异常，原因：");
                    e.printStackTrace();
                }

                if (ret != null)
                    System.out.println("return: " + ret);
            });


        } catch (Exception e) {
            System.err.println("测试" + method + "出现异常，原因：");
            e.printStackTrace();
        }

        System.out.println();
    });


}
}
