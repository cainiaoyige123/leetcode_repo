package others.tianchi;
/* gh
 * 2020/8/20
 * 下午10:38
 */

import java.util.TreeSet;

public class DoHomeWork {
    public static void main(String[] args) {

    }

    public long doingHomework(int[] cost, int[] val) {
        TreeSet<Integer> set=new TreeSet<>();
        int temp=0;
        for (int i = 0; i < cost.length; i++) {
            temp+=cost[i];
            set.add(temp);
        }
        long sum=0;
        for (int i = 0; i < val.length; i++) {
            Integer num=set.floor(val[i]);
            if(num!=null){
                sum+=num;
            }
        }
        return sum;
    }
}
