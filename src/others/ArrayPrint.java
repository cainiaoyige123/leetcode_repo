package others;
/* gh
 * 2020/7/25
 * 下午5:30
 */
//一点资讯面试题
//斜着打印二维数组
public class ArrayPrint {
    public static void main(String[] args) {
        int[][] arr=new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}
        };
        ArrayPrint print=new ArrayPrint();
        print.print(arr);
    }

    public void print(int[][] array) {
        if(array.length==0)
            return;
        int lenX = array.length;
        int lenY = array[0].length;
        int sum = lenX + lenY - 2;
        for (int i = 0; i <= sum; i++) {
            if (i < lenY) {
                for (int j = 0; j <= i; j++) {
                    int y = i - j;
                    if (j < lenX && y >= 0) {
                        System.out.print(array[j][y] + " ");
                        continue;
                    }
                    break;
                }
            } else {
                int startX = i - lenY + 1;
                for (int j = startX; j <= i; j++) {
                    int y = i - j;
                    if (j < lenX && y >= 0) {
                        System.out.print(array[j][y] + " ");
                        continue;
                    }
                    break;
                }
            }
            System.out.println();
        }
    }
}
