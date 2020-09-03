package others.niuke;
/* gh
 * 2020/8/13
 * 上午10:08
 */

import java.util.ArrayList;
import java.util.List;

/*
现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，但是由于城市道路交通的原因，他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案到达商家地址。

给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，0代表可以经过的地区，请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。

测试样例：
[[0,1,0],[2,0,0]],2,3
返回：2
 */
public class Visit {
    public int countPath(int[][] map, int n, int m) {
        int lenx=map.length;
        int leny=map[0].length;
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < lenx; i++) {
            for (int j = 0; j < leny; j++) {
                if(map[i][j]==1||map[i][j]==2){
                    list.add(new int[]{i,j});
                }
            }
        }
        int[] pos1=list.get(0);
        int[] pos2=list.get(1);
        if(pos1[0]>pos2[0]){
            pos1=list.get(1);
            pos2=list.get(0);
        }
        int[][] nums=new int[lenx][leny];
        nums[pos1[0]][pos1[1]]=1;
        if(pos1[1]>pos2[1]){//右上左下模式
            for (int i = pos1[0]; i <= pos2[0]; i++) {
                for (int j = pos1[1]; j >= pos2[1]; j--) {
                    if(i==pos1[0]&&j==pos1[1]){
                        continue;
                    }
                    if(map[i][j]!=-1){
                        if(i-1>=0){
                            nums[i][j]+=nums[i-1][j];
                        }
                        if(j+1<leny){
                            nums[i][j]+=nums[i][j+1];
                        }
                    }
                }
            }
        }else {//左上右下模式
            for (int i = pos1[0]; i <= pos2[0]; i++) {
                for (int j = pos1[1]; j <= pos2[1]; j++) {
                    if(i==pos1[0]&&j==pos1[1]){
                        continue;
                    }
                    if(map[i][j]!=-1){
                        if(i-1>=0){
                            nums[i][j]+=nums[i-1][j];
                        }
                        if(j-1>=0){
                            nums[i][j]+=nums[i][j-1];
                        }
                    }
                }
            }
        }
        return nums[pos2[0]][pos2[1]];

    }
}
