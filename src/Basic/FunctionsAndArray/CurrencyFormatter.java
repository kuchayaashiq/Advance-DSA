package FunctionsAndArray;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
   /*

        Sample Input
        12324.134

        Sample Output
        US: $12,324.13
        India: Rs.12,324.13
        China: ￥12,324.13
        France: 12 324,13 €
    */
public class CurrencyFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        Locale locale1 = Locale.US;
        NumberFormat nf1 = NumberFormat.getCurrencyInstance(locale1);
        String us = nf1.format(payment);


        // Indian Currency is not defined in Locale class, so we explicitly define
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String india = nf.format(payment);


        Locale locale2 = Locale.CHINA;
        NumberFormat nf2 = NumberFormat.getCurrencyInstance(locale2);
        String china = nf2.format(payment);

        Locale locale3 = Locale.FRANCE;
        NumberFormat nf3 = NumberFormat.getCurrencyInstance(locale3);
        String france = nf3.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
