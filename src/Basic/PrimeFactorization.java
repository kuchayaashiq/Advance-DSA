import java.util.*;
	/*
	1. You are required to display the prime factorization of a number.
    	2. Take as input a number n.
    	3. Print all its prime factors from smallest to largest.
                               
	Input Format
	n, an integer
	Output Format
	p1  p2  p3  p4.. all prime factors of n.
	
	Sample Input
	1440
	Sample Output
	2 2 2 2 2 3 3 5

	*/
public class PrimeFactorization{

    public static void main(String[] args) {
      // write your code here 
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      for(int div = 2; div * div <= n; div++){
          while(n % div == 0){
              n /=div;
              System.out.print(div +" ");
          }
      }
      if(n != 1)
        System.out.print(n);
    }
}