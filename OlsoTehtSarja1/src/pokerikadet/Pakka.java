package pokerikadet;

/**
*
* @author ali 14.1
*/
public class Pakka {

    final static int KORTTILKM = 52;
    
	// Näiden näkyvyys: pakkauksen sisällä (ei private, ei public)
    // Viittaus muista luokista Luokka.tunnus, esim. Pakka.KORTTILKM

    // Esittele instanssimuuttujat
    private Kortti kortit[] = new Kortti[53];
    private int Vuorossa = 1;

    // Kirjoita konstruktori, joka alustaa pakan Kortti-olioilla
    
    public Pakka() {
    	int k=1;
    	for(int i=0; i< 4;i++) {
    		for(int j=1; j<14; j++) {
    			kortit[k] = new Kortti(i,j);
    			k++;
    		}
    	}
    }

    // Kirjoita metodi sekoita()
    public void sekoita() {
    	int vaihtaA, vaihtaB;
    	for (int i = 0; i < 100; i++) {
    		vaihtaA = 1 + (int)(Math.random() * 52);
    		Kortti kortti1 = kortit[vaihtaA];
    		vaihtaB = 1 + (int)(Math.random() * 52);
    		Kortti kortti2 = kortit[vaihtaB];
    		kortit[vaihtaA] = kortti2;
    		kortit[vaihtaB] = kortti1;

    	}
    }

    // Kirjoita metodi annaKortti()
    public Kortti annaKortti() {
    	Kortti kortti = kortit[Vuorossa];
    	Vuorossa++;
    	
    	if(KORTTILKM < Vuorossa) {
    		Vuorossa = 1;
    	}
    	return kortti;
    }

    

}
