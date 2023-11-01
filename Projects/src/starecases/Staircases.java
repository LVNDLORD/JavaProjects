public class Staircases {

    public static void main(String[] args) {
        int numSteps = 5;
        int stepWidth = 3;
        for (int i = 0; i < numSteps; i++) {
            for(int j = 0; j < (i + 1) * stepWidth; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
