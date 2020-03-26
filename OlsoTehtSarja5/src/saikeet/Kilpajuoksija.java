package saikeet;

/**
* @author Ali
*/

public class Kilpajuoksija extends Thread {
	private int numero; 				// juoksijan numero
	public static int seuraavaNumero=1;	// luokkamuuttuja juoksijoiden numeroimiseksi
	
	private final int MATKA = 400; 		// juostava matka, tässä vakio
	private double aika; 				// sekunteina

	//konstruktori
	public Kilpajuoksija() {
		this.numero = seuraavaNumero;
		this.setPriority(seuraavaNumero);
		seuraavaNumero++;
	}
	
	
	
	@Override
	public void run(){
		int juostu;

		// Ohjelmoi toisto, jossa
		// - tulostat väliaikatieto 50 metrin välein
			for (int i = 0; i < 40; i ++) {
				// - käytät satunnaislukugenerattoria 10 metrin juoksuajan saamiseksi
				juostu = (int) (Math.random()*(250+1));
			
				// - odotat ko. ajan
				try {
					Thread.sleep(juostu);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// ajan muutto
				aika = aika + (double) juostu/100;
				aika = aika*100;
				aika = (int)aika;
				aika = aika/100;
				
				// - tulostat väliaikatieto 50 metrin välein
				if ((i+1)%5 == 0) {
					//50 m välein tulostus
					int valein =(i+1)*10;
					System.out.println(this.numero + " " + valein+ "m " + aika + "s ");
				}
			}		
	}
		

	public double getAika(){
		return aika; 
	}
}
