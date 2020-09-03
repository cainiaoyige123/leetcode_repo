package others.sort;
/* gh
 * 2020/7/27
 * 上午9:46
 */

public class HeapSort {
    public static void main(String[] args) {
        int[] array={-1,8,-4,45,12,7,-23,-8};
        HeapSort heap=new HeapSort();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        heap.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public void sort(int[] array){
        if(array.length<2){
            return;
        }
        for (int i = array.length-1; i >0; i--) {
            adapt(array,i);//调整
            swap(array,0,i);//交换
        }
    }

    private void adapt(int[] array,int end){
        int last=(end-1)/2;
        for (int i = last; i >=0 ; i--) {
            adjust(array,end,i);
        }
    }

    private void swap(int[] array,int a,int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }

    private void adjust(int[] array,int end,int i){//递归调整每个节点
        if(2*i+2<=end&&array[i]<array[2*i+2]){
            swap(array,i,2*i+2);
            adjust(array,end,2*i+2);
        }
        if(2*i+1<=end&&array[i]<array[2*i+1]){
            swap(array,i,2*i+1);
            adjust(array,end,2*i+1);
        }
    }
}
