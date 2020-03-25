package kahvila;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Auvo Häkkinen 10.2.2013, muutos 20.8.2019: JUnit Jupiter.
 */
public class TilausriviTest {

	@AfterEach
	public void tearDown() {
		Tuote.alustaSeuraavaVapaaTuotenumero();
	}

	@Test
	public void testTilausrivi_AnnaSumma() {
		System.out.println("--- TilausriviTest: annaSumma() + tulosta()");
		Valikoima valikoima = new Valikoima();
		Tuote[] tuotteita = { new Tuote("Ystävänpäivän munkki", 1.0), // tuotenumero = 1
				new Tuote("Runebergin torttu", 2.55), // tuotenumero = 2
				new Tuote("Dallaspulla", 2.25) // tuotenumero = 3
		};

		for (Tuote tuote : tuotteita) {
			valikoima.lisääTuoteValikoimaan(tuote);
		}
		valikoima.tulostaTuotteet();

		// Tilaa 3 kpl tuotetta 1.
		Tilausrivi rivi = new Tilausrivi(valikoima, 1, 3);
		System.out.println("Tilausrivi: ");
		rivi.tulosta();
		double expResult = 3.0;
		double result = rivi.annaSumma();
		System.out.println("Loppusumma = " + result + " €");
		assertEquals(expResult, result, 0.001, "Loppusumma väärin");
	}
}
