
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ricardo
 */
public class ChangeHistory {

    private final ArrayList<Double> inventoryHistory;

    public ChangeHistory() {
        this.inventoryHistory = new ArrayList<>();
    }

    public void add(double status) {
        this.inventoryHistory.add(status);
    }

    public double maxValue() {
        if (this.inventoryHistory.isEmpty()) {
            return 0;
        } else {
            return Collections.max(this.inventoryHistory);
        }
    }

    public double minValue() {
        if (this.inventoryHistory.isEmpty()) {
            return 0;
        } else {
            return Collections.min(inventoryHistory);
        }
    }

    public double average() {
        if (this.inventoryHistory.isEmpty()) {
            return 0;
        } else {
            double sum = 0;
            for (Double inventory : this.inventoryHistory) {
                sum += inventory;
            }
            return sum / this.inventoryHistory.size();
        }
    }

    public void clear() {
        this.inventoryHistory.clear();
    }

    @Override
    public String toString() {
        return this.inventoryHistory.toString();
    }
}
