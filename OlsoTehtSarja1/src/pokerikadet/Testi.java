package pokerikadet;
/**
*
* @author 16.1
*/
public class Testi {

    public static void main(String[] args) {

    	// Luo pakka
    	Pakka pakka = new Pakka();
    	int arvo = 0;
    	int jakoja = 0;
    	do {

    		// Sekoita pakka
    		pakka.sekoita();
    		// Jaa käsi
    		Käsi kasi = new Käsi(pakka);
    		jakoja++;
    		

    		// Näytä (tulosta) käsi
    		kasi.toString();
    		
    		// Tarkasta onko väri
    		arvo = kasi.annaArvo();
    		} while ( arvo == 0);
    		System.out.println(jakoja);
    }
}
