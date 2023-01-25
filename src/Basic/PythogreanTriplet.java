import java.util.*;
	/*
	1. You are required to check if a given set of numbers is a valid Pythagorean triplet.
	2. Take as input three numbers a, b and c.
	3. Print true if they can form a Pythagorean triplet and false otherwise.
	Sample Input:
	3
	4
	5
	Sample Output
	true
*/
public class PythogreanTriplet {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int c = scn.nextInt();

    int max = a;
    if (b >= max)
      max = b;

    if (c >= max)
      max = c;

    if (max == a) {
      System.out.println((b * b + c * c) == (a * a));
    } else if (max == b) {
      System.out.println((a * a + c * c) == (b * b));
    } else {
      System.out.println((a * a + b * b) == (c * c));
    }
  }
}