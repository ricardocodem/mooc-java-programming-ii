
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        List<Integer> row = new ArrayList<>();
        System.out.println("Input numbers, type \"00\" to stop");
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == 00) {
                break;
            }
            row.add(input);
        }
        System.out.println(positive(row));
    }

    public static List<Integer> positive(List<Integer> numbers) {
        ArrayList<Integer> values = numbers.stream().filter(value -> value > 0)
                .collect(Collectors.toCollection(ArrayList::new));
        return values;
        //fastest way: return numbers.stream().filter(number -> number > 0).collect(Collectors.toList());
    }

}
