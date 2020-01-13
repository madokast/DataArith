package zrx.com.DesignPatterns.bridgePattern;

import zrx.com.MultiThread.MyTools;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 桥接设计模式
 * <p>
 * Data
 * 19:29
 *
 * @author zrx
 * @version 1.0
 */

public class BridgePatternLearn {
    public static void learn(){
        MyTools.printCurrentMethod(true);

        Remote rremote = new RRemote(new TTTv());
        Remote bbcremote = new BBCRemote(new TTTv());

        Remote rremote2 = new RRemote(new RACTv());
        Remote bbcremote2 = new BBCRemote(new RACTv());

        List<Remote> list = new ArrayList<>(4);
        list.add(rremote);
        list.add(rremote2);
        list.add(bbcremote);
        list.add(bbcremote2);

        for (Remote remote : list) {
            remote.on();
            remote.off();
        }
        
    }
}
