import java.util.Scanner;

/**
 * @author Ali 28.01 tehtäväsarja 4 ratkaisu 1
 */

public class Poikkeus {

	public static void main(String[] args) {

		System.out.println("Tehtävä 1: Poikkeuksen testaaminen");

		// Esittele tarvittavat muuttujat
		Scanner lukija = new Scanner(System.in);
		String merkkijono = null;
		int luku;
		do {
			// Ohjelmoi try-catch-lohko
			try {
				// Kysy ikä ja lue se merkkijonomuuttujaan
				System.out.println("Anna ikäsi.");
				merkkijono = lukija.next();
				// Tee muunnos
				luku = Integer.parseInt(merkkijono);
				// - jos muunnos onnistuu, näytä tulos ja lopeta
				System.out.println("Vuoden päästä olet jo " + (luku + 1) + "-vuotias.");
				break;
			} catch (Exception e) {
				// - jos syntyy poikkeus, anna virheilmoitus
				System.out.println("Antamasi ikä " + merkkijono + " ei ole kelvollinen.");
				System.out.println(e);
			}
		} while (true);
		// Poikkeustilanteessa ikää on kysyttävä vielä uudelleen,
		// joten tarvitset kaiken ympärille vielä toistorakenteen
	}
}
