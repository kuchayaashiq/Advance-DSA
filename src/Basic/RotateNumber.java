import java.util.*;
   /*
	1. You are given two numbers n and k. You are required to rotate n, k times to the right. If k is 	positive, rotate to the right i.e. remove rightmost digit and make it leftmost. Do the reverse for 	negative value of k. Also k can have an absolute value larger than number of digits in n.
	2. Take as input n and k.
	3. Print the rotated number.
	4. Note - Assume that the number of rotations will not cause leading 0's in the result. e.g. such an 	input will not be given
   		n = 12340056
   		k = 3
   		r = 05612340
	Input Format
	"n" where n is any integer.
	"K" where k is any integer.
	Output Format
	"r", the rotated number
	
	Sample Input
	562984
	2
	Sample Output
	845629
	*/
   public class RotateNumber{
   
       public static void main(String[] args) {
         // write your code here  
             Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int k = scn.nextInt();
            int nod = 0; //number of digits
            int temp = n;
            //temporarily storing number to perform division 
            while(temp != 0)
            {
              temp /= 10;
              nod++;
            }
            
            k =  k % nod;
            
            if ( k < 0){
                k = k + nod;
            }
            //25398 will give nod = 5
            int div = 1; //initialize divisor = 1
            int mult = 1; //initialize multiplier = 1
            for (int i = 1; i <= nod; i++)
            {
              if (i <= k)
                //while the iterator is less than k
              {
                //we increase the value of divisor
                div *= 10;
              }
              else
                //or else we increase the value of multiplier {
                mult *= 10;
            }
          int quo = n / div; // extracting the quotient 
          // extracting the remainder
          int rem = n % div; 
          //forming the rotated number;
           int r = rem * mult + quo;
          System.out.print(r);
        }
   }