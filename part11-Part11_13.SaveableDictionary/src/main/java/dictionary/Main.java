package dictionary;

public class Main {

    public static void main(String[] args) {
        // You can test your dictionary here
        SaveableDictionary dictionary = new SaveableDictionary("maga4.txt");
        boolean wasSuccessful = dictionary.load();

        if (wasSuccessful) {
            System.out.println("Successfully loaded the dictionary from file");
        }

       dictionary.add("ohjelmointi", "programming");

        boolean checkSave = dictionary.save();
        if (checkSave) {
            System.out.println("Saved");
        }
        System.out.println(dictionary.translate("ohjelmointi"));

    }
}
