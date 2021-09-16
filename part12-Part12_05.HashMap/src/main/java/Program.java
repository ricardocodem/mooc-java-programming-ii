
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // You can test the class here
        Pair<String, Integer> pair = new Pair<>("one", 1);
        System.out.println(pair.getKey() + " -> " + pair.getValue());
        
        HashMap<String, Integer> map = new HashMap<>();
        map.add("teste", 1);
        System.out.println(map.get("teste"));
        map.add("teste2", 2);
        System.out.println(map.get("teste2"));
        map.remove("teste1");
        System.out.println(map.get("teste1"));
    }

}
