package basic;

import java.util.Scanner;

public class OccuranceOfKey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int key = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] =sc.nextInt();
        }
       /* int index = occurance(0,arr,key);
        System.out.println(index);*/
       AllOccurance(0,arr,key);
    }

    private static void AllOccurance(int index, int[] arr, int key) {
        if (index == arr.length)
            return;
        if (arr[index]== key){
            System.out.print(index+ " ");
        }
        AllOccurance(index+1,arr,key);
    }
/*
    private static int occurance(int index,int[] arr, int key) {
        if (index ==arr.length)
            return -1;
        //base condition
        if (arr[index] ==key)
            return index;
        int ans = occurance(index+1, arr,key);
        return ans;
    }*/





}
