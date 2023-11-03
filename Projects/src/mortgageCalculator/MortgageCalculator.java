// https://www.wikihow.com/Calculate-Mortgage-Payments

import java.util.Scanner;
import java.text.NumberFormat;

public class MortgageCalculator {

    private static double calculateMonthlyMortgage(int principal, double annualInterest, byte years) {
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;
        double monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numOfMonthlyPayments = years * MONTHS_IN_YEAR;
        return principal *
                ((monthlyInterest * Math.pow(1 + monthlyInterest, numOfMonthlyPayments)) /
                        (Math.pow(1 + monthlyInterest, numOfMonthlyPayments) - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Amount of loan: ");
        int principal = Integer.parseInt(scanner.nextLine());
        System.out.print("Annual interest rate: ");
        double annualInterest = Double.parseDouble(scanner.nextLine());
        System.out.print("Period (Years): ");
        byte years = Byte.parseByte(scanner.nextLine());

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(calculateMonthlyMortgage(principal, annualInterest, years));
        System.out.printf("Monthly mortgage: %s", result);
    }
}
