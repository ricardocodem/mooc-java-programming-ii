
import java.text.MessageFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ricardo
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private final ChangeHistory changeHistory;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.changeHistory = new ChangeHistory();
        setInitialBalance(initialBalance);
    }

    public final void setInitialBalance(double initialBalance) {
        changeHistory.add(initialBalance);
        super.addToWarehouse(initialBalance);
    }

    public String history() {
        return this.changeHistory.toString();
    }

    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.changeHistory.add(super.getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double takeFromWarehouse = super.takeFromWarehouse(amount);
        this.changeHistory.add(super.getBalance());
        return takeFromWarehouse;
    }

    public void printAnalysis() {
        System.out.println(
                MessageFormat.format("Product: {0}\nHistory: {1}\nLargest amount of product: {2}\nSmallest amount of product: {3}\nAverage: {4}",
                        super.getName(),
                        this.changeHistory,
                        this.changeHistory.maxValue(),
                        this.changeHistory.minValue(),
                        this.changeHistory.average())
        );
    }

}
