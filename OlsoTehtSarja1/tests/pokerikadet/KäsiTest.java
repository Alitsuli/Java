package pokerikadet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class KäsiTest {

	/**
	 *
	 * @author hakka, 2.2.2013. Muutos 20.8.2019: JUnit Jupiter
	 */

	private Kortti[] kortit = new Kortti[5];
	private Käsi instance;

	// Tämä metodi suoritetaan aina ennen kutakin testimetodia.
	// Kaikissa testeissä on siis lähtötilanteena sama Käsi.
	@BeforeEach
	public void oletusKäsi() {
		kortit[0] = new Kortti(Kortti.HERTTA, 1);
		kortit[1] = new Kortti(Kortti.HERTTA, 3);
		kortit[2] = new Kortti(Kortti.HERTTA, 5);
		kortit[3] = new Kortti(Kortti.HERTTA, 7);
		kortit[4] = new Kortti(Kortti.HERTTA, 9);
	}

	// Tämä metodi suoritetaan aina kunkin testimetodin jälkeen.
	// Metodi tulostaa tarkastetun K�den.
	@AfterEach
	public void tulostaKäsi() {
		System.out.println(instance);
	}

	@Test
	public void testKäsiEiVäri() {
		// Muistettava testata myös se toinen vaihtoehto
		System.out.println("--- KäsiTest: annaArvo -> EI VÄRI");
		kortit[0] = new Kortti(Kortti.PATA, 13);
		instance = new Käsi(kortit);
		assertEquals(Käsi.EIVÄRI, instance.annaArvo(), "Ei saanut tulla VÄRI");
	}

	@Test
	public void testKäsiVäri() {
		System.out.println("--- KäsiTest: annaArvo -> VÄRI");
		instance = new Käsi(kortit);
		assertEquals(Käsi.VÄRI, instance.annaArvo(), "Piti tulla VÄRI");
	}

	@Disabled("Liittyy jatkotehtäviin")
	@Test
	public void testKäsiEiSuora() {
		System.out.println("--- KäsiTest: annaArvo -> EI SUORA");
		kortit[0] = new Kortti(Kortti.PATA, 13);
		instance = new Käsi(kortit);
		assertEquals(Käsi.EISUORA, instance.annaArvo(), "Ei saanut tulla SUORA");
	}

	@Disabled("Liittyy jatkotehtäviin")
	@Test
	public void testKäsiSuora() {
		System.out.println("--- KäsiTest: annaArvo -> SUORA");
		kortit[0] = new Kortti(Kortti.HERTTA, 1);
		kortit[1] = new Kortti(Kortti.RUUTU, 2);
		kortit[2] = new Kortti(Kortti.RISTI, 3);
		kortit[3] = new Kortti(Kortti.PATA, 4);
		kortit[4] = new Kortti(Kortti.HERTTA, 5);
		instance = new Käsi(kortit);
		assertEquals(Käsi.SUORA, instance.annaArvo(), "Piti tulla SUORA (Ässä=1)");
	}

	@Disabled("Liittyy jatkotehtäviin")
	@Test
	public void testKäsiÄssäSuora() {
		System.out.println("--- KäsiTest: annaArvo -> SUORA");
		kortit[0] = new Kortti(Kortti.HERTTA, 1);
		kortit[1] = new Kortti(Kortti.RUUTU, 10);
		kortit[2] = new Kortti(Kortti.RISTI, 11);
		kortit[3] = new Kortti(Kortti.PATA, 12);
		kortit[4] = new Kortti(Kortti.HERTTA, 13);

		instance = new Käsi(kortit);
		assertEquals(Käsi.SUORA, instance.annaArvo(), "Piti tulla SUORA (Ässä=14)");
	}

	@Disabled("Liittyy jatkotehtäviin")
	@Test
	public void testKäsiEiVäriSuora() {
		System.out.println("--- KäsiTest: annaArvo -> EI VÄRISUORA");
		kortit[0] = new Kortti(Kortti.PATA, 13);
		instance = new Käsi(kortit);
		assertEquals(Käsi.EISUORA, instance.annaArvo(), "Ei saanut tulla VÄRISUORA");
	}

	@Disabled("Liittyy jatkotehtäviin")
	@Test
	public void testKäsiVäriSuora() {
		System.out.println("--- KäsiTest: annaArvo -> VÄRISUORA");
		kortit[0] = new Kortti(Kortti.RUUTU, 3);
		kortit[1] = new Kortti(Kortti.RUUTU, 4);
		kortit[2] = new Kortti(Kortti.RUUTU, 5);
		kortit[3] = new Kortti(Kortti.RUUTU, 6);
		kortit[4] = new Kortti(Kortti.RUUTU, 7);
		instance = new Käsi(kortit);
		assertEquals(Käsi.VÄRISUORA, instance.annaArvo(), "Piti tulla VÄRISUORA");
	}

	@Test
	public void testKäsiToString() {
		System.out.println("--- KäsiTest: toString");
		Pakka pakka = new Pakka(); // Sekoittamaton
		instance = new Käsi(pakka);
		String expResult = "Hertta 1, Hertta 2, Hertta 3, Hertta 4, Hertta 5";
		String result = instance.toString();
		assertEquals(expResult, result,"Merkkijonon muotoilu väärin");
	}
}
