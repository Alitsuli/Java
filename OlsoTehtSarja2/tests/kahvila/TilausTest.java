package kahvila;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * @author Auvo Häkkinen 10.2.2013, muutos 20.8.2019: JUnit Jupiter.
 */
public class TilausTest {

    @AfterEach
    public void tearDown() {
        Tuote.alustaSeuraavaVapaaTuotenumero();
    }

    @Test
    public void testTilaus_LisääTilausriviTilaukseen() {
        System.out.println("--- TilausTest: Lisää - tulosta - loppusumma");

        Valikoima valikoima = new Valikoima();
        Tuote[] tuotteita = {
            new Tuote("Ystävänpäivän munkki", 1.0), // tuotenumero = 1
            new Tuote("Runebergin torttu", 2.55), // tuotenumero = 2
            new Tuote("Dallaspulla", 2.25) // tuotenumero = 3
        };

        for (Tuote tuote : tuotteita) {
            valikoima.lisääTuoteValikoimaan(tuote);
        }
        valikoima.tulostaTuotteet();

        // Tilaa 10 kpl kutakin tuotetta
        Tilaus instance = new Tilaus();
        Tilausrivi tilausrivi;
        for (int tuotenro = 1; tuotenro <= tuotteita.length; tuotenro++) {
            tilausrivi = new Tilausrivi(valikoima, tuotenro, 10);
            instance.lisääRiviTilaukseen(tilausrivi);
        }
        double summa = instance.annaLoppusumma();
        System.out.println("Tilaus:");
        instance.tulostaRivit();
        System.out.println("Loppusumma on " + summa + " €");

        assertEquals(58.0, summa, 0.001, "Loppusumma ei täsmää");
    }
}
