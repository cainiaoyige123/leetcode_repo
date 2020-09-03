package others.sort;
//归并排序数组实现
public class MergeSortArray {

    public static void main(String[] args) {
        int[] array={9,6,7,2,3,8,5,1};
        MergeSortArray merge=new MergeSortArray();
        merge.prinArray(array);
        merge.mergeSort(array);
        merge.prinArray(array);
    }

    public void mergeSort(int[] array){
        sort(array,0,array.length-1);
    }
    public void sort(int[] array,int start,int end){
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        sort(array,start,mid);
        sort(array,mid+1,end);
        merge(array,start,mid+1,end);
    }
    public void merge(int[] array,int start,int mid,int end){
        int myStart=start;
        int len=end-start+1;
        int[] tempArr=new int[len];
        int i=0;
        int start0=mid;
        while (true){
            if(start>=mid||start0>end){
                break;
            }
            if(array[start]>array[start0]){
                tempArr[i++]=array[start0];
                start0++;
            }else {
                tempArr[i++]=array[start];
                start++;
            }
        }
        while (start<mid){
            tempArr[i++]=array[start++];
        }
        while (start0<=end){
            tempArr[i++]=array[start0++];
        }
        for (int j = 0; j < len; j++) {
            array[myStart+j]=tempArr[j];
        }
    }

    public void prinArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
