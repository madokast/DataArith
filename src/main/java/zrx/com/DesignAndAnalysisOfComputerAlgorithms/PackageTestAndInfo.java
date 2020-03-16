package zrx.com.DesignAndAnalysisOfComputerAlgorithms;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import zrx.com.MultiThread.MyTools;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
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

        //2020年2月18日 采用多线程计算，不再排序
//        //对方法排序，按照TestForDesignAndAnalysisOfComputerAlgorithms 的页数信息
//        List<Method> methodsAnnotatedWithList = new ArrayList<>(methodsAnnotatedWith);
//        methodsAnnotatedWithList.sort(Comparator.comparingInt(m ->
//                ((TestForDesignAndAnalysisOfComputerAlgorithms) m.getAnnotation(ANNOTATION_CLASS)).page()
//        ));


        java.util.concurrent.ConcurrentHashMap<Integer, String> map =
                new ConcurrentHashMap<>(methodsAnnotatedWith.size());


        methodsAnnotatedWith.stream().parallel()
                .forEach(method -> {
                            //因为是多线程，所以信息不直接打印，先存起来
                            StringBuilder stringBuilder = new StringBuilder();

                            //获得这个方法的注解TestForDesignAndAnalysisOfComputerAlgorithms中的值
                            TestForDesignAndAnalysisOfComputerAlgorithms annotation =
                                    (TestForDesignAndAnalysisOfComputerAlgorithms) method.getAnnotation(ANNOTATION_CLASS);

                            //[erAlgorithms.recursion.ArrangeProblem.run][     0]
                            //《这是一个空测试》--p.0
                            stringBuilder.append("[")
                                    .append(method.toString().substring(rootPackage.getName().toString().length(), method.toString().length() - 2))
                                    .append("]")
                                    .append(MyTools.pastTime())
                                    .append("\n").append("《")
                                    .append(annotation.value())
                                    .append("》--p.")
                                    .append(annotation.page())
                                    .append("\n");

                            //打印详细信息
                            if (annotation.detailInfo().length > 0) {
                                Arrays.stream(annotation.detailInfo()).forEach(
                                        info -> stringBuilder.append(info).append("\n"));
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

                                    if (ret != null) {
                                        stringBuilder.append(ret).append("\n");
                                    }
                                });


                            } catch (Exception e) {
                                System.err.println("测试" + method + "出现异常，原因：");
                                e.printStackTrace();
                            }


                            stringBuilder.append("\n");

                            //将测试数据存在map中
                            map.put(annotation.page(), stringBuilder.toString());

                        });

        map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
    }
}
