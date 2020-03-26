package laskin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/*
 * JUnit 5
 */

public class LaskinTest { // Luokan nimen loppu pit‰‰ olla Test

    // Fixture ("vakiokaluste"): kaikki testit k‰ytt‰v‰t samaa laskinta,
    // joka nollataan ennen kutakin testi‰.
    private Laskin laskin = new Laskin();
    //private final double DELTA = 0.001;

    @BeforeEach
    public void clearCalculator() {
        laskin.nollaa();
    }

    // Testimetodin nimi voi olla mit‰ tahansa, edess‰ annotaatio @Test
    @Test
    public void testLisaa() {
        laskin.lisaa(1);
        laskin.lisaa(2);
        assertEquals(3, laskin.annaTulos(), "Lukujen 1 ja 2 summa v‰‰rin");
    }

    @Test
    public void testVahenna() {
        laskin.lisaa(10);
        laskin.vahenna(2);
        assertEquals(8, laskin.annaTulos(), "Lukujen 10 ja 2 erotus v‰‰rin");
    }

    @Test
    @DisplayName("Testaa jakolasku 8 / 2")
    public void testJaa() {
        laskin.lisaa(8);
        laskin.jaa(2);
        assertEquals(4, laskin.annaTulos(), "Jakolasku 8/2 v‰‰rin");
    }

    // Testin oikea tulos on, ett‰ nollallajako heitt‰‰ poikkeuksen,
    // kutsuja k‰sittelee sen sitten haluamallaan tavalla
    @Test
    @DisplayName("Testaa nollallajako")
    public void testJaaNollalla() {
        ArithmeticException poikkeus = assertThrows(ArithmeticException.class, () -> laskin.jaa(0));
        assertEquals("Nollalla ei voi jakaa", poikkeus.getMessage(),"Nolallajako ei tuottanut poikkeusta");
    }
 
    //@Test
    @Disabled("HUOMAA - Metodi kerro() toteuttamatta, sit‰ ei ajeta")
    public void testKerro() {
        laskin.lisaa(8);
        laskin.kerro(2);
        assertEquals(16, laskin.annaTulos(), "Kertolasku 8 * 2 v‰‰rin");
    }
}
