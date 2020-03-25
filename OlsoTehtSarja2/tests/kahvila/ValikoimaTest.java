package kahvila;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Auvo Häkkinen 10.2.2013, muutos 20.8.2019: JUnit Jupiter.
 */
public class ValikoimaTest {

    private Tuote[] tuotteita = {
        new Tuote("Ystävänpäivän munkki", 1.0), // tuotenumero = 1
        new Tuote("Runebergin torttu", 2.55), // tuotenumero = 2
        new Tuote("Dallaspulla", 2.25) // tuotenumero = 3
    };
    private Valikoima valikoima;

    // Käyttää samoja tuotteita kaikissa testeissä.
    @BeforeEach
    public void setUp() {
        valikoima = new Valikoima();
        for (Tuote tuote : tuotteita) {
            valikoima.lisääTuoteValikoimaan(tuote);
        }
    }

    // Kun yksi testimetodi suoritettu, aloita tuotenumerointi taas 1:stä.
    @AfterEach
    public void tearDown() {
        Tuote.alustaSeuraavaVapaaTuotenumero();
    }

    @Test
    public void testValikoima_LisääTuoteValikoimaan() {
        System.out.println("--- ValikoimaTest: Lisäys - tulostus - haku");

        System.out.println("Lisätty tuotteet:");
        valikoima.tulostaTuotteet();

        Tuote tuote = valikoima.getTuote(1);
        System.out.println("Haettu tuote: " + tuote);
        // Tässä verrataan kokonaisia olioita.
        assertEquals(tuotteita[0], tuote, "Haku tuotenumerolla ei täsmää.");
    }

    @Test
    public void testValikoima_PoistaTuoteValikoimasta() {
        System.out.println("--- ValikoimaTest: Poisto - tulostus - haku");

        int tuotenumero = 2;
        valikoima.poistaTuoteValikoimasta(tuotenumero);

        System.out.println("Poistettu tuote: " + tuotenumero);
        System.out.println("Valikoimassa on tuotteet: ");
        valikoima.tulostaTuotteet();

        // Kun tuote poistettu haku palauttaa null.
        Tuote result = valikoima.getTuote(tuotenumero);
        assertEquals(null, result, "Tuote ei ole poistunut.");
    }
}
