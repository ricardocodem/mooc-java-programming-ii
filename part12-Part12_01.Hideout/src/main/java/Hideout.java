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
public class Hideout<T> {

    private T hidden;

    public Hideout() {
    }

    public void putIntoHideout(T toHide) {
        this.hidden = toHide;
    }

    public T takeFromHideout() {
        if (this.hidden != null) {
            T take = this.hidden;
            this.hidden = null;
            return take;
        } else {
            return null;
        }
    }

    public boolean isInHideout() {
        return this.hidden != null;
    }

}
