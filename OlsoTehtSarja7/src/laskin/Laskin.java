

package laskin;


// Ali Teht�v� 1

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
        // Ei viel� toteutettu
    	tulos = tulos * n;
    }

    public void jaa(int n) {
    	// teht�v� 2
    	if (n==0) throw new ArithmeticException("Nollalla ei voi jakaa");
        tulos = tulos / n;
    }

    public void nelio(int n) {
        tulos = 2 * n;
    }

    public void neliojuuri(int n) {
    	// teht�
    	if (n<0) throw new ArithmeticException("Negatiivisesta luvusta ei voi ottaa neli�juurta");
    	// Ei viel� toteutettu
    	tulos = (int)Math.sqrt(n);
    }

    public void virtaON() {
        // T�h�n voisi laittaa muutkin alkutoimet
        tulos = 0;
    }

    public void virtaOFF() {
        // T�h�nn voisi laittaa lopputoimet
    }

}
