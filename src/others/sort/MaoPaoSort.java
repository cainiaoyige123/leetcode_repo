package others.sort;
/* gh
 * 2020/7/27
 * 上午9:46
 */

public class MaoPaoSort {
    public static void main(String[] args) {
        int[] array={-1,8,-4,45,12,7,-23,-8};
        MaoPaoSort maopao=new MaoPaoSort();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        maopao.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public void sort(int[] array){
        if(array.length<2){
            return;
        }
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
}
