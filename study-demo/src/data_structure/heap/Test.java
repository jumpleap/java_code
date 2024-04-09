package data_structure.heap;

import java.util.Random;

// 测试代码
public class Test {
    public static void main(String[] args) {
        // 获取数组
        int[] array = getArray();
        // 创建优先级队列
        MyPriorityQueue queue = new MyPriorityQueue();
        // 初始化
        queue.initHeap(array);
        // 创建堆
        queue.createHeap();
        // 打印查看
        queue.display();

        queue.offer(10);
        queue.offer(-1);
        queue.display();

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.display();

        queue.headSort();
        queue.display();


    }

    // 获取数组
    private static int[] getArray() {
//        Random random = new Random();
//        int[] array = new int[10];

//        for(int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(100);
//        }
        return new int[] {8, 3, 5, 2, 4, 1, 7, 6, 9, 0};
    }
}
