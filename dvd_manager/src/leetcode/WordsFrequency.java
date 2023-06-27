package leetcode;

import java.util.HashMap;

/**
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 * 你的实现应该支持如下操作：
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 */
class WordsFrequency {
    //法一：时间复杂度过大
    // String[] words;
    // public WordsFrequency(String[] book) {
    //     words = book;
    // }

    // public int get(String word) {
    //     int len = words.length;
    //     int count = 0;
    //     for (int i = 0; i < len; i++) {
    //         if(words[i].equals(word)) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }


    /**
     * 法二：使用hash表
     */
    private HashMap<String, Integer> map;

    public WordsFrequency(String[] book) {
        map = new HashMap<>();//初始化
        //循环遍历book数组
        for (String word : book) {
            //判断map中是否已经包含word词汇
            if (map.containsKey(word)) {
                //包含的话则使这个词汇的次数+1
                map.put(word, map.get(word) + 1);
            } else {
                //不包含的话，第一次出现则设置为1
                map.put(word, 1);
            }
        }
    }

    //word单词出现的次数
    public int get(String word) {
        //判断word是否在map中
        //返回value值，即word单词出现的次数
        //不存在返回0
        return map.getOrDefault(word, 0);
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */