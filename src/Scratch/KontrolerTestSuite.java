package ledCube;

import com.privat.ledCube.Kontroler;

import static org.junit.Assert.*;

//import org.junit.Assert;
import com.privat.ledCube.KontrolerEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class KontrolerTestSuite {
    private static final int SIZE = 4;
    private Kontroler kontroler;

    private byte booleanToByte(boolean value) {
        if (value) return 1;
        else return 0;
    }

    @Before
    public void init() {
        kontroler = new Kontroler(SIZE, 22);
    }

    @Test
    public void shouldNotSetBit() {
        //When & Then
        //
        assertFalse(kontroler.ustawDioda(-1, 3, 2, KontrolerEnum.JEDEN));
        assertFalse(kontroler.ustawDioda(0, -1, 2, KontrolerEnum.JEDEN));
        assertFalse(kontroler.ustawDioda(0, 1, -1, KontrolerEnum.JEDEN));
        assertFalse(kontroler.ustawDioda(SIZE , SIZE /2, SIZE , KontrolerEnum.JEDEN));
    }

    @Test
    public void shouldSetBit() {
        //Given
        Random generator = new Random();
        //When & Then
        assertTrue(kontroler.ustawDioda(0, 0, 0, KontrolerEnum.JEDEN));
        assertTrue(kontroler.ustawDioda(SIZE -1 , (SIZE / 2) - 1, SIZE - 1, KontrolerEnum.JEDEN));
        for (int i = 0; i < SIZE; i++) {
            System.out.println("i:" + i);
            assertTrue(kontroler.ustawDioda(generator.nextInt(SIZE), generator.nextInt(SIZE) / 2, generator.nextInt(SIZE), KontrolerEnum.JEDEN));
        }
    }

/*    @Test
    public void bitSetTest() {
        //Given
        Random genetrator = new Random();
        byte[] testArray = new byte[SIZE];

        //When
        for (int i = 0; i < SIZE; i++) {
            testArray[i] = booleanToByte(genetrator.nextBoolean());
            System.out.format("i:%d, Array value:%d\n", i, testArray[i]);
            kontroler.ustawBit((byte) i, Kontroler.byteToEnumStan(testArray[i]));
        }
        kontroler.wyślij();
        //Then
        assertArrayEquals(testArray, kontroler.getBity());
    }
*/
}
