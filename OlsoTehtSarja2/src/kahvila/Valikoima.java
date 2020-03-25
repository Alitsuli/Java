package kahvila;

import java.util.ArrayList;

/**
 *
 * @author Ali 24.1
 */
public class Valikoima {

    // Esittele ArrayList tuotteiden tallettamiseksi
	ArrayList<Tuote> tuotteet = new ArrayList();

    // Ohjelmoi getTuote()
	public Tuote getTuote(int tuotenumero) {
		
		for(int i= 0; i<tuotteet.size();i++) {
			Tuote tuote = tuotteet.get(i);
			if(tuote.getTuotenumero() == tuotenumero) {
				return tuote;
			}
		}
		return null;
	}

    // Ohjelmoi lisääTuoteValikoimaan()
	public void lisääTuoteValikoimaan(Tuote tuote) {
		tuotteet.add(tuote);
	}

    // Ohjelmoi poistaTuoteValikoimasta()
	public void poistaTuoteValikoimasta(int tuotenumero) {
		for(int i= 0; i<tuotteet.size();i++) {
			Tuote tuote = tuotteet.get(i);
			if(tuote.getTuotenumero() == tuotenumero) {
				tuotteet.remove(i);
			}
		}
	}

    // Poistettava Tuote-olio pitää etsiä listasta tuotenumerolla,
    // koska poistojen jälkeen tuotenumero != listan indeksi!

    // Ohjelmoi tulostaTuotteet()
	public void tulostaTuotteet() {
		for(Tuote tuote : tuotteet) {
			System.out.println(tuote);
		}
		
	}
}
