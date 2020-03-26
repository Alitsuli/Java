

package laskin;


// Ali Tehtävä 1

public class Laskin {

    private int tulos;  	// Muuttuja tulokselle

    public void nollaa() {  // Nollaa tulosmuuttuja
        tulos = 0;
    }

    public int annaTulos() {
        return tulos;
    }

    public void lisaa(int n) {
        tulos = tulos + n;
    }

    public void vahenna(int n) {
        tulos = tulos - n;
    }

    public void kerro(int n) {
        // Ei vielä toteutettu
    	tulos = tulos * n;
    }

    public void jaa(int n) {
    	// tehtävä 2
    	if (n==0) throw new ArithmeticException("Nollalla ei voi jakaa");
        tulos = tulos / n;
    }

    public void nelio(int n) {
        tulos = 2 * n;
    }

    public void neliojuuri(int n) {
    	// tehtä
    	if (n<0) throw new ArithmeticException("Negatiivisesta luvusta ei voi ottaa neliöjuurta");
    	// Ei vielä toteutettu
    	tulos = (int)Math.sqrt(n);
    }

    public void virtaON() {
        // Tähän voisi laittaa muutkin alkutoimet
        tulos = 0;
    }

    public void virtaOFF() {
        // Tähänn voisi laittaa lopputoimet
    }

}
