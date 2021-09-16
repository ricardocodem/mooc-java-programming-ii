
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ricardo
 */
public class TodoList {

    private List<String> task;

    public TodoList() {
        this.task = new ArrayList<>();
    }

    public void add(String task) {
        this.task.add(task);
    }

    public void print() {
        for (int i = 0; i < this.task.size(); i++) {
            System.out.println(i + 1 + ": " + this.task.get(i));
        }
    }

    public void remove(int number) {
        this.task.remove(number - 1);
    }
}
