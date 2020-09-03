package others.sort;
/* gh
 * 2020/7/27
 * 上午9:46
 */

public class ChooseSort {
    public static void main(String[] args) {
        int[] array={-1,8,-4,45,12,7,-23,-8};
        ChooseSort choose=new ChooseSort();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        choose.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public void sort(int[] array){
        if(array.length<2){
            return;
        }
        for (int i = 0; i < array.length-1; i++) {
            int max=array[0];
            int index=0;
            for (int j = 1; j < array.length-i; j++) {
                if(max<array[j]){
                    index=j;
                    max=array[j];
                }
            }
            int temp=array[array.length-1-i];
            array[array.length-1-i]=array[index];
            array[index]=temp;
        }
    }
}
