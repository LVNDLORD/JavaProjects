import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        final int MIN_AMOUNT = 1000;
        final int MAX_AMOUNT = 1_000_000;
        final double MIN_INTEREST = 0.0;
        final double MAX_INTEREST = 30.0;
        final int MIN_YEARS = 1;
        final int MAX_YEARS = 30;

        Scanner scanner = new Scanner(System.in);

        int principal = (int) readNumber(scanner, "Amount of loan ($1K - $1M): ", MIN_AMOUNT, MAX_AMOUNT);
        double annualInterest = readNumber(scanner, "Annual Interest Rate: ", MIN_INTEREST, MAX_INTEREST);
        byte years = (byte) readNumber(scanner, "Period (Years): ", MIN_YEARS, MAX_YEARS);

        scanner.close();

        double monthlyPayment = calculateMonthlyMortgage(principal, annualInterest, years);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String formattedPayment = currency.format(monthlyPayment);
        System.out.printf("Monthly mortgage: %s", formattedPayment);
    }

    public static double readNumber(Scanner scanner, String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value >= min && value <= max) {
                    break;
                } else {
                    System.out.println("Value must be between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); //  consume and discard the invalid input entered by the user
            }
        }
        return value;
    }

    public static double calculateMonthlyMortgage(int principal, double annualInterest, byte years) {
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;
        double monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numOfMonthlyPayments = years * MONTHS_IN_YEAR;
        return principal *
                ((monthlyInterest * Math.pow(1 + monthlyInterest, numOfMonthlyPayments)) /
                        (Math.pow(1 + monthlyInterest, numOfMonthlyPayments) - 1));
    }
}
