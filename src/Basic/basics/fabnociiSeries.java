package basic;

import java.util.Scanner;

public class fabnociiSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f1 =0, f2 =1,f3, count =1;
        int lastNum = 0;
        while(count <= n){
            f3 = f1+f2;
            //System.out.print(f3+" ");
            if(count==n-1)
                lastNum =f3;
            f1=f2;
            f2=f3;
            count++;
        }

        // print last two digits  of Last fabinocii number in two digit form
        System.out.println(lastNum);
        String str = String.valueOf(lastNum);
        System.out.println(str);
        if(str.length() ==1){
            System.out.print("0"+lastNum);
        }
        else if (str.length()>1 && str.length()<2){
            System.out.print(lastNum);
        }
        else {
            System.out.println(str.substring(str.length() - 2));
        }
    }
}
