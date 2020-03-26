import saikeet.OmaSaie;

/**
 * @author Ali
 * ratkaisu t.1
 */


public class OmaSaieMain {

	// Säiettä testaava pääohjelma
	public static void main(String[] args) throws InterruptedException {
		OmaSaie saie;
		System.out.println("Säiepääohjelma");

		// Luo OmaSaie alkuarvolla 15
		saie = new OmaSaie(15);
		
		// Tulosta alkuarvot
		System.out.println("Alkuarvot ovat " + saie.getLuku() + ", " + OmaSaie.getYhteisetAjokerrat());
		
		// Käynnistä säie
		saie.start();
		
		// Odota säikeen päättymistä
		saie.join();

		// Tulosta uudet arvot
		System.out.println("Uudet arvot ovat " + saie.getLuku() + ", " + OmaSaie.getYhteisetAjokerrat());

		// Luo uusi OmaSaie alkuarvolla 2017
		saie = new OmaSaie(2017);
		
		// Tulosta alkuarvot
		System.out.println("Alkuarvot ovat " + saie.getLuku() + ", " + OmaSaie.getYhteisetAjokerrat());

		// Käynnistä säie
		saie.start();
		// Odota säikeen päättymistä
		saie.join();

		// Tulosta uudet arvot
		System.out.println("Uudet arvot ovat " + saie.getLuku() + ", " + OmaSaie.getYhteisetAjokerrat());

	}

}
