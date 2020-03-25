package kahvila;

import java.util.ArrayList;

/**
 *
 * @author Ali
 */
public class Tilaus {

    // Esittele ArrayList tilausrivien tallettamiseksi
	ArrayList<Tilausrivi> tilausrivit = new ArrayList();

    // Ohjelmoi lisääRiviTilaukseen()
	public void lisääRiviTilaukseen(Tilausrivi tilausrivi) {
		tilausrivit.add(tilausrivi);
	}

    // Ohjelmoi tulostaRivit()
	public void tulostaRivit() {
		for(Tilausrivi tilausrivi : tilausrivit) {
			tilausrivi.tulosta();
		}
		
	}

    // Ohjelmoi annaLoppusumma()
	public double annaLoppusumma() {
		double loppusumma = 0;
		for(Tilausrivi tilausrivi : tilausrivit) {
			loppusumma = loppusumma +tilausrivi.annaSumma();
		}
		return loppusumma;
		
	}

}
