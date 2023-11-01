import java.util.Scanner;

public class StudentSelectionForVaccination {

    public static void main(String[] args) {

        final int vaccinationAge = 15;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = Integer.parseInt(scanner.nextLine());

        String[] student = new String[numStudents];
        int[] age = new int[numStudents];
        Scanner scannerName = new Scanner(System.in);
        Scanner scannerAge = new Scanner(System.in);

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student's name: ");
            student[i] = scannerName.nextLine();

            System.out.printf("Enter %s's age: ", student[i]);
            age[i] = Integer.parseInt(scannerAge.nextLine());
            System.out.println();
        }

        for (int i = 0; i < numStudents; i++) {
            if(age[i] >= vaccinationAge) {
                System.out.printf("%s can receive a vaccine. ", student[i]);
                System.out.printf("The student is now %s.%n", age[i]);
            }
        }
        scanner.close();
        scannerName.close();
        scannerAge.close();
    }

}
