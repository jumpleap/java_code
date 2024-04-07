package test.practice;

import util.ListNode;

public class Demo7 {
    // 选择题
    /*
        1、散列技术中的冲突是指（ D ）
        A. 两个元素具有相同的序号
        B. 两个元素的键值不同，而其他属性相同
        C. 数据元素过多
        D. 不同键值的元素对应于相同的存储地址
        // 解释: 对于两个数据元素的关键字，他们的值不同，但是不同关键字通过相同哈希函数计算出相同的哈希地址，
        //       该种现象称为哈希冲突或哈希碰撞。

        2、对于一棵二叉排序树：（ B ）遍历可以得到有序序列
        A. 前序 B. 中序 C. 后序 D. 都可以
        // 解释:
        // 二叉搜索树又称二叉排序树，它或者是一棵空树，或者是具有以下性质的二叉树:
        // 1，若它的左子树不为空，则左子树上所有节点的值都小于根节点的值；,
        // 2，若它的右子树不为空，则右子树上所有节点的值都大于根节点的值；
        // 3，它的左右子树也分别为二叉搜索树

        3、枚举（enum）属于基本数据类型（primitive type）（ B ）
        A. 正确 B. 错误
        // 解释: 枚举类型是一种特殊的数据类型，它是一种类(class)类型却又比类类型多了些特殊的约束。

        4、以下哪些是lambda表达式的重要特征【多选】（ ABCD ）
        A. 不需要声明参数类型，编译器可以统一识别参数值。
        B. 一个参数无需定义圆括号，但多个参数需要定义圆括号
        C. 如果主体包含了一个语句，就不需要使用大括号
        D. 如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定表达式返回了一个数值
        // 解释:
        // 以下是lambda表达式的重要特征:
        // 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
        // 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
        // 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
        // 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定表达式返回了一个数值

        5、以下代码中可以正确设置客户端请求编码为 UTF-8 的是 ( A )
        A: request.setCharacterEncoding("UTF-8")
        B: request.setCharset("UTF-8")
        C: request.setContentType("UTF-8")
        D: request.setEncoding("UTF-8")
        // 解释: HttpServletRequest对象中，setCharacterEncoding可以设置请求体中数据的编码格式
     */



    // 编程题
    /*
        给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
        请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
        链接: https://leetcode.cn/problems/merge-in-between-linked-lists/description/
     */

    /**
     * 思路分析: 模拟, 关键点在于找到list1要删除节点的前一个节点和把要删除节点后的节点保存
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 申请哑节点
        ListNode dummy = new ListNode();
        // 遍历节点
        ListNode cur = list1;
        // 新的头节点
        ListNode newHead = dummy;

        // 让dummy指向要删除节点的前一个节点
        // 让cur指向要删除的第一个节点
        for (int i = 0; i < a; i++) {
            dummy.next = cur;
            dummy = dummy.next;
            cur = cur.next;
        }

        // 走到删除节点的最后一个节点
        for (int i = a; i < b; i++) {
            cur = cur.next;
        }
        // tail获取删除节点后面的节点
        ListNode tail = cur.next;

        // tmp记录list2的头节点
        ListNode tmp = list2;
        // 让list找到最后一个节点的位置
        while (list2.next != null) {
            list2 = list2.next;
        }
        // 把list1中删除节点后的节点连接在list2的后面
        list2.next = tail;
        // 把list2连接在dummy的后面
        dummy.next = tmp;
        // 返回头节点
        return newHead.next;
    }


    /*
        给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
        你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
        链接: https://leetcode.cn/problems/add-strings/description/
     */

    /**
     * 思路分析: 模拟, 关键点在于如何获取数字, 进位判断, 字符串反转
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    public String addStrings(String num1, String num2) {
        // 获取num1和num2的长度
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        // 定义一个字符串, 用于添加相加后的数字
        StringBuilder sb = new StringBuilder();
        // 进位符
        int ret = 0;

        // 有一个小于0则跳出
        while (len1 >= 0 && len2 >= 0) {
            // 获取num1和num2的数字
            int n1 = num1.charAt(len1) - '0';
            int n2 = num2.charAt(len2) - '0';

            // 相加, 进位别忘了
            ret = n1 + n2 + ret;
            // 把数字添加到字符串中, 超10取余数
            sb.append(ret % 10);
            // 进位判断
            ret /= 10;
            // 长度递减, 获取下一个字符的关键
            len1--;
            len2--;
        }
        // 到这个地方, len1和len2必有一个小于0

        // len2小于0
        while (len1 >= 0) {
            // 获取num1的数字
            int n1 = num1.charAt(len1) - '0';
            // 相加取余
            ret += n1;
            sb.append(ret % 10);
            // 进位判断
            ret /= 10;
            len1--;
        }

        while (len2 >= 0) {
            // 获取num2的数字
            int n2 = num2.charAt(len2) - '0';
            // 相加取余
            ret += n2;
            sb.append(ret % 10);
            // 进位判断
            ret /= 10;
            len2--;
        }

        // 判断是否还有进位
        if (ret > 0) {
            sb.append(ret);
        }
        // 反转返回字符串
        return sb.reverse().toString();
    }


    /*
        给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
        链接: https://leetcode.cn/problems/add-digits/description/
     */

    /**
     * 法一: 模拟, 关键点在于如何获取最小的数字, 相加后的数大于10如何重置
     * 时间复杂度: O(logN) -> num的位数
     * 空间复杂度: O(1)
     */
    public int addDigits1(int num) {
        int ans = 0;

        while (num != 0) {
            // 取模
            int digit = num % 10;
            // 各位相加
            ans += digit;
            // 降位
            num /= 10;

            // 当num为0且ans大于等于10的情况
            if (num == 0 && ans >= 10) {
                // num重置
                num = ans;
                // 重置ans
                ans = 0;
            }
        }
        // 返回ans
        return ans;
    }

    // 法二: 数字方法
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}