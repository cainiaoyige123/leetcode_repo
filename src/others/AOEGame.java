package others;
/* gh
 * 2020/7/23
 * 上午9:21
 */

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 广联达笔试
 * 一个aoe游戏：在一个2d游戏中，所有角色都在一条x轴上，怪物有两种属性，位置h和血量p
 *          英雄角色有攻击距离，例如攻击距离为y，位置为x，则攻击范围为[x-y,x+y]
 *          每对怪物攻击一次，血量减一
 *          输入：第一行n,y分别代表有多少只怪物和英雄的攻击距离
 *              下面n行每行两个值h,p分别代表第i只怪物的位置和血量
 *          输出：最少需要多少次攻击才能消灭全部怪物
 */

public class AOEGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String l1=scanner.nextLine();
        String[] l1s=l1.split(" ");
        int n=Integer.parseInt(l1s[0]);
        int y=Integer.parseInt(l1s[1]);
        int range=2*y;
        TreeMap<Integer,Integer> map=new TreeMap<>();//位置->血量
        for (int i = 0; i < n; i++) {
            String l2=scanner.nextLine();
            String[] l2s=l2.split(" ");
            map.put(Integer.parseInt(l2s[0]),Integer.parseInt(l2s[1]));
        }

        int sum=0;
        while (true){
            Iterator<Integer> iterator = map.keySet().iterator();
            if(!iterator.hasNext()){
                break;
            }
            int firKey=map.firstKey();
            int firVal=map.get(firKey);
            sum+=firVal;
            while (iterator.hasNext()){
                int nextKey=iterator.next();
                if(nextKey<=firKey+range){
                    int num=map.get(nextKey)-firVal;//减去后的值
                    if(num<=0){
                        iterator.remove();
                    }else {
                        map.replace(nextKey,num);
                    }
                }else {
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
