package kahvila;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Auvo Häkkinen 10.2.2013, muutos 20.8.2019: JUnit Jupiter.
 */
public class KahvilaTest {

	@AfterEach
	public void tearDown() {
		Tuote.alustaSeuraavaVapaaTuotenumero();
	}

	@Test
	public void testKahvila_LisääTilaus() {
		System.out.println("--- KahvilaTest: lisääTilaus");

		Valikoima valikoima = new Valikoima();
		Tuote[] tuotteita = { new Tuote("Ystäväpäivän munkki", 1.0), // tuotenumero = 1
				new Tuote("Runebergin torttu", 2.55), // tuotenumero = 2
				new Tuote("Dallaspulla", 2.25) // tuotenumero = 3
		};
		for (Tuote tuote : tuotteita) {
			valikoima.lisääTuoteValikoimaan(tuote);
		}

		// Tilaa ekassa tilauksessa 1 kpl kutakin tuotetta
		Tilaus tilaus = new Tilaus();
		Tilausrivi tilausrivi;
		for (int tuotenro = 1; tuotenro <= tuotteita.length; tuotenro++) {
			tilausrivi = new Tilausrivi(valikoima, tuotenro, 1);
			tilaus.lisääRiviTilaukseen(tilausrivi);
		}

		Kahvila instance = new Kahvila(valikoima);
		instance.lisääTilaus(tilaus);
		instance.tulostaTilaukset();

		// Tee toinen tilaus, 1 kpl tuotetta 1
		tilaus = new Tilaus();
		tilausrivi = new Tilausrivi(valikoima, 1, 1);
		tilaus.lisääRiviTilaukseen(tilausrivi);
		instance.lisääTilaus(tilaus);
		instance.tulostaTilaukset();

		// Tee kolmas tilaus, 2 kpl tuotetta 2
		tilaus = new Tilaus();
		tilausrivi = new Tilausrivi(valikoima, 2, 2);
		tilaus.lisääRiviTilaukseen(tilausrivi);
		instance.lisääTilaus(tilaus);
		instance.tulostaTilaukset();
	}
}
