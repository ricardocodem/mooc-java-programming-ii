
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ricardo
 * @param <T>
 */
public class Pipe<T> {

    private final ArrayList<T> value;

    public Pipe() {
        this.value = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        this.value.add(value);
    }

    public T takeFromPipe() {
        if (this.value.isEmpty()) {
            return null;
        } else {
            return this.value.remove(0);
        }
    }

    public boolean isInPipe() {
        return !this.value.isEmpty();
    }
}
