package com.privat.ledCube;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

import java.util.HashSet;
import java.util.Set;

public class PhysCube {
    private CubeConfig cubeConfig;
    private Set<GpioPinDigitalOutput> doZpalaenia;
    private Set<GpioPinDigitalOutput> doZgaszenia;
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
        doZgaszenia = new HashSet<>();
    }

    public void zapal(GpioPinDigitalOutput pinKolumna, GpioPinDigitalOutput pinWarstwa) {
        doZpalaenia.add(pinKolumna);
        doZgaszenia.add(pinWarstwa);
    }

    public void wyczysc() {
        doZpalaenia.clear();
        doZgaszenia.clear();
    }

    public void execute() {
        doZpalaenia.forEach(gpioPin -> gpioPin.low());
        doZgaszenia.forEach(gpioPin -> gpioPin.high());
    }

    public void showPhysCube() {
        doZpalaenia.forEach(gpioPin -> System.out.println(gpioPin + "STAN:" + gpioPin.getState()));
        doZgaszenia.forEach(gpioPin -> System.out.println(gpioPin + "STAN:" + gpioPin.getState()));
        }

}
