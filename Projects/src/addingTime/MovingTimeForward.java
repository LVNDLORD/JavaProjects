import java.util.Scanner;


public class MovingTimeForward {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the current hour (0-24): ");
        int currentHour = scanner.nextInt();
        System.out.print("Enter the current minute: ");
        int currentMinute = scanner.nextInt();
        System.out.print("Enter the current second: ");
        int currentSecond = scanner.nextInt();
        System.out.println();
        System.out.print("How many hours do you want to go forward (0-24): ");
        int forwardHour = scanner.nextInt();
        System.out.print("How many minutes do you want  to go forward: ");
        int forwardMinute = scanner.nextInt();
        System.out.print("How many seconds do you want  to go forward: ");
        int forwardSecond = scanner.nextInt();
        System.out.println();

        int answerHour, answerMinute, answerSecond;
        int carryMinute = 0, carryHour = 0;
        String sSecond, sMinute, sHour;
        boolean isNextDay = false;

        answerSecond = currentSecond + forwardSecond;
        if (answerSecond == 0) {
            sSecond = "00";
        } else if (answerSecond >= 60) {
            answerSecond -= 60;
            sSecond = "0" + (answerSecond);
            carryMinute = 1;
        } else {
            sSecond = String.valueOf(answerSecond);
        }

        answerMinute = currentMinute + forwardMinute + carryMinute;
        if (answerMinute >= 60) {
            answerMinute -= 60;
            sMinute = "0" + (answerMinute);
            carryHour = 1;
        } else {
            sMinute = String.valueOf(answerMinute);
        }

        answerHour = currentHour + forwardHour + carryHour;
        if (answerHour >= 24) {
            answerHour -= 24;
            sHour = "0" + (answerHour);
            isNextDay = true;
        } else {
            sHour = String.valueOf(answerHour);
        }

        if (isNextDay) {
            System.out.printf("The answer is %s:%s:%s on the next day.", sHour, sMinute, sSecond);
        } else {
            System.out.printf("The answer is %s:%s:%s.", sHour, sMinute, sSecond);
        }

    }
}
