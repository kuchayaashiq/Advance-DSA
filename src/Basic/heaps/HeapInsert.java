package heaps;

import java.util.Scanner;

public class HeapInsert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h[] = new int[100];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        n= Insert(h,n,num);
        for (int i = 0; i < n; i++) {
            System.out.print(h[i]+" ");
        }
        n = delete(h,n);
       System.out.println();
       for (int i = 0; i < n; i++) {
            System.out.print(h[i]+" ");
       }
    }

    private static int delete(int[] h, int n) {
        h[0] = h[n-1];
        n =n-1;

        heapifyDelete(h,n,0);


        return n;
    }

    private static void heapifyDelete(int[] h, int n, int i) {
        int largest = i;
        int left = 2*i +1;
        int right = 2*i+2;
        if(left < n && h[left] > h[largest])
            largest = left;
        if(largest != i){
            int temp = h[i];
            h[i] = h[largest];
            h[largest] = temp;

            heapifyDelete(h,n, largest);
        }
    }


    public static int Insert(int[] h, int n, int num){
        n = n+1;
        h[n-1] = num;
        heapifyInsert(h,n,n-1);
        return n;
    }

    private static void heapifyInsert(int[] h, int n, int i) {
        int parent  = (i-1)/2;
        if (h[i] > h[parent]) {

            // swap h[i] and h[parent]
            int temp = h[i];
            h[i] = h[parent];
            h[parent] = temp;

            // Recursively heapify the parent node
            heapifyInsert(h, n, parent);
        }
    }

}
