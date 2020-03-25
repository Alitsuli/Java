package pokerikadet;
/**
*
* @author Ali 16.1
*/
import java.util.Arrays;

public class Käsi {
	
    final static int EIVÄRI = 0, EISUORA = 0, SUORA = 1, VÄRI = 2, VÄRISUORA = 3;
    // Näiden näkyvyys: pakkauksen sisällä (ei private, ei public)
    // Viittaus muista luokista muodossa Luokka.tunnus esim. Käsi.SUORA

    // Esittele instanssimuuttujat
    private Kortti kasi[] = new Kortti[5];

    // Kirjoita konstruktori, joka saa parametrina Pakka-olion123
    public Käsi(Pakka pakka) {
    	for (int i=0;i<5;i++) {
    		kasi[i]=pakka.annaKortti();
    	}
    }
    //test
    public Käsi(Kortti valmisKasi[]) {
    	for(int i=0;i<5;i++) {
    		kasi[i] = valmisKasi[i];
    	}
    }

    // Kirjoita toteutus metodille annaArvo()
    public int annaArvo() {
    	int arvo = 0;
    	boolean suora = false;
    	boolean vari = false;
    	
    	//taulukko korttien arvoista
    	int korttienArvot[] = new int[5];
    	for(int i=0;i<5;i++) {
    		korttienArvot[i]=kasi[i].getArvo();
    	}
    	//laitetaan korttien arvot suuruusjärjestykseen
    	for(int i=0; i<korttienArvot.length-1; ++i)
    		for(int j=i+1; j<korttienArvot.length; ++j)
    			if(korttienArvot[i] > korttienArvot[j]) {
    				int apu = korttienArvot[i];
    				korttienArvot[i]=korttienArvot[j];
    				korttienArvot[j]=apu;
    			}

    	// Testataan, onko kaikki seuraavat kortit yhtä suurempia kuin edellinen
    	// ja lisäksi huomioidaan jos ensimmäinen kortti on ässä (1) ja viimeinen kunkku (13)

    		if ((korttienArvot[0] == korttienArvot[1] - 1 || 
    		 korttienArvot[0] + 12 == korttienArvot[4]) && 
    		 korttienArvot[1] == korttienArvot[2] - 1 && 
    		 korttienArvot[2] == korttienArvot[3] - 1 &&
    		 korttienArvot[3] == korttienArvot[4] - 1) {
    		arvo = 1;
    		suora = true;
    		}

    	// Testataan, ovatko kaikki kortit samaa maata kuin ensimmäinen

    		if (kasi[0].getMaa() == kasi[1].getMaa() && 
    		kasi[0].getMaa() == kasi[2].getMaa() && 
    		kasi[0].getMaa() == kasi[3].getMaa() && 
    		kasi[0].getMaa() == kasi[4].getMaa()) {
    		arvo = 2;
    		vari = true;
    		}
    	
    	// Jos saatiin suora ja väri, on kyseessä värisuora
    		if (suora && vari) {
    		arvo = 3;
    		}

    		return arvo;
    		}

    // Kirjoita toString()

    public String toString() {
    	String merkkijono = kasi[0].toString() + ", " + 
    			kasi[1].toString() + ", " + 
    			kasi[2].toString() + ", " + 
    			kasi[3].toString() + ", " + 
    			kasi[4].toString();
    	return merkkijono;

    }
}
