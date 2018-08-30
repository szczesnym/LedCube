package com.privat.ledCube;

import com.pi4j.io.gpio.*;

import java.util.ArrayList;
import java.util.List;


public class CubeConfig {
    public static int SIZE = 4;
    private static CubeConfig instance;
    private final List<GpioPinDigitalOutput> warstwy;
    private final List<GpioPinDigitalOutput> kolumny;
    private final GpioController gpioController;

    public GpioPinDigitalOutput getWarstwa(int warstwa) {
        if (warstwa >= 0 && warstwa < SIZE) {
            return warstwy.get(warstwa);
        } else {
            return null;
        }
    }

    public GpioPinDigitalOutput getKolumna(int kolumna) {
        if (kolumna >= 0 && kolumna < SIZE * SIZE) {
            return kolumny.get(kolumna);
        } else {
            return null;
        }
    }

        public static CubeConfig getInstance () {
            if (instance == null) {
                instance = new CubeConfig();
            }
            return instance;
        }

    private CubeConfig() {
            super();
            warstwy = new ArrayList<>();
            kolumny = new ArrayList<>();
            gpioController = GpioFactory.getInstance();
        /*
        połączenie kolumny d o piny :
        podłączenie warstwy do piny :
         */
            warstwy.add(0, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.HIGH));
            warstwy.add(1, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.HIGH));
            warstwy.add(2, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.HIGH));
            warstwy.add(3, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.HIGH));

            kolumny.add(0, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW));
            kolumny.add(1, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.LOW));
            kolumny.add(2, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_06, PinState.LOW));
            kolumny.add(3, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.LOW));
            kolumny.add(4, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_08, PinState.LOW));
            kolumny.add(5, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_09, PinState.LOW));
            kolumny.add(6, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_10, PinState.LOW));
            kolumny.add(7, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_11, PinState.LOW));
            kolumny.add(8, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_12, PinState.LOW));
            kolumny.add(9, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_13, PinState.LOW));
            kolumny.add(10, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_14, PinState.LOW));
            kolumny.add(11, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_15, PinState.LOW));
            kolumny.add(12, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_16, PinState.LOW));
            kolumny.add(13, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_17, PinState.LOW));
            kolumny.add(14, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_18, PinState.LOW));
            kolumny.add(15, gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_19, PinState.LOW));
        }
    }
