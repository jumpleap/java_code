package map_set;

import java.util.*;

public class Solution1 {
    /*
    旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。
    现在给出应该输入的一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。
     */
    public static void main(String[] args) {
        String[] words = new String[]{"I", "am", "a", "good", "boy"};
        getWordSum(words);

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            printBadKey(s1, s2);
        }
    }

    private static void printBadKey(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        //把实际输出的字符放入到set中
        for (char ch : s2.toUpperCase().toCharArray()) {
            set.add(ch);
        }

        //用应该输入的字符和实际输出的字符进行比较，找出坏掉的键
        Set<Character> set2 = new HashSet<>();//作用：防止输出重复坏键
        for (char ch : s1.toUpperCase().toCharArray()) {
            //不包含的字符即为坏掉的键
            if (!set.contains(ch) && !set2.contains(ch)) {
                System.out.print(ch);//这里可能会输出重复坏掉的键
                set2.add(ch);
            }
        }
    }


    /**
     * 统计单词出现的次数
     */
    public static void getWordSum(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                int value = map.get(word);
                map.put(word, value + 1);
            }
        }
        System.out.println(map);
    }


    /*
    给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
    返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        //统计每个单词出现的次数
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                int value = map.get(word);
                map.put(word, value + 1);
            }
        }

        //建立小根堆，指定比较的方式
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if (o1.getValue().compareTo(o2.getValue()) == 0) {
                            //按字母顺序建立大根堆
                            return o2.getKey().compareTo(o1.getKey());
                        }
                        return o1.getValue() - o2.getValue();
                    }
                });


        //遍历map，调整优先级队列
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                Map.Entry<String, Integer> top = minHeap.peek();
                //如果当前频率相同
                if (top.getValue().compareTo(entry.getValue()) == 0) {
                    //字母顺序小的进来
                    if (top.getKey().compareTo(entry.getKey()) > 0) {
                        //出队
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                } else {
                    if (top.getValue().compareTo(entry.getValue()) < 0) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }
            }
        }

        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> top = minHeap.poll();
            ret.add(top.getKey());
        }

        Collections.reverse(ret);
        return ret;
    }
}