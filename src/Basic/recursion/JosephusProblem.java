package recursion;

import java.util.Scanner;

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n indicates the no. of Peoples.
        int n = sc.nextInt();
        // k which indicates that k-1 persons are skipped and kth person is killed in circle in a fixed direction
        int k = sc.nextInt();
        int ans =josephus(n,k);
        System.out.print("safe place in the circle is "+ans);
    }
    static int josephus(int n, int k) {
        // If there is only one people in a circle.
        if (n == 1)
            return 1;
        else
            // 1 indicates the i based indexing
            return (josephus(n - 1, k) + k - 1) % n + 1;
    }
}
