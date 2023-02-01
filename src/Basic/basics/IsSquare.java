package basic;

import java.util.Arrays;
import java.util.Scanner;

public class IsSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p1[] = new int[2];
        for (int i = 0; i < 2; i++) {
            p1[i] = sc.nextInt();
        }
        int p2[] = new int[2];
        for (int i = 0; i < 2; i++) {
            p2[i] = sc.nextInt();
        }
        int p3[] = new int[2];
        for (int i = 0; i < 2; i++) {
            p3[i] = sc.nextInt();
        }
        int p4[] = new int[2];
        for (int i = 0; i < 2; i++) {
            p4[i] = sc.nextInt();
        }
        boolean ans = isSquare(p1,p2,p3,p4);
        if(ans==true)
            System.out.print("Yes");
        else
            System.out.print("No");
    }
    public static boolean isSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] lengths = {length(p1, p2), length(p1, p3), length(p1, p4), length(p2, p3), length(p2, p4), length(p3, p4)};
        Arrays.sort(lengths);
        if (lengths[4] == lengths[5]) {
            if (lengths[0] == lengths[1] && lengths[1] == lengths[2] && lengths[2] == lengths[3]) {
                if (lengths[0] != lengths[4]) {
                    return true;
                }
            }
        }

        return false;
    }
        public static int length(int[] p1, int[] p2) {
            return (p2[0]-p1[0])*(p2[0]-p1[0]) + (p2[1]-p1[1])*(p2[1]-p1[1]);
        }
}
