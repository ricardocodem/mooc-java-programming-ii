
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ricardo
 */
public class ShoppingCart {

    private Map<String, Item> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void add(String product, int price) {
        this.cart.putIfAbsent(product, new Item(product, 0, price));
        this.cart.get(product).increaseQuantity();
    }

    public int price() {
        int total = 0;
        for (Item price : cart.values()) {
            total += price.price();
        }
        return total;
    }

    public void print() {
        String print = "";
        for (Item item : cart.values()) {
            print += item + "\n";
        }
        System.out.println(print);
    }
}
