package others;
/* gh
 * 2020/8/1
 * 下午2:55
 */

//阿里巴巴校招2020.07.31
//
//小强最近在研究某个飘洋过海的游戏。
//
//游戏可以看成一个n∗m的方格图，从左上角(1,1)到右下角的(n,m)有两种地面，C表示为陆地S表示海洋，每次穿行只能到达上下左右四个格子之一，不能走到方格图之外。
//
//在陆地之间穿行一格需要花费3点行动力，在海洋之间穿行一格需要花费2点行动力。
//但是海洋到陆地之间穿行则需要5点行动力。
//
//输入描述：
//第一行输入两个整数n, m, q表示方格图的大小和询问次数。
//随后n行，每行m个元素每个元素为'C'或'S',详见样例。
//
//随后q行每行四个数字bx, by, ex, ey分别代表起点的坐标和终点的坐标。

import java.util.Scanner;

public class PiaoYangGuoHaiGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] s=scanner.nextLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        int q=Integer.parseInt(s[2]);
        char[][] chs=new char[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1=scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                chs[i][j]=s1[j].charAt(0);
            }
        }

    }
}
