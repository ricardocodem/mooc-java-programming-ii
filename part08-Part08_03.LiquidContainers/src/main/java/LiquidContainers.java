
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstContainer = 0;
        int secondContainer = 0;

        while (true) {
            System.out.println("First: " + firstContainer + "/100");
            System.out.println("Second: " + secondContainer + "/100");
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            //split string into parts string for command and a int for liquid amount
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            //task for command processing
            if (command.equalsIgnoreCase("add") && amount > 0) {
                firstContainer += amount;
                if (firstContainer > 100) {
                    firstContainer = 100;
                }
            }
            if (command.equalsIgnoreCase("move") && amount > 0) {
                if (amount > firstContainer) {
                    secondContainer += firstContainer;
                    firstContainer = 0;
                } else {
                    secondContainer += amount;
                    firstContainer -= amount;
                }
                if (secondContainer > 100) {
                    secondContainer = 100;
                }
            }
            if (command.equalsIgnoreCase("remove")) {
                secondContainer -= amount;
                if (secondContainer < 0) {
                    secondContainer = 0;
                }
            }

        }

    }
}
