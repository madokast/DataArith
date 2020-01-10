package zrx.com.DesignPatterns.statePattern;

import java.util.Scanner;

/**
 * Description
 * 状态设计模式
 * 一个对象(instance) 有多个状态
 * 状态接受事件，后会改变状态，那么很简单
 * 把每个状态作为一个类
 * 都实现一个state接口
 * state 接口中定义所有的事件
 *
 * 每个状态实现state ，实现每个事件在当前状态下的意义
 * 每个状态，中包含 instance
 *
 * 状态类
 *
 * instance 中有个方法 - setState() 可以用于改变instance的状态
 *
 * 状态类不暴露，只在instance 中提供对外的方法
 *
 * ------------------
 * 糖果机
 *
 * 可以接受的事件：投入硬币、取回硬币、转动
 *      putCoin
 *      returnCoin
 *      rotate
 *
 * 存在的状态：没有硬币、有硬币、糖果售罄
 *      noCoin
 *      hasCoin
 *      noCandy
 *
 * <p>
 * Data
 * 10:58
 *
 * @author zrx
 * @version 1.0
 */

public class StatePatternLearn {
    public static void main(String[] args) {
        CandyMachine candyMachine = new CandyMachine(1);

        Scanner scanner = new Scanner(System.in);
        System.err.println("输入p放入硬币，输入g取出硬币，输入r转动，输入e停止");
        System.out.println("当前糖果机状态：" + candyMachine.getCurrentState());

        String ss = "grpgxpgprrgppgxprrpxgge";
        int i = 0;


        while (i<ss.length()){
            String s = String.valueOf(ss.charAt(i));
            System.out.println("输入" + s);
            switch (s){
                case "p":
                    candyMachine.putCoin();
                    break;
                case "g":
                    candyMachine.returnCoin();
                    break;
                case "r":
                    candyMachine.rotate();
                    break;
                case "e":
                    System.out.println("游戏结束");
                    return;
                default:
                    System.err.println("请输入正确的命令");
                    System.err.println("输入p放入硬币，输入g取出硬币，输入r转动，输入e停止");
            }
            System.out.println("当前糖果机状态：" + candyMachine.getCurrentState());
            i++;
        }
    }
}
