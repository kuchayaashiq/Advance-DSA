package recursion;
/*
* program for   QUICKSORT with middle element as pivot element
* */

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {15,7,9,13,12,16,4,18,11};
        int len = arr.length;

        quickSort qs= new quickSort();
        qs.QuickSortRecursion(arr,0,len-1);

        //print sorted Array
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]+ " ");
        }


    }
    void  QuickSortRecursion(int[]arr, int low, int high){
        int p =partition(arr,low,high);
        if(low<p-1){
            QuickSortRecursion(arr,low,p-1);
        }
        if (p<high){
            QuickSortRecursion(arr,p,high);
        }
    }
    int partition(int[] arr,int low, int high){
        int pivot =arr[(low+high)/2];
        while (low<=high){
            while (arr[low]<pivot) {
                low++;
            }
            while (arr[high]>pivot) {
                high--;
            }
            if (low<=high){
                int temp =arr[low];
                arr[low] =arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }

        return low;
    }

}
