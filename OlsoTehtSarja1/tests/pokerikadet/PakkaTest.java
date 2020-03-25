package pokerikadet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 *
 * @author Auvo Häkkinen, 2.2.2013. Muutos 20.8.2019: JUnit Jupiter.
 */

public class PakkaTest {

    @Test
    public void testPakkaAnnaKortti() {
        Pakka instance = new Pakka();
        Kortti kortti;
        String expected;

        // Vedä sekoittamattomasta pakasta 52 korttia
        System.out.println("--- PakkaTest: annaKortti");
        System.out.println("Kortit järjestyksessä maittain, sekoittamatta: ");
        for (int maa = Kortti.HERTTA; maa <= Kortti.PATA; maa++) {
            for (int numero = 1; numero <= 13; numero++) {
                kortti = instance.annaKortti();
                System.out.println(kortti);
                expected = Kortti.MAAT[maa] + " " + numero;
                assertEquals(expected, kortti.toString());
            }
        }
    }

    @Test
    public void testPakkaSekoita() {

        // Vedä sekoitetusta pakasta kortteja ja tulosta
        System.out.println("--- PakkaTest: sekoita");
        Pakka instance = new Pakka();
        instance.sekoita();
        System.out.println("Kortit sekoitettuna:");
        for (int i = 1; i <= Pakka.KORTTILKM; i++) {
            System.out.println(i + ": " + instance.annaKortti());
        }
        System.out.println("Varmista itse outputista, että kortit ovat sekoittuneet.");
        fail("Varmista itse outputista, että kortit ovat sekoittuneet.");
    }
}
