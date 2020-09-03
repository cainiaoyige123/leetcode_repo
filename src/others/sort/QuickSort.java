package others.sort;
/* gh
 * 2020/7/27
 * 上午9:27
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] array={25,84,21,47,15,27,68,35,20};
        QuickSort quick=new QuickSort();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        quick.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public void sort(int[] array){
        sort0(array,0,array.length-1);
    }
    private void sort0(int[] array,int start,int end){
        if(start>=end){
            return;
        }
        int start0=start;
        int end0=end;
        while (start<=end){
            while (start<=end&&array[start]<=array[start0]){
                start++;
            }
            while (start<=end&&array[end]>=array[start0]){
                end--;
            }
            if(start<end){
                int temp=array[start];
                array[start]=array[end];
                array[end]=temp;
            }
        }
        int temp1=array[start0];
        array[start0]=array[end];
        array[end]=temp1;
        sort0(array,start0,end-1);
        sort0(array,end+1,end0);
    }
}
