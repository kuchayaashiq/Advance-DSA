import java.util.*;
public class LeapYear {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Year for checking");
        int year = sc.nextInt();
        if (year % 400 == 0)
            System.out.println("YES");
        else if (year % 4 == 0 && year % 100 !=0 ) {

            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
