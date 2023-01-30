package FunctionsAndArray;

import java.util.Scanner;

public class CountSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
        countSort(arr, min, max);
        
        for (int i : arr) {
			System.out.print(i);
		}
	}

	private static void countSort(int[] arr, int min, int max) {
		int range = max - min + 1;
		
		// frequency Array to store frequency of same elements
		int[] farr = new int[range];  
		for (int i = 0; i < arr.length; i++) {
			int idx = arr[i] - min;
			farr[idx]++;
		}
		
		// convert frequency array into prefixSum array
		for (int i = 1; i < farr.length; i++) {
			farr[i] = farr[i] + farr[i -1];
		}
		
		//step 1 : traverse original array from last
		//step 2 : get index where array element to be filled
		//step 3 : insert into answer array 
		//step 4 : decrement prefix array 
		int[] ans = new int[arr.length];
		for (int i = arr.length; i >= 0; i++) {
			int val = arr[i];
			int pos = farr[val - min];
			int idx = pos -1;
			ans[idx] = val;
			farr[val - min]--;
		}
		for (int i = 0; i < ans.length; i++) {
			arr[i] = ans[i];
		}
	}

}
