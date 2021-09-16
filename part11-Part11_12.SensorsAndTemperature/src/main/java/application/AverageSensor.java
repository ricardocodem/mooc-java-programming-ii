/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    private List<Integer> listRead;

    public AverageSensor() {
        this.sensors = new ArrayList();
        this.listRead = new ArrayList();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        boolean isOn = false;
        for (Sensor s : sensors) {
            if (s.isOn() == true) {
                isOn = true;
            } else {
                isOn = false;
                break;
            }
        }
        return isOn;
    }

    @Override
    public void setOn() {
        for (Sensor s : sensors) {
            s.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor s : sensors) {
            s.setOff();
        }
    }

    @Override
    public int read() {
        if (!isOn() || sensors.isEmpty()) {
            throw new IllegalStateException("Sensor(s) must be online");
        } else {
            double average = sensors.stream()
                    .mapToInt(s -> s.read())
                    .average()
                    .getAsDouble();
            this.listRead.add((int) average);
            return (int) average;
        }
    }

    public List<Integer> readings() {
        return this.listRead;
    }

}
