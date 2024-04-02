package examine;

// 第一次检测
// 链接: https://www.nowcoder.com/exam/test/79111523/detail?pid=52678269&examPageSource=Company&testCallback=https%3A%2F%2Fwww.nowcoder.com%2Fexam%2Fcompany&testclass=%E8%BD%AF%E4%BB%B6%E5%BC%80%E5%8F%91
public class Demo1 {
    // 选择题
    /*
        1.TCP协议三次握手和四次挥手的过程
        三次握手:
            第一次握手：客户端向服务器端发送连接请求报文段，包含自身数据通讯初始序号，进入SYN-SENT状态。
            第二次握手：服务器端收到连接请求报文段后，如果同意，发送应答，包含自身数据通讯初始序号，进入SYN-RECEIVED状态。
            第三次握手：客户端收到应答，最后向服务器端发送确认报文，进入ESTABLISHED状态，此时成功建立长连接。
        加分点:
            客户端和服务器端刚开始都是处于CLOSED（关闭）状态。
            要注意的是客户端主动打开连接，而服务器端是被动打开连接的。
            服务器端的进程先创建TCB（传输控制块）准备接受客户端的连接请求。
        四次挥手:
            因为TCP是全双工通讯模式，在断开连接时两端都需要发送ACK和FIN。
            首先第一次挥手：客户端认为数据发送完毕，需要向服务器端发送连接释放请求。
            第二次挥手：服务器收到连接释放请求，告诉应用层释放TCP连接。然后发送ACK包，进入CLOSE-WAIT状态，
            此时表明客户端到服务器端的连接已经释放，不再接受客户端的数据。因为TCP是全双工的，所以服务器仍可以发送数据。
            第三次挥手：当服务器端数据发送完毕，向客户端发送连接释放请求，进入LAST-ACK状态。
            第四次挥手：客户端收到连接释放请求，向服务器端发送确认应答报文，此时客户端进入TIME-WAIT状态，
            持续2倍的MSL（最长报文段寿命），若期间没有收到服务器端的数据报文，进入CLOSED状态。
            服务器端收到确认应答后，也进入CLOSED状态。


        2.以下关于创建型模式说法正确的是（ A ）
        A 创建型模式关注的是对象创建
        B 创建型模式关注的是功能的实现
        C 创建型模式关注的是组织类和对象的常用方法
        D 创建型模式关注的是对象间的协作
        // 解析: 在软件工程中，创建型模式是处理对象创建的设计模式，试图根据实际情况使用合适的方式创建对象。
        // 基本的对象创建方式可能会导致设计上的问题，或增加设计的复杂度。创建型模式通过以某种方式控制对象的创建来解决问题。

        3.在一棵二叉树上第5层的结点数最多是 ( B )
        A 8
        B 16
        C 32
        D 15
        // 解析: 第n层的节点数为: 2 ^ (n-1)

        4.以下哪个功能比较适合使用UDP协议？（ A ）
        A 数据多播
        B 可靠连接
        C 流量控制
        D 拥塞控制
        // 解析: 可靠链接, 流量控制, 拥塞控制跟TCP有关

        5.下面关于操作系统的说法正确的是(  C  )。
        A 操作系统属于应用软件
        B 操作系统只是用于管理CPU资源的系统软件
        C 操作系统是管理计算机软件和硬件资源的程序集合
        D 操作系统是用于管理外部设备的系统软件

        6.Linux进程中，应用可见的内存空间是一样的，是如何做到的（ B ）
        A 编译时区分
        B 使用虚拟内存转换
        C 运行时分配不一样的实际地址
        D 都不是
        // 解析: 虚拟内存是计算机系统内存管理的一种技术。它使得应用程序认为它拥有连续可用的内存，使得每个进程看到的内存空间一致。

        7.不是存储结构的是（ A ）
        A 二叉树
        B 双向链表
        C 哈希表
        D 循环队列
        // 解析: 逻辑结构是数据元素之间的关系，存储结构是数据元素及其关系在计算机中的存储方式。
        // 存储结构有顺序、链式、索引、散列四种，逻辑结构有线性和非线性结构。
        // 二叉树是逻辑结构，树属于逻辑结构中的非线性结构。
        // 双向链表、哈希表、循环队列都是存储结构分别属于链式、散列和顺序。

        8.MySQL是一种（ C ）数据库管理系统。
        A 层次型
        B 联盟链
        C 关系型
        D 对象型
        // 解析: 关系型数据库的代表包括Oracle, Sql Server, MySQL。

        9.最大堆中插入一条数据的时间复杂度是（ C ）
        A O(n)
        B O(1)
        C O(log(n))
        D O(n^2)
        // 解析: 最大堆插入一条数据的时间复杂度为O(log(n))

        10.事务有多个性质，其中不包括（ B ）
        A 隔离性
        B 不可撤销
        C 原子性
        D 一致性
        // 解析: 事务四大特性ACID：原子性、一致性、隔离性、持久性

        11.产生死锁的4个必要条件为：互斥条件、请求保持条件、（ D ） 、环路条件
        A 永久性条件
        B 相互等待条件
        C 资源均分条件
        D 不可剥夺条件
        // 解析: 产生死锁的四个必要条件：
        //（1） 互斥条件：一个资源每次只能被一个进程使用。
        //（2） 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
        //（3） 不剥夺条件:进程已获得的资源，在末使用完之前，不能强行剥夺。
        //（4） 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
        // 这四个条件是死锁的必要条件，只要系统发生死锁，这些条件必然成立，而只要上述条件之一不满足，就不会发生死锁。

        12.从浏览器打开https://www.zhangyue.com/，TCP/IP协议族中不会被使用到的协议是（ A ）
        A SMTP
        B HTTP
        C TCP
        D IP

        14.以下哪个是表示成功的HTTP响应码 ( A )
        A 200
        B 404
        C 500
        D 302
        // 解析: 200: 请求成功; 404: 服务器无法根据客户端的请求找到资源（网页）;
        // 500: 服务器内部错误，无法完成请求; 302: 请求的资源已被临时的移动到新URI,但资源只是临时被移动。客户端应继续使用原有URI

        15.在用户态执行的进程，如果需要访问内核态的资源，通常会通过什么方式 ( D )
        A 向操作系统发送信号
        B 发送网络请求
        C 直接读取内核态的内存
        D 发送系统调用

        16.在 Linux 终端中，如何查找包含特定文本 "keyword" 的文件 ( A )
        A grep keyword *
        B find -text keyword
        C search keyword *
        D locate keyword

     */



    // 编程题
    /*
        13.删除有序数组重复元素
        给定一个整形数组 nums，固定升序排列，请你删除重复元素，返回删除后数组的新长度。
        链接: https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
     */

    /**
     * 思路分析: 左右指针, 左指针用于保存新数组的长度, 右指针用于遍历数组, 当左右指针的值不同时, 把值保存
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        //左右指针
        int left = 0;
        int right = 1;
        //数组长度
        int len = nums.length;

        //遍历数组
        while(right < len) {
            //左右指针的值不相等,则把right的值赋给left++
            if(nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        //left是下标, 数组长度需要+1
        return left + 1;
    }

    /*
        17.字符逆序
        将一个字符串str的内容颠倒过来，并输出。
        如：输入“I am a student”，输出“tneduts a ma I”。
        保证字符串长度不超过100。
     */

    /*
    import java.util.Scanner;

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextLine()) { // 注意 while 处理多个 case
                String str = in.nextLine();

                StringBuilder sb = new StringBuilder(str);
                System.out.println(sb.reverse().toString());
            }
        }
    }
     */

    /*
        18.在字符串中找出连续最长的数字串
        现有一个字符串str，输出字符串str中的最长的数字子串。
        链接: https://www.nowcoder.com/practice/bd891093881d4ddf9e56e7cc8416562d
     */
    /*
    import java.util.Scanner;

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            // 把数字串进行分割, 只保存数字串
            String[] split = s.split("[^0-9]");
            String tmp = "";

            for (int i = 0; i < split.length; i++) {
                // 找最长的数字串
                if (tmp.length() < split[i].length()) {
                    tmp = split[i];
                }
            }
            System.out.println(tmp);
        }
    }
     */
}
