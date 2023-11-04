import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;

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
        System.out.println("\nMORTGAGE\n--------");
        System.out.printf("Monthly Payments: %s%n", formattedPayment);
        System.out.printf("In total you will have %s payments\n", calcNumOfMonthlyPayments(years));

        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        for (short month = 1; month < calcNumOfMonthlyPayments(years); month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
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

    public static int calcNumOfMonthlyPayments(byte years) {
        return years * MONTHS_IN_YEAR;
    }

    public static double calcMonthlyInterest(double annualInterest) {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    public static double calculateMonthlyMortgage(int principal, double annualInterest, byte years) {
        double monthlyInterest = calcMonthlyInterest(annualInterest);
        int numOfMonthlyPayments = calcNumOfMonthlyPayments(years);

        return principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numOfMonthlyPayments))
                / (Math.pow(1 + monthlyInterest, numOfMonthlyPayments) - 1));
    }

    public static double calculateBalance(int principal, double annualInterest, byte years, short numOfPaymentsMade) {
        double monthlyInterest = calcMonthlyInterest(annualInterest);
        int numOfMonthlyPayments = calcNumOfMonthlyPayments(years);

        return principal * ((Math.pow(1 + monthlyInterest, numOfMonthlyPayments)
                - Math.pow(1 + monthlyInterest, numOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numOfMonthlyPayments) - 1));

    }
}
