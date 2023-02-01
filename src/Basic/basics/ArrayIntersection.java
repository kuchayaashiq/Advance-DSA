package Basic.basics;

import java.util.HashSet;

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 2};
        int[] arr2 = {1, 2, 2, 3};
        HashSet<Integer> hs = new HashSet<>();
        int i =0, j= 0;
        while (i < arr1.length && j < arr2.length){
            if(arr1[i] > arr2[j])
                j++;
            else if (arr1[i] < arr2[j]) {
                i++;
            }
            else {
                hs.add(arr1[i]);
                i++;
                j++;
            }
        }
        System.out.println(hs);
    }
}
