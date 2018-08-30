package com.privat.ledCube;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class CubePoint {
    public GpioPinDigitalOutput warstwa;
    public GpioPinDigitalOutput kolumna;

}
