package pokerikadet;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Auvo Häkkinen, 2.2.2013. Muutos 20.8.2019 JUnit Jupiter.
 */

public class KorttiTest {
	
	@BeforeAll
	public static void vihje() {
        System.out.println("--- KorttiTest: Konstuktorit, getterit ja setterit\n"
                + "eivät tarvitse yleensä erikseen omia testimetodeja.\n"
                + "Ne tulevat lähes aina testattua muiden metodien testien "
                + "yhteydessä.");
	}

    @Test
    public void testGetMaa() {
        System.out.print("--- KorttiTest: getMaa()");
        Kortti instance = new Kortti(Kortti.HERTTA, 12);
        int maa = instance.getMaa();
        assertEquals(Kortti.HERTTA, maa, "getMaa() palautti väärän maan - ");
        System.out.println(" -- OK");
    }

    @Test
    public void testGetArvo() {
        Kortti instance = new Kortti(Kortti.HERTTA, 12);
        int arvo = instance.getArvo();
        assertEquals(12, arvo, "getArvo() palautti väärän arvon - ");
        System.out.println("--- KorttiTest: getArvo() -- OK");
    }

    @Test
    public void testToString() {
        Kortti instance = new Kortti(Kortti.HERTTA, 12); // Herttanen rouva
        String result = instance.toString();
        assertEquals("Hertta 12", result, "toString() palautti väärän arvon - ");
        System.out.println("--- KorttiTest: toString() -- OK");
    }
}
