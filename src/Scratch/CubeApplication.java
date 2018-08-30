package com.privat.ledCube;

import java.util.Random;

public class CubeApplication {

    public static void main(String[] args) {

        Kostka kostka = new Kostka(2);
        Random genetartor = new Random();
        kostka.czysc();
        for(int i=0; i <= 3; i++) {
            int x = genetartor.nextInt(2);
            int y = genetartor.nextInt(2);
            int z = genetartor.nextInt(2);
            System.out.format("PETLA;x:%d,y:%d,z:%d, result:%s\n",x, y, z, kostka.dioda(x, y, z, KontrolerEnum.JEDEN));
            //kostka.dioda(x, y, z, KontrolerEnum.JEDEN);
        }
       kostka.showDiody();
        kostka.ustawKontrolery();
        kostka.getKontrolery().forEach(kontroler -> kontroler.showKostka());
    }
}
