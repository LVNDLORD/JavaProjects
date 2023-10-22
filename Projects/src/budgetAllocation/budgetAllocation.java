import java.util.Scanner;
import java.util.ArrayList;

public class budgetAllocation {

    public static void main(String[] args) {
        System.out.println("How much can you spend?");
        Scanner scan = new Scanner(System.in);

        double total = scan.nextDouble();
        double sum = 0;
        int i = 0;
        ArrayList<Double> proportion = new ArrayList<Double>();

        System.out.println("Enter the proportion of various expenses");
        System.out.println("The system stops if cumulative proportions exceed 100%");

        do {
            System.out.println("Your proportion of expense " + (i + 1) + " in percents:");
            double value = scan.nextDouble();
            proportion.add(value);
            sum += proportion.get(i); // ArrayList get by index
            i++;

        } while (sum <= 100);
        scan.close();

        if (sum > 100) {
            double cumulativeSum = 0.0;
            for (int j = 0; j < proportion.size() - 1; j++) {
                cumulativeSum += proportion.get(j);
            }
            proportion.set(proportion.size() - 1, 100.0 - cumulativeSum);
            System.out.println(proportion);
        }
        for (double value : proportion) { // proportion here is a ref var to an arrayList object
            // value is a proportion stored in arraylist
            double expense = value * total / 100.0;
            System.out.println("Your " + value + "% of total expences equals to " + expense + "€");

        }
    }
}
