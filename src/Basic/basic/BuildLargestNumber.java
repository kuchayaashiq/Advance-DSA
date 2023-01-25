package basic;

import java.util.Scanner;

public class BuildLargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();   // denoting no. of Swaps
        String str = sc.next();  // integer string
        String[] strings = str.split(",");
        int intArray[] = new int[strings.length];
        for (int i =0;i<strings.length;i++)
            intArray[i]= Integer.parseInt(strings[i]);
    }
}
