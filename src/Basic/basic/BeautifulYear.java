package basic;

import java.util.Scanner;

public class BeautifulYear {
    /*
    BEAUTIFUL YEAR means the year that has distinct digits present.  e.g 1987 & 2013
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any year ");
        int year = sc.nextInt();
        System.out.print("Beautiful year present after "+year+ " is :");
        int l =0;
        while(l>=0){
            year +=1;
            String str = Integer.toString(year);
            int count =0;
            for(int i =0;i<str.length();i++){
                for (int j = i+1; j < str.length(); j++) {
                    if(str.charAt(i) == str.charAt(j))
                        count++;

                }
            }

            if(count==0) {
                System.out.print((int)year);
                break;
            }

        }


    }
}
