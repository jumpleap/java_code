package solution;

@SuppressWarnings({"all"})
/**
 * 给定一个包含 n + 1 个整数的数组 nums ，
 * 其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 */
public class FindRepeatNum {
    /**
     * 暴力比较找相同数
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        for(int i=0; i<nums.length-1; i++) {
            for(int j = i+1; j<nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    /**
     * 建立哈希表映射
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        //建立哈希表
        int[] hash = new int[100001];
        //把nums的值映射到哈希的下标中，该下标对应的值自增1
        for(int i=0; i<nums.length; i++) {
            hash[nums[i]]++;
        }

        for(int i=0; i<nums.length; i++) {
            //找出数组中2个或两个以上的元素
            if(hash[nums[i]] >= 2) {
                return nums[i];
            }
        }
        //没有找到的情况
        return -1;
    }
}
