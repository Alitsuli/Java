import java.util.Scanner;
import model.*;


/**
 * @author ali
 * TekstiMain käytetään valuuttatietokannan ylläpitoon
 */
public class TekstiMain {
	
	static Scanner lukija = new Scanner(System.in);
	static ValuuttaAccessObject valuuttaDAO = new ValuuttaAccessObject();
	
	
	public static void listaaValuutat() {
		Valuutta[] valuutat = valuuttaDAO.readValuutta();
		for(Valuutta val : valuutat) {
			System.out.println(val);
		}
	}
	
	public static void lisaaValuutta() {
		
		System.out.println("Syötä tunnus:");
		String tunnus = lukija.nextLine();
		System.out.println("Syötä valuuttakurssi:");
		Double kurssi = Double.parseDouble(lukija.nextLine());
		System.out.println("Syötä nimi:");
		String nimi = lukija.nextLine();
		
		valuuttaDAO.createValuutta(new Valuutta(tunnus,kurssi,nimi));
	}
	
	
	public static void paivitaValuutta() {
		System.out.println("Syötä päivitettävän valuutan tunnus:");
		String tunnus = lukija.nextLine();
		
		Valuutta tarkasteltavaValuutta = valuuttaDAO.readValuutta(tunnus);
		System.out.println("Syötä kirjaintunnus: V (vaihtokurssi) / N (nimi) / M (molemmat).");
		String paivita = lukija.nextLine();
		
		if (paivita.equals("V")) {

			System.out.println("Syötä uusi valuuttakurssi (käytä pistettä erottimena).");
			Double vaihtokurssi = Double.parseDouble(lukija.nextLine());
			tarkasteltavaValuutta.setVaihtokurssi(vaihtokurssi);
			
		}else if (paivita.equals("N")) {
			
			System.out.println("Syötä uusi nimi: ");
			String nimi = lukija.nextLine();
			tarkasteltavaValuutta.setNimi(nimi);
			
		} else if (paivita.equals("M")) {
			
			System.out.println("Syötä uusi valuuttakurssi (käytä pistettä erottimena): ");
			Double vaihtokurssi = Double.parseDouble(lukija.nextLine());
			tarkasteltavaValuutta.setVaihtokurssi(vaihtokurssi);
			System.out.println("Syötä uusi nimi: ");
			String nimi = lukija.nextLine();
			tarkasteltavaValuutta.setNimi(nimi);
			
		} else {
			System.out.println("Päivitys epäonnistui, kirjoituksessa on virhe tai et osaa kirjoittaa.");
		}
		
		valuuttaDAO.updateValuutta(tarkasteltavaValuutta);
		
	}
	
	public static void poistaValuutta() {
		
		System.out.println("Syötä poistettavan valuutan tunnus:");
		String tunnus = lukija.nextLine();
		valuuttaDAO.deleteValuutta(tunnus);
		
	}
	
	public static void main(String[] args) {

		valuuttaDAO.luoIstuntotehdas();
		
		char valinta;
		final char CREATE = 'C', READ = 'R', UPDATE = 'U', DELETE = 'D', QUIT = 'Q';

		String vaihtoehdot = "\nC: Lisää uusi valuutta tietokantaan\n" + 
				"R: Listaa tietokannassa olevien valuuttojen tiedot\n" + 
				"U: Päivitä valuutan vaihtokurssi tietokantaan\n" + 
				"D: Poista valuutta tietokannasta\n" + 
				"Q: Lopetus\n" + 
				"Valintasi:";
		
		do {
			
			System.out.println(vaihtoehdot);
			valinta = (lukija.nextLine().toUpperCase()).charAt(0);
			switch (valinta) {
			case READ:
				listaaValuutat();
				break;
			case UPDATE:				
				paivitaValuutta();
				break;
			case DELETE:
				poistaValuutta();
				break;
			case CREATE:				
				lisaaValuutta();
				break;
			}
			
		} while (valinta != QUIT);

		valuuttaDAO.suljeIstuntotehdas();
	}

	

}
