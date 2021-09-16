/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Ricardo
 */
public class TemperatureSensor implements Sensor {

    private boolean isOn;

    public TemperatureSensor() {
        this.isOn = false;
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void setOn() {
        if (!isOn()) {
            isOn = true;
        }
    }

    @Override
    public void setOff() {
        if (isOn()) {
            isOn = false;
        }
    }

    @Override
    public int read() {
        if (!isOn) {
            throw new IllegalStateException("Check if the sensor is on");
        } else {
            int max = 30;
            int min = -30;
            return (int)Math.floor(Math.random() * (max - min + 1) + min);
        }
    }

}
