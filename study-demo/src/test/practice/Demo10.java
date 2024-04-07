package test.practice;
import util.TreeNode;

public class Demo10 {
    /*
        在一个长为 字符串中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
        数据范围：0≤n≤10000，且字符串只有字母组成。
        要求：空间复杂度 O(n)，时间复杂度 O(n)
        链接: https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=196&tqId=37558&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */

    /**
     * 思路分析: 哈希映射
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar (String str) {
        // 定义数组用于映射字符串中的字符
        int[] ans = new int[128];

        // 映射字符串中的字符, 相同的字符累增
        for (int i = 0; i < str.length(); i++) {
            ans[str.charAt(i)]++;
        }

        // 遍历查找第一次出现的字符
        for (int i = 0; i < str.length(); i++) {
            // 当出现第一个只出现一次的字符时, 返回下标
            if (ans[str.charAt(i)] == 1) {
                return i;
            }
        }
        // 没有该字符
        return -1;
    }


    /*
        求给定二叉树的最大深度，深度是指树的根节点到任一叶子节点路径上节点的数量。
        最大深度是所有叶子节点的深度的最大值。（注：叶子节点是指没有子节点的节点。）
        数据范围：0≤n≤100000，树上每个节点的val满足 |val| ≤ 100
        要求： 空间复杂度 O(1),时间复杂度 O(n)
        链接: https://www.nowcoder.com/practice/8a2b2bf6c19b4f23a9bdb9b233eefa73?tpId=196&tqId=37055&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=&dayCountBigMember=%E8%BF%9E%E7%BB%AD%E5%8C%85%E6%9C%88
     */

    /**
     * 思路分析: 递归
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param root
     * @return
     */
    public int maxDepth (TreeNode root) {
        // 判空
        if (root == null) return 0;

        // 左树高度
        int leftHeight = maxDepth(root.left);
        // 右树高度
        int rightHeight = maxDepth(root.right);

        // 判断那边高
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;

        // return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /*
        以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
        数据范围：s.length,t.length≤100000，字符串仅由'0'~‘9’构成
        要求：时间复杂度 O(n)
        链接: https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=196&tqId=37176&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */

    /**
     * 思路分析: 模拟
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param s
     * @param t
     * @return
     */
    public String solve (String s, String t) {
        // 判断是否有字符串为空串
        if (s.length() == 0) return t;
        if (t.length() == 0) return s;

        // 获取两个字符串的长度
        int len1 = s.length() - 1;
        int len2 = t.length() - 1;

        // 定义变长字符串, 用于拼接相加之后的字符串
        StringBuilder str = new StringBuilder();
        // 进位符
        int ret = 0;

        // 其中一个小于0跳出
        while (len1 >= 0 && len2 >= 0) {
            // 获取两个字符串尾端的数字
            int num1 = s.charAt(len1) - '0';
            int num2 = t.charAt(len2) - '0';
            // 相加, 别忘了进位符
            ret = num1 + num2 + ret;
            // 添加到字符串中, 记得模10, 防止溢出
            str.append(ret % 10);
            // 判断是否有进位
            ret /= 10;

            len1--;
            len2--;
        }

        // len2小于0, len1大于0的情况
        while (len1 >= 0) {
            // 获取s尾端的数字
            int tmp = s.charAt(len1) - '0';
            // 相加
            ret += tmp;
            // 取模后添加到字符串中
            str.append(ret % 10);
            // 进位判断
            ret /= 10;

            len1--;
        }

        // len小于0, len2大于0的情况
        while (len2 >= 0) {
            // 获取t字符串尾端的数字
            int tmp = t.charAt(len2) - '0';
            // 相加
            ret += tmp;
            // 取模后, 添加到字符串中
            str.append(ret % 10);
            //进位判断
            ret /= 10;

            len2--;
        }

        // 判断进位
        if (ret > 0) {
            str.append(ret);
        }
        // 反转后返回字符串
        return str.reverse().toString();
    }
}