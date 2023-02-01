package basic;

import java.util.Scanner;

public class GeneratePrime {
    public  static  int[] primeNumbers(int m){
        int[] primes = new int[m];
        int count =0;
        int isprime =2;
        for (int i=0;count <m;i++){
            boolean prime = true;
            for (int j=2;j<isprime;j++){
                if (isprime%j ==0){
                    prime = false;
                    break;
                }
                if (prime){
                    System.out.print(isprime+" ");
                    count++;
                }
                isprime++;
            }
        }
        return primes;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] output = primeNumbers(n);
        for (int i=0;i<n;i++)
            System.out.println(output[i]);


    }
}
