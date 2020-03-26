package readerwriter;

//Ali Tehtävä 1

public class LukijaKirjoittajaMain {
	
	public static void main(String[] args) {

		IntSailio sailio = new IntSailio();
		Kirjoittaja kirjoittaja = new Kirjoittaja(sailio);

		Lukija lukijat = new Lukija(sailio);

		kirjoittaja.start();

		lukijat.start();

		// Luo vielä toinen lukijasäie (ja kenties kolmaskin...)
		Lukija lukija1 = new Lukija(sailio);
		Lukija lukija2 = new Lukija(sailio);
		Lukija lukija3 = new Lukija(sailio);

		lukija1.start();
		lukija2.start();
		lukija3.start();
		// main-säie kuolee pois, mutta sen luomat säikeet jatkavat
	}

}