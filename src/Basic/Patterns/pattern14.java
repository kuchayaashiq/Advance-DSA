package Patterns;

import java.util.Scanner;

public class pattern14 {
    public static void main(String[] args) {

        // write ur code here
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int st = 1, sp = n/2;
       // pattern 1
        for(int i = 1; i <= n; i++){

            //prints the number of spaces required on the line
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            //prints the number of stars required on the line
            for(int j = 1; j <= st; j++){
                System.out.print("1\t");
            }

            if(i <= n/2){

                sp--;
                st +=2;
            }
            else{
                sp++;
                st -=2;
            }
            System.out.println();
        }
        // pattern 2
        st = 1;
        sp = n/2;
        int k =1;
        for(int i = 1; i <= n; i++){

            //prints the number of spaces required on the line
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            //prints the number of stars required on the line
            for(int j = 1; j <= st; j++){
                System.out.print(k +"\t");
            }
            k++;
            if(i <= n/2){

                sp--;
                st +=2;
            }
            else{
                sp++;
                st -=2;
            }
            System.out.println();
        }

        //pattern 3
        st = 1;
        sp = n/2;
        k =1;
        for(int i = 1; i <= n; i++){

            //prints the number of spaces required on the line
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            //prints the number of stars required on the line
            int l = k;
            for(int j = 1; j <= st; j++){
                System.out.print(l +"\t");
                l++;
            }

            if(i <= n/2){
                k++;
                sp--;
                st +=2;
            }
            else{
                k--;
                sp++;
                st -=2;
            }
            System.out.println();
        }
        //pattern 4
        st = 1;
        sp = n/2;
        k =1;
        for(int i = 1; i <= n; i++){

            //prints the number of spaces required on the line
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            //prints the number of stars required on the line
            int l = k;
            for(int j = 1; j <= st; j++){
                System.out.print(l +"\t");
                if(j <= st/2)
                    l++;
                else
                    l--;
            }

            if(i <= n/2){
                k++;
                sp--;
                st +=2;
            }
            else{
                k--;
                sp++;
                st -=2;
            }
            System.out.println();
        }

    }
}
