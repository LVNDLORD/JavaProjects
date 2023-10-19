import java.util.Scanner;
import java.text.*;

public class Driver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // creating a scanner object, with var scan. System in - standard input
        System.out.print("Enter the buying price per share: ");
        double buyingPrice = scan.nextDouble();
        System.out.print("Enter the amount of shares purchased: ");
        int sharesNumber = scan.nextInt();
        int day = 1;
        double closingPrice = 0.01;
        DecimalFormat df = new DecimalFormat("0.00");

        while (true) {
            System.out.println("Enter the closing price for a day "
                    + day + " (or any negative value to leave): "  );
            closingPrice = scan.nextDouble();
            if (closingPrice < 0.0) break;
            double earningsPerShare = closingPrice - buyingPrice;
            double totalProfit = earningsPerShare * sharesNumber;
            if (earningsPerShare > 0) {
                System.out.println("After day " + day + ", you have earned "
                        + df.format(earningsPerShare) + " per share. Total profit for " + sharesNumber
                        + "share/s is " + df.format(totalProfit));
            }
            else if (earningsPerShare < 0.0) {
                System.out.println("After day " + day + ", you have lost "
                        + df.format(-earningsPerShare) + " per share. Total loss for " + sharesNumber
                        + "share/s is " + df.format(totalProfit));
            }
            else {
                System.out.println("After day " + day + ", share price has not changed.");
            }
            day++;
        }
        scan.close();
    }
}