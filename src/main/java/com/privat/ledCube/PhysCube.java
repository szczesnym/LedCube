package com.privat.ledCube;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

import java.util.HashSet;
import java.util.Set;

public class PhysCube {
    private CubeConfig cubeConfig;
    private Set<GpioPinDigitalOutput> doZpalaenia;
    private static PhysCube instance;

    public static PhysCube getInstance() {
        if(instance == null){
            instance = new PhysCube();
        }
        return instance;
    }

    private PhysCube() {
        cubeConfig = CubeConfig.getInstance();
        doZpalaenia = new HashSet<>();
    }

    public void zapal(GpioPinDigitalOutput...pins) {
        for(int i = 0; i <pins.length; i++)
            doZpalaenia.add(pins[i]);
    }

    public void wyczysc() {
        doZpalaenia.clear();
    }

    public void execute() {
        doZpalaenia.forEach(gpioPin -> gpioPin.high());
    }

    public void showPhysCube() {
        doZpalaenia.stream()
                .filter(gpioPin -> gpioPin.getState() == PinState.HIGH)
                .forEach(gpioPin -> System.out.println(gpioPin));
        }

}
