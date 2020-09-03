//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。 
//
// 
// get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。 
// put(key, value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效
//。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最久未使用的键。 
// 
//
// 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。 
//
// 
//
// 进阶： 
//你是否可以在 O(1) 时间复杂度内执行两项操作？ 
//
// 
//
// 示例： 
//
// LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回 1
//cache.put(3, 3);    // 去除 key 2
//cache.get(2);       // 返回 -1 (未找到key 2)
//cache.get(3);       // 返回 3
//cache.put(4, 4);    // 去除 key 1
//cache.get(1);       // 返回 -1 (未找到 key 1)
//cache.get(3);       // 返回 3
//cache.get(4);       // 返回 4 
// Related Topics 设计


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class LfuCache {
    public static void main(String[] args) {

    }


    static class Node implements Comparable<Node>{
        int key;
        int val;
        long timeStamp;
        int freq;
        public Node(int key,int val,int freq){
            this.val=val;
            this.key=key;
            this.freq=freq;
        }

        @Override
        public int compareTo(Node node) {
            if(this.freq<node.freq){
                return -1;
            }else if(this.freq==node.freq){
                if(this.timeStamp<node.timeStamp){
                    return -1;
                }else if(this.timeStamp==node.timeStamp){
                    return 0;
                }else {
                    return 1;
                }
            }else {
                return 1;
            }
        }

        @Override
        public int hashCode() {
            return val+key;
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        int capacity=8;
        TreeSet<Node> freqSet=new TreeSet<>();
        Map<Integer,Integer> map=null;
        public LFUCache(int capacity) {
            this.capacity=capacity;
            map=new HashMap<>(capacity);
        }

        public int get(int key) {
            if(map.containsKey(key)){

                return map.get(key);
            }else {
                return -1;
            }

        }

        public void put(int key, int value) {

        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}