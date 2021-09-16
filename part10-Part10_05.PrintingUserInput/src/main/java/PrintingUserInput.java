
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        while (true) {
            String read = scanner.nextLine();
            if (read.equalsIgnoreCase("")) {
                break;
            }
            input.add(read);
        }
        String reading;
        reading = input.stream()
                .reduce("", (previousString, word) -> previousString + word + "\n");
        System.out.println(reading);
        /* input.stream().forEach(s -> System.out.println(s));*/
    }
}
