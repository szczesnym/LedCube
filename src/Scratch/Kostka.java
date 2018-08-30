package com.privat.ledCube;

import java.util.ArrayList;
import java.util.List;

public class Kostka {
    private final int SIZE;
    private final List<Kontroler> kontrolery;
    private KontrolerEnum[][][] diody;

    public void showDiody() {
        for (int x = 0; x < SIZE; x++)
            for (int y = 0; y < SIZE; y++)
                for (int z = 0; z < SIZE; z++)
                    System.out.format("x:%d, y:%d, z:%d, stan:%s\n", x, y, z, diody[x][y][z]);
    }

    public List<Kontroler> getKontrolery() {
        return kontrolery;
    }

    public Kostka(int rozmiar) {
        this.SIZE = rozmiar;
        this.diody = new KontrolerEnum[SIZE][SIZE][SIZE];
        /****************************************************
         PODLACCZENIE PINOW GPIO DO KONTROLEROW

         KONTROLER 1 PIN 22
         KONTROLER 2 PIN 23
         Kontroler 1 ma podłączone kolumny 1, 2, 3, 4, 5, 6, 7, 8
         Kontroler 2 ma podłączone kolumny 9, 10, 11, 12, 13, 14, 15, 16

         WARSTWY PODLACZONE DO PINOW
         WARSTWA 1 -> 5
         WARSTWA 2 -> 6
         WARSTWA 3 -> 13
         WARSTWA 4 -> 19
         ****************************************************/

        Kontroler kontroler1 = new Kontroler(4, 22, new int[]{5, 6, 13, 19});
        Kontroler kontroler2 = new Kontroler(4, 23, new int[]{5, 6, 13, 19});
        kontrolery = new ArrayList<>();
        kontrolery.add(kontroler1);
        kontrolery.add(kontroler2);
    }

    public boolean dioda(int x, int y, int z, KontrolerEnum stan) {
        if (x < 0 || y < 0 || z < 0 || x > SIZE || y > SIZE || x > SIZE) return false;
        else {
            this.diody[x][y][z] = stan;
            return true;
        }
    }

    public void czysc() {
        for (int x = 0; x < SIZE; x++)
            for (int y = 0; y < SIZE; y++)
                for (int z = 0; z < SIZE; z++)
                    diody[x][y][z] = KontrolerEnum.ZERO;
    }

    public void ustawKontrolery() {
        kontrolery.forEach(kontroler -> kontroler.zerujDiody());
        for (int x = 0; x < SIZE; x++)
            for (int y = 0; y < SIZE; y++)
                for (int z = 0; z < SIZE; z++) {
                    if(y <= SIZE) {
                        kontrolery.get(0).ustawDioda(x, y, z, diody[x][y][z]);
                    }
                    else {
                        kontrolery.get(1).ustawDioda(x, y, z, diody[x][y][z]);
                    }
        }
    }
}
