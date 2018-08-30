package com.privat.ledCube;


public class LogiCube {
    private static int SIZE = 4;
    private int[][][] diody;
    private PhysCube physCube = PhysCube.getInstance();
    private LogiToPhysMapper logiToPhysMapper;

    public LogiCube() {
        diody = new int[SIZE][SIZE][SIZE];
        wyczysc();
    }

    private boolean sprawdzZakres(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0 || x >= SIZE || y >= SIZE || z >= SIZE) {
            return false;
        } else {
            return true;
        }
    }

    public boolean zapal(int x, int y, int z) {
        if( sprawdzZakres(x,y,z) ) {
            diody[x][y][z] = 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean zgas(int x, int y, int z) {
            if(sprawdzZakres(x, y, z)) {
                diody[x][y][z] = 0;
                return true;
            } else {
                return false;
            }
        }

    public void wyczysc() {
        for (int x = 0; x < SIZE; x++)
            for (int y = 0; y < SIZE; y++)
                for (int z = 0; z < SIZE; z++)
                    diody[x][y][z] = 0;
    }

    public void wykonaj() {
        physCube.wyczysc();
        for (int x = 0; x < SIZE; x++)
            for (int y = 0; y < SIZE; y++)
                for (int z = 0; z < SIZE; z++)
                {
                    if(diody[x][y][z] == 1) {
                        physCube.zapal(LogiToPhysMapper.mapLogiPhys(x, y, z ).getKolumna(), LogiToPhysMapper.mapLogiPhys(x, y, z ).getWarstwa());
                    }
                }
       // physCube.execute();
        physCube.showPhysCube();
    }
}
