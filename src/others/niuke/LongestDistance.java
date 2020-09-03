package others.niuke;
/* gh
 * 2020/8/13
 * 上午9:49
 */

/*
有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。

给定数组A及它的大小n，请返回最大差值。

测试样例：
[10,5],2
返回：0
 */
public class LongestDistance {
    public int getDis(int[] A, int n) {
        int tempMin=Integer.MAX_VALUE;
        int tempMax=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(A[i]<tempMin){
                tempMin=A[i];
            }
            if(A[i]-tempMin>tempMax){
                tempMax=A[i]-tempMin;
            }
        }
        return tempMax;
    }
}
