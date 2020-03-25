package kahvila;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Auvo Häkkinen 10.2.2013, muutos 20.8.2019: JUnit Jupiter.
 */
public class TuoteTest {

    private Tuote tuote = new Tuote("Ystävänpäivän munkki", 2.55);

    @AfterEach
    public void tearDown() {
        Tuote.alustaSeuraavaVapaaTuotenumero();
    }

    @Test
    public void testAlustaSeuraavaVapaaTuotenumero() {
        System.out.println("--- TuoteTest: asetaSeuraavaVapaaTuotenumero()");
        Tuote pulla = new Tuote("Rähmäpulla", 5);
        assertEquals(2, pulla.getTuotenumero(), "Tuotteen numero on väärin ");
        Tuote.alustaSeuraavaVapaaTuotenumero(); // Numerointi taas 1:stä
        pulla = new Tuote("Rähmäpulla", 5);
        assertEquals(1, pulla.getTuotenumero(), "Tuotenumeron alustus väärin - ");
    }
    
    @Test
    public void testTuoteGetHinta() {
        System.out.println("--- TuoteTest: getHinta()");
        double expResult = 2.55;
        double result = tuote.getHinta();
        System.out.println("Hinta = " + result);
        assertEquals(expResult, result, 0.001, "Ystävänpäivän munkin hinta väärin - ");
        // Kun tulos on liukuluku, on kolmantena parametrina tarkkuus (delta),
        // joka ilmaisee minkä verran saatu tulos voi poiketa odotetusta.
    }
    
    @Test
    public void testTuoteToString() {
        System.out.println("--- TuoteTest: toString()");
        String expResult = "1 Ystävänpäivän munkki, 2.55 €";
        String result = tuote.toString();
        System.out.println(result);
		
		if (!result.contains("Ystävänpäivän munkki"))
			fail("Tuotenimi väärin : pitäisi olla Ystävänpäivän munkki, mutta oli " + result);
		if (!result.contains("1"))
			fail("Tuotenumero väärin : pitäisi olla 1, mutta oli " + tuote.getTuotenumero());
		if (!result.contains("2.55"))
			fail("Hinta väärin : pitäisi olla 2.55 €, mutta oli " + tuote.getHinta());
		
        assertEquals(expResult, result, "Tuotteen merkkijonoesitys väärin - ");
    }
}
