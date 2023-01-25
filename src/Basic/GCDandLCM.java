import java.util.*;
    /* QUESTION:
	1. You are required to print the Greatest Common Divisor (GCD) of two numbers.
	2. You are also required to print the Lowest Common Multiple (LCM) of the same numbers.
	3. Take input "num1" and "num2" as the two numbers.
	4. Print their GCD and LCM.
	Input Format
	num1
	num2
	.. the numbers whose GCD and LCM we have to find.
	Output Format
	a
	b
	.. where 'a' and 'b' are the GCD and LCM respectively.

	Sample Input
	36
	24
	Sample Output
	12
	72
	
    */
    public class GCDandLCM {
    
    public static void main(String[] args) {
      // write your code here 
        Scanner sc = new Scanner(System.in);
        int n1 =  sc.nextInt();
        int n2 =  sc.nextInt();
        
        int on1 = n1;
        int on2 = n2;
        while(n1 % n2 != 0){
            int rem =  n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        int gcd = n2;
        
        int lcm = (on1 * on2) / gcd;
        System.out.println(gcd +"\n"+ lcm);
     }
    }