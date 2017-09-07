package demo.anderson.mapper;

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anderson on 2017/9/5 0005.
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class);
        logger.info("info");
        logger.error("error");
        logger.warn("warn");
//        List al = new ArrayList();
//        int size;
//        int index;
//        for (int i = 0; i < 20; i++) {
//            al.add(i);
//        }
//        while ((size = al.size()) != 0) {
//            index = (int) (Math.random() * (size));
//            System.out.println(al.remove(index));
//        }

    }
}
