package systemcode;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 阻塞队列的基本方法使用
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
        //阻塞队列的put方法使用
        blockingDeque.put("111");
        blockingDeque.put("222");
        blockingDeque.put("333");
        blockingDeque.put("444");

        //阻塞队列的take方法使用
        System.out.println(blockingDeque.take());
        System.out.println(blockingDeque.take());
        System.out.println(blockingDeque.take());
        System.out.println(blockingDeque.take());
        //当队列中的元素被取完了后,还想继续取元素的话会进行阻塞
        System.out.println(blockingDeque.take());
        System.out.println(blockingDeque.take());
    }
}
