/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricardo
 */
public class Book implements Packable {

    private final String author;
    private final String bookName;
    private final double weight;

    public Book(String author, String name, double weight) {
        this.author = author;
        this.bookName = name;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.author + ": " + this.bookName;
    }

}
