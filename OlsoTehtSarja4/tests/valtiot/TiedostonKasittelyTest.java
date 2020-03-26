package valtiot;

/**
* @author hakka. Muokattu 16.1.2020
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import valtiot.TiedostonKäsittely;
import valtiot.Valtio;

import java.io.File;
import java.util.HashMap;

public class TiedostonKasittelyTest {

	private static HashMap<String, Valtio> valtiot = new HashMap<>();

	// JUnit suorittaa ennen kaikkia testejä
	@BeforeAll
	public static void luoLista() {
		valtiot.put("Suomi", new Valtio("Suomi", "Helsinki", 634940));
		valtiot.put("Viro", new Valtio("Viro", "Tallinna", 440112));
	}

	// JUnit suorittaa kaikkien testien jälkeen
	@AfterAll
	public static void poistaTiedosto() {
		File f = new File("testi.dat");
		f.delete();
	}

	@Test
	@DisplayName("Kirjoita koko HashMap tiedostoon yhdellä operaatiolla")
	public void testKirjoitaTiedosto() {
		TiedostonKäsittely.kirjoitaTiedosto("testi.dat", valtiot);
		File f = new File("testi.dat");
		assertTrue(f.exists(), "Tiedostoa ei löydy");
	}

	@Test
	@DisplayName("Lue koko HashMap tiedostosta yhdellä operaatiolla")
	public void testLueTiedosto() {
		TiedostonKäsittely.kirjoitaTiedosto("testi.dat", valtiot);
		HashMap<String, Valtio> luetut = TiedostonKäsittely.lueTiedosto("testi.dat");
		assertEquals(valtiot.toString(), luetut.toString(), "Luettu tiedosto ei vastaa kirjoitettua.");
	}

}

