package others;
/* gh
 * 2020/7/23
 * 下午10:09
 */

import java.util.*;

/**
 * 广联达笔试
 * 求最大平行四边行的面积：一个数组，从数组中取四个数，得最大四边行面积
 * 　输入：第一行n,数组元素个数
 * 　    第二行n个数字,数组的各个元素
 */
public class MostArea {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String l1=scanner.nextLine();
        String l2=scanner.nextLine();
        int n=Integer.parseInt(l1);
        String[] l2s=l2.split(" ");
        List<Integer> list=new ArrayList<>();
        for (String s : l2s) {
            list.add(Integer.parseInt(s));
        }
        TreeMap<Integer,Integer> map=new TreeMap<>((integer, t1) -> {
            if(integer<t1){
                return 1;
            }else if(integer.equals(t1)){
                return 0;
            }else {
                return -1;
            }
        });
        for (Integer num : list) {
            if(map.containsKey(num)){
                map.replace(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        int num=0;
        int area=0;
        int max=0;
        int sec=0;
        while (iterator.hasNext()){
            int key=iterator.next();
            int val=map.get(key);
            if(val>=4){
                if(num==0){//第一最大值
                    area=key*key;
                }else {
                    sec=key;
                    area=max*sec;
                }
                break;
            }
            if(val>=2){
                if(num==0){
                    max=key;
                    num++;
                }else {
                    sec=key;
                    area=max*sec;
                    break;
                }
            }
        }
        if(sec==0){
            System.out.println(-1);
        }else {
            System.out.println(area);
        }
    }
}
