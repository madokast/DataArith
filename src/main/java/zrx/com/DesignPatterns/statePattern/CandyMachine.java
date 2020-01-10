package zrx.com.DesignPatterns.statePattern;

/**
 * Description
 * 糖果机
 * * 可以接受的事件：投入硬币、取回硬币、转动
 * *      putCoin
 * *      returnCoin
 * *      rotate
 * *
 * * 存在的状态：没有硬币、有硬币、糖果售罄
 * *      noCoin
 * *      hasCoin
 * *      noCandy
 * <p>
 * Data
 * 11:10
 *
 * @author zrx
 * @version 1.0
 */

public class CandyMachine {
    private int candy;
    private State currentState;

    private NoCoinState noCoinState = new NoCoinState();
    private HasCoinState hasCoinState = new HasCoinState();
    private NoCandyState noCandyState = new NoCandyState();

    public CandyMachine(int candy) {
        this.candy = candy;
        currentState = new NoCoinState();
        System.out.println("建立一个有" + this.candy + "个糖果的糖果机");
    }

    public void putCoin() {
        System.out.println("投入硬币");
        currentState.putCoin();
    }

    public void returnCoin() {
        System.out.println("取出硬币");
        currentState.returnCoin();
    }

    public void rotate() {
        System.out.println("转动糖果机");
        currentState.rotate();
    }

    public State getCurrentState() {
        return this.currentState;
    }

    private void setCurrentState(State state) {
        this.currentState = state;
    }

    //----------------state-------------------------
    private interface State {
        void putCoin();

        void returnCoin();

        void rotate();
    }

    private class NoCandyState implements State {
        @Override
        public void putCoin() {
            System.out.println("[无糖果状态下，收到了硬币，这不太好]");
            setCurrentState(hasCoinState);
        }

        @Override
        public void returnCoin() {
            System.out.println("[无糖果状态下，想退币，不可能]");
        }

        @Override
        public void rotate() {
            System.out.println("[无糖果状态下，转糖果，也不可能]");
        }
    }

    private class HasCoinState implements State {
        @Override
        public void putCoin() {
            System.out.println("[有硬币状态下，无法再投入硬币!!]");
        }

        @Override
        public void returnCoin() {
            System.out.println("[有硬币状态下，成功退出硬币]");
            setCurrentState(noCoinState);
        }

        @Override
        public void rotate() {
            System.out.println("[有硬币状态下，转糖果]");
            if(candy==0){
//                System.err.println("不应该打印这句话");
                System.out.println("[有硬币状态下，转糖果，但是没有糖果了，请退币]");
            }else {
                candy--;
                System.out.println("[有硬币状态下，转出了好吃的糖果~~~~~]");
                System.out.println("剩下糖果数：" + candy);
                if(candy==0){
                    setCurrentState(noCandyState);
                }else {
                    setCurrentState(noCoinState);
                }
            }


        }
    }

    private class NoCoinState implements State {
        @Override
        public void putCoin() {
            System.out.println("[无硬币状态下，收到了硬币]");
            setCurrentState(hasCoinState);
        }

        @Override
        public void returnCoin() {
            System.out.println("[无硬币状态下，吐不出硬币的!!]");
        }

        @Override
        public void rotate() {
            System.out.println("[无硬币状态下，转不出糖果的!!]");
        }
    }


}
