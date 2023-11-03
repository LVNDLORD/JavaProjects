import java.util.Scanner;

public class VehicleInsurance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int premium = 0;

        System.out.print("Enter your vehicle type (car, truck, bus, motorcycle): ");
        String vehicleType = scanner.nextLine();

        switch (vehicleType) {
            case "car" -> premium = 200;
            case "truck" -> premium = 300;
            case "bus" -> premium = 400;
            case "motorcycle" -> {
                System.out.println("Enter your motorcycle type by engine size in cc.");
                System.out.println("1 -> (50-300 cc), 2 -> (301-500 cc), 3 -> (500+ cc)");
                int motorcycleType = scanner.nextInt();
                switch (motorcycleType) {
                    case 1 -> premium = 300;
                    case 2 -> premium = 400;
                    case 3 -> premium = 500;
                    default -> System.out.println("Unknown motorcycle type");
                }
            }
            default -> System.out.println("Unknown vehicle type");
        }
        scanner.close();
        System.out.printf("The premium is $%s", premium);

    }
}
