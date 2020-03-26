package valtiot;

/**
* @author Ali 29.1.20
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Valtiotesti {

	public static void main(String[] args) {

		// Valtioiden käsittelyssä tarvittavat muuttujat ja
		// HashMap-olio Valtio-olioiden tallentamiseksi
		HashMap<String, Valtio> valtiot = new HashMap<>();
		
		Valtio valtio;
		/*
		String nimi = null;
		String pääkaupunki = null;
		int asukasluku =0;*/
		
		final String TIEDOSTONIMI = "valtiot.dat";		
		Scanner näppis = new Scanner(System.in);
		
		 //Jos tiedosto on olemassa, lue HashMap sieltä 
		valtiot = TiedostonKäsittely.lueTiedosto(TIEDOSTONIMI);
		if (valtiot == null) {
			valtiot = new HashMap<>();
		}
		
		
		// Lisää valtioita HashMapiin, kunnes syötteenä annetaan tyhjä 	
		String nimi;
		do {
			System.out.println("Anna valtion nimi :");
			nimi = (näppis.nextLine()).toUpperCase();
			
				if(nimi.length()!=0) {
					System.out.println("Anna pääkaupunki:");
					String pääkaupunki = näppis.nextLine();
					System.out.println("Anna asukasmäärä: ");
					int asukasluku = näppis.nextInt();
					näppis.nextLine();
					valtiot.put(nimi, new Valtio(nimi, pääkaupunki, asukasluku));
					}

		} while (nimi.length() != 0);
		
			
        // Tulosta HashMapin sisältö, käytä for-each- rakennetta
		System.out.println("HashMapissa nyt seuraavat valtiot:");
	    for (Map.Entry<String, Valtio> entry : valtiot.entrySet()) {	 
	    	 valtio =entry.getValue(); 
	        System.out.println(valtio);
	      }

		// Kirjoita HashMap tiedostoon
		TiedostonKäsittely.kirjoitaTiedosto(TIEDOSTONIMI, valtiot);
    
		näppis.close();	
	}
}
