package map_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * map和set的OJ练习
 */
public class Solution {
    /*
    给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     */
    public int singleNumber1(int[] nums) {
        //异或的性质解决：相同的数异或为0，0和任何数异或为任何数
        int ret = nums[0];

        for (int i = 1; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }

    /**
     * 思路分析：使用HashSet中不能存在相同数字的特点，找出不重复的数字
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums 给定数组
     * @return 返回唯一不重复的值
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                //set中已含有nums[i]的值
                set.remove(nums[i]);
            } else {
                //set中不含有nums[i]的值
                set.add(nums[i]);
            }
        }

        //再遍历一遍找到唯一的不重复的数字
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];//找到了
            }
        }
        return -1;//没找到
    }


    /*
    给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
    构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
    新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
    并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
     */

    /**
     * 思路分析：使用新老节点构建映射关系，把老节点的值赋给新节点，遍历老节点把新节点的next域和random域进行构建
     * 时间空间复杂度：O(n)
     * @param head 给定头节点
     * @return 返回新链表
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        //先遍历一遍，把新老节点的映射关系构造出来
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            //进行next域的连接
            map.get(cur).next = map.get(cur.next);
            //进行random域的连接
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    /*
    给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
    stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
    字母区分大小写，因此 "a" 和 "A" 是不同类型的石头
     */

    /**
     * 思路分析：把宝石放入HashSet中，在使用石头进行比较
     * 时间、空间复杂度：O(n)
     * @param jewels 宝石
     * @param stones 石头
     * @return 宝石的数量
     */
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();

        //把宝石放入set中
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        //在石头中找宝石的数目
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}