package com.privat.ledCube;

public class LogiToPhysMapper {

    public static CubePoint mapLogiPhys(int x, int y, int z) {
        CubeConfig cubeConfig = CubeConfig.getInstance();
        CubePoint returnPoint = new CubePoint();

        returnPoint.setWarstwa(cubeConfig.getWarstwa(y));
        returnPoint.setKolumna(cubeConfig.getKolumna((x + z * CubeConfig.SIZE)));
        return returnPoint;
    }
}
