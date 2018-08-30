package com.privat.ledCube;


public class Kontroler {
    private final int SIZE;
    private final int GPIOPinSterowanie;
    private final int[] GPIOPinZerowanie;
    private byte[] bity;
    private KontrolerEnum[][][] diody;

    public Kontroler(int SIZE, int GPIOPin, int[] GPIOZerowanie) {
        this.SIZE = SIZE - 1;
        this.GPIOPinSterowanie = GPIOPin;
        this.GPIOPinZerowanie = GPIOZerowanie;
        bity = new byte[SIZE];
        diody = new KontrolerEnum[SIZE][SIZE / 2][SIZE];
        zerujDiody();
    }

    public Kontroler(int SIZE, int GPIOPin) {
        this.SIZE = SIZE ;
        this.GPIOPinSterowanie = GPIOPin;
        this.GPIOPinZerowanie = new int[4];
        bity = new byte[SIZE];
        diody = new KontrolerEnum[SIZE][SIZE / 2][SIZE];
        zerujDiody();;
    }

    public static int enumStanToByte(KontrolerEnum kontrolerEnum) {
        if (kontrolerEnum == KontrolerEnum.JEDEN) return 1;
        else return 0;
    }

    public static KontrolerEnum byteToEnumStan(byte stan) {
        if (stan == 1) return KontrolerEnum.JEDEN;
        else return KontrolerEnum.ZERO;
    }

    public byte[] getBity() {
        return bity;
    }

    private byte stanToByte(KontrolerEnum stan) {
        if (stan == KontrolerEnum.ZERO) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean ustawDioda(int x, int y, int z, KontrolerEnum stan) {
        //System.out.format("x:%d, y:%d, z:%d, stan:%s\n", x, y, z, stan);
        if (x < 0 || y < 0 || z < 0 || x >= SIZE || y >= SIZE / 2 || z >= SIZE) return false;
        else {
            diody[x][y][z] = stan;
            return true;
        }
    }

    private boolean ustawBit(byte bit, KontrolerEnum stan) {
        if (bit > SIZE || bit < 0) {
            return false;
        } else {
            bity[bit] = stanToByte(stan);
            return true;
        }
    }

    public void zerujBit() {
        for (int i = 0; i < SIZE; i++) bity[i] = 0;
    }

    public void zerujDiody() {
        for (int x = 0; x < SIZE; x++)
            for (int y = 0; y < SIZE / 2 ; y++)
                for (int z = 0; z < SIZE; z++)
                    diody[x][y][z] = KontrolerEnum.ZERO;
    }

    public void wyślij() {
        for (byte b : bity) {
            System.out.print(b);
        }
        System.out.println();
    }


    public void showKostka() {
        for (int z = 0; z < SIZE; z++) {
            System.out.println("Plaster z:"+z);
            for (int y = 0; y < SIZE / 2; y++) {
                for (int x = 0; x < SIZE; x++) {
                    System.out.print("|" + stanToByte(diody[x][y][z]));
                }
                System.out.println();
            }
        }

    }
}
