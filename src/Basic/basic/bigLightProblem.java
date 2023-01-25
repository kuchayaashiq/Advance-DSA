package basic;
/*BigLight
Gian and Suneo want their heights to be equal so they asked Doraemons help. Doraemon
gave a big light to both of them but both big lights have different speeds of magnifying.
Let us assume the big light given to Gian can increase the height of a person by v1 m/s and that of
Suneos big light is v2 m/s. At the end of each second Doraemon check if their heights are equal or not.

Given the initial height of Gian and Suneo, your task is to check whether the height of Gian and Suneo
will become equal at some point or not, assuming they both started at the same time.
*
* */

import java.util.Scanner;

public class bigLightProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h1 =sc.nextInt();
        int h2 =sc.nextInt();
        int v1 =sc.nextInt();
        int v2 =sc.nextInt();
        while(true){
            if((h1+v1)==(h2+v2)) {
                System.out.println("true");
                break;
            }
            else {
                System.out.println("false");
                break;
            }


        }
    }
}
