/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ricardo
 */
public class SaveableDictionary {

    private Map<String, String> words;
    private File file;

    public SaveableDictionary() {
        this.words = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.file = new File(file);
    }

    public void add(String words, String translation) {
        this.words.putIfAbsent(words, translation);
    }

    public String translate(String word) {
        for (String s : this.words.keySet()) {
            if (this.words.get(s).equals(word)) {
                return s;
            } else if (this.words.get(word) != null) {
                return this.words.get(word);
            }
        }
        return null;
    }

    public void delete(String word) {
        String translation = translate(word);
        this.words.remove(word);
        this.words.remove(translation);
    }

    public boolean load() {

        try {
            Files.lines(Paths.get(this.file.getName()))
                    .map(row -> row.split(":"))
                    .forEach(parts -> this.words.put(parts[0], parts[1]));
            return true;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean save() {
        try (PrintWriter writer = new PrintWriter(this.file.getName())) {
            for (String s : this.words.keySet()) {
                String word = s;
                String translation = this.words.get(s);
                writer.println(word + ":" + translation);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }

}
