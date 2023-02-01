package basic;

import java.util.Scanner;

// Count the no of digits
public class NoOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count=0;
        while(num>0){
            num = num/10;
            count++;
        }
        System.out.println(count);
    }
}
