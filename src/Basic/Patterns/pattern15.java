package Patterns;

import java.util.Scanner;

public class pattern15 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int st = 1, sp = 2 * n - 3 ;

        // pattern 1
        for(int i = 1; i <= n; i++){

            //prints the number of stars required on the line
            for(int j = 1; j <= st; j++){
                System.out.print("*\t");
            }
            //prints the number of spaces required on the line
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            if(i == n)
                st--;
            for(int j = 1; j <= st; j++){
                System.out.print("*\t");
            }
            //
                sp -=2;
                st++;

            System.out.println();
        }

        // pattern 2
        st = 1;
        sp = 2 * n - 3 ;
        for(int i = 1; i <= n; i++){

            //prints the number of stars required on the line
            for(int j = 1; j <= st; j++){
                System.out.print("1\t");
            }
            //prints the number of spaces required on the line
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            if(i == n)
                st--;
            for(int j = 1; j <= st; j++){
                System.out.print("1\t");
            }
            //
            sp -=2;
            st++;

            System.out.println();
        }

        // pattern 3
        st = 1;
        sp = 2 * n - 3 ;

        for(int i = 1; i <= n; i++){

            //prints the number of stars required on the line
            for(int j = 1; j <= st; j++){
                System.out.print( j+"\t");
            }
            //prints the number of spaces required on the line
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }


            if(i == n)
                st--;
            int k = st;
            for(int j = 1; j <= st; j++){
                System.out.print(k +"\t");
                k--;
            }
            sp -=2;
            st++;

            System.out.println();
        }
    }
}
