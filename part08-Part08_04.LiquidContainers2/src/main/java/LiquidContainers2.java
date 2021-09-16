
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container firstContainer = new Container();
        Container secondContainer = new Container();

        while (true) {
            System.out.println("First: " + firstContainer.contains() + "/100");
            System.out.println("Second: " + secondContainer.contains() + "/100");
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equalsIgnoreCase("add")) {
                firstContainer.add(amount);
            }

            if (command.equalsIgnoreCase("move")) {
                if (amount > firstContainer.contains()) {
                    secondContainer.add(firstContainer.contains());
                    firstContainer.remove(firstContainer.contains());
                } else {
                    secondContainer.add(amount);
                    firstContainer.remove(amount);
                }
            }

            if (command.equalsIgnoreCase("remove")) {
                secondContainer.remove(amount);
            }
        }
    }

}
