
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomNum = new Random();

        System.out.println("How many random numbers should be printed?");
        int howMany = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < howMany; i++) {
            System.out.println(randomNum.nextInt(11));
        }
    }

}
