package others.sort;
/* gh
 * 2020/7/27
 * 上午9:47
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] array={-1,8,-4,45,12,7,-23,-8};
        ShellSort shell=new ShellSort();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        shell.shellSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

    }

    public void shellSort(int[] array){
        if(array.length<2){
            return;
        }
        int pox=(array.length-1)/2+1;
        while (pox>0){
            sort(array,pox);
            pox/=2;
        }
    }

    /**
     *
     * @param array 原数组
     * @param pox 增量
     */
    private void sort(int[] array,int pox){
        int num=(array.length-1)/pox+1;
        for (int i = 0; i < pox; i++) {
            for (int j = 1; j < num; j++) {
                int temp=i+j*pox;
                if(temp<array.length){
                    for (int k = temp-pox; k >=0 ; k-=pox) {
                        if(array[k]>array[k+pox]){
                            int temp1=array[k];
                            array[k]=array[k+pox];
                            array[k+pox]=temp1;
                        }else {
                            break;
                        }
                    }
                }
            }
        }
    }


}
