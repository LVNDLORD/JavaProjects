package WordCounter;

import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type your paragraph: ");
        String userInput = scanner.nextLine();
        scanner.close();

        userInput = userInput.trim();
        int count = 0;

        // count the first word. It must exist before the first character. Must not be space
        count = userInput.isEmpty() ? 0 : count + 1;
        for (int i = 0; i < userInput.length(); i++){
            if (userInput.charAt(i) == ' ' && userInput.charAt(i + 1) != ' '){  // " ?"
                count++;
            }
        }
        System.out.println("Word count " + count);

    }

}
