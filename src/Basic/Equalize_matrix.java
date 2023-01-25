import java.util.Scanner;

public class Equalize_matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0,p = 0;
        for(int i=0;i<n;i++) {
             count = 0;
            for (int j = 0; j < n; j++){
                if (arr[i] == arr[j])
                    count++;
            }
        }
        if (count>p)
            p=count;
        System.out.println(n-p);
    }
}
