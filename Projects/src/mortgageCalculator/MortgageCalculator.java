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
        final int MIN_AMOUNT = 1000;
        final int MAX_AMOUNT = 1_000_000;
        final double MIN_INTEREST = 0.0;
        final double MAX_INTEREST = 30.0;
        final int MIN_YEARS = 1;
        final int MAX_YEARS = 30;
        int principal = 0;
        double annualInterest = 0.0;
        byte years = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Amount of loan ($1K - $1M): ");
            principal = Integer.parseInt(scanner.nextLine());
            if (principal >= MIN_AMOUNT && principal <= MAX_AMOUNT) {
                break;
            }
            System.out.printf("Enter a number between %s and %s%n", MIN_AMOUNT, MAX_AMOUNT);

        }

        while (true) {
            System.out.print("Annual interest rate: ");
            annualInterest = Double.parseDouble(scanner.nextLine());
            if (annualInterest > MIN_INTEREST && annualInterest <= MAX_INTEREST) {
                break;
            }
            System.out.printf("Enter a value greater than %s and less than or equal to %s.%n", MIN_INTEREST, MAX_INTEREST);

        }

        while (true) {
            System.out.print("Period (Years): ");
            years = Byte.parseByte(scanner.nextLine());
            if (years >= MIN_YEARS && years <= MAX_YEARS) {
                break;
            }
            System.out.printf("Enter a value between %s and %s.%n", MIN_YEARS, MAX_YEARS);
        }
        scanner.close();

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(calculateMonthlyMortgage(principal, annualInterest, years));
        System.out.printf("Monthly mortgage: %s", result);
    }
}
