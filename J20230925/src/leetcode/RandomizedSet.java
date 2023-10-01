package leetcode;

import java.util.*;

class RandomizedSet {
    //哈希表 + 变长数组
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        //在map中存在对应的值
        if (map.containsKey(val)) {
            return false;
        }
        //变长数组从0开始, map记录对应值和下标
        map.put(val, list.size());
        //两个作用: a.变长数组添加元素 b.变长数组长度增加
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        //map中不存在对应的值, 说明没有删除的值
        if (!map.containsKey(val)) {
            return false;
        }
        //获取list变长数组的最后一个元素
        int swapVal = list.get(list.size() - 1);
        //得到val对应的下标
        int index = map.get(val);
        //把原来的index的值更新为swapVal
        map.put(swapVal, index);
        //把index的下标的值更新为swapVal
        list.set(index, swapVal);
        //删掉map中的val的对应值
        map.remove(val);
        //删掉list中最后一个元素
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        //获取随机下标
        int randomRes = random.nextInt(list.size());
        //返回下标对应的值
        return list.get(randomRes);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */