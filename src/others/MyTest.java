package others;
/* gh
 * 2020/7/25int num=(ch1+ch2-2*'0'+jin);
                jin=num/10;
                yu= (char) (num%10);
 * 下午10:58
 */

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MyTest {
    public static void main(String[] args) {
        int[] arr={1,5};
        System.out.println(new MyTest().minOperations(arr));
    }

    public String thousandSeparator(int n) {
        StringBuilder s=new StringBuilder();
        s.append(n);
        StringBuilder s1 = s.reverse();
        List<String> strs=new ArrayList<>();
        for (int i = 0; i <s1.length(); i+=3) {
            String sub=s1.substring(i,Math.min(i+3,s1.length()));
            strs.add(sub);
        }
        StringBuilder ret=new StringBuilder();
        for (int i = 0; i < strs.size()-1; i++) {
            ret.append(strs.get(i)).append(".");
        }
        ret.append(strs.get(strs.size()-1));
        return ret.reverse().toString();
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] flag=new int[n];
        for (int i = 0; i < edges.size(); i++) {
            int x=edges.get(i).get(1);
            flag[x]++;
        }
        List<Integer> ret=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(flag[i]==0){
                ret.add(i);
            }
        }
        return ret;
    }

    public int minOperations(int[] nums) {
        int sum=0;
        boolean isZero=false;
        while (!isZero){
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]%2==1){
                    sum++;
                    nums[i]=nums[i]-1;
                }
            }
            boolean flag=false;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]!=0){
                    flag=true;
                    nums[i]=nums[i]/2;
                }
            }
            if(flag){
                sum++;
            }else {
                isZero=true;
            }
        }
        return sum;
    }


    //dfs+回溯
    public boolean containsCycle(char[][] grid) {
        int lenx=grid.length;
        int leny=grid[0].length;
        int[][] arrs=new int[lenx][leny];
        return true;
    }

    public void containsCycle0(char[][] grid,int[][] arrs,int x,int y){

    }


}
class Node {
    int val;
    int key;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }

//    @Override
//    public boolean equals(Object o) {
//        Node that=(Node)o;
//        if(this==o){
//            return true;
//        }
//        if(this.val==that.val&&this.key==that.key){
//            return true;
//        }else {
//            return false;
//        }
//    }

    @Override
    public int hashCode() {
        return val+key;
    }


}