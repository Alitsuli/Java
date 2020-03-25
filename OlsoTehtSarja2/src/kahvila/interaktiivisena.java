package kahvila;

// Ali
import java.util.Scanner;

public class interaktiivisena {

	public static void main(String[] args) {
		
		Valikoima valikoima = new Valikoima();
		Kahvila kahvila = new Kahvila(valikoima);
				
		Scanner lukija = new Scanner(System.in);
		
		// toiminnon valinta
		int valinta;
		do {
			System.out.println("1. Lisää tuote valikoimaan");
			System.out.println("2. Tulosta valikoima");
			System.out.println("3. Poista tuote valikoimasta");
			System.out.println("4. Kirjaa tilaus");
			System.out.println("5. Tulosta kaikki tilaukset");
			System.out.println("0. Lopeta");
			valinta = lukija.nextInt();

			
			// toteutta valittu kohte
			switch (valinta){
			case 1:
				System.out.println("Anna tuotteen nimi:");
				String nimi = lukija.next();
				System.out.println("Anna tuotteen hinta:");
				double hinta = lukija.nextDouble();
				Tuote tuote = new Tuote(nimi, hinta);
				valikoima.lisääTuoteValikoimaan(tuote);
				break;

			case 2:
				valikoima.tulostaTuotteet();
				break;
				
			case 3:
				valikoima.tulostaTuotteet();
				System.out.println("Anna poistettavan tuotteen tuotenumero:");
				int tuotenumero = lukija.nextInt();
				valikoima.poistaTuoteValikoimasta(tuotenumero);
				break;
				
			case 4:
				Tilaus tilaus = new Tilaus();
				int lisaaRiveja = 0;
				do {
				valikoima.tulostaTuotteet();
				System.out.println("Anna tilattavan tuotteen tuotenumero:");
				int tilattavaTuote = lukija.nextInt();
				System.out.println("Anna tilattavien tuotteiden määrä:");
				int tuotteidenMaara = lukija.nextInt();
				Tilausrivi tilausrivi = new Tilausrivi(valikoima, tilattavaTuote, tuotteidenMaara);
				tilaus.lisääRiviTilaukseen(tilausrivi);
				System.out.println("Haluatko tilata muita tuotteita? Kyllä = 1, Ei = 0");
				lisaaRiveja = lukija.nextInt();
				} while (lisaaRiveja != 0);
				kahvila.lisääTilaus(tilaus);
				break;

			case 5:
				kahvila.tulostaTilaukset();
				break;
				
			default:
				break;
			}
		} while (valinta != 0);
		
	}
}
