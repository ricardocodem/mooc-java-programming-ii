
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ricardo
 */
public class Warehouse {

    private final Map<String, Integer> priceControl;
    private final Map<String, Integer> stockControl;

    public Warehouse() {
        this.priceControl = new HashMap<>();
        this.stockControl = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.priceControl.put(product, price);
        this.stockControl.put(product, stock);
    }

    public int price(String product) {
        if (priceControl.containsKey(product)) {
            return priceControl.get(product);
        } else {
            return -99;
        }
    }

    public int stock(String product) {
        if (stockControl.containsKey(product)) {
            return stockControl.get(product);
        } else {
            return 0;
        }
    }

    public boolean take(String product) {
        if (stock(product) > 0) {
            int decrease = stockControl.get(product) - 1;
            stockControl.put(product, decrease);
            return true;
        } else {
            return false;
        }
    }

    public Set<String> products() {
        Set<String> names = new HashSet<>();
        for (String list : stockControl.keySet()) {
            names.add(list);
        }
        return names;
    }

}
