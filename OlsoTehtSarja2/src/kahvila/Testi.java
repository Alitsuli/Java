package kahvila;

/**
 *
 * @author Ali
 */
public class Testi {

    public static void main(String[] args) {

    // Esittele tarvittavat muuttujat.
    	Valikoima valikoima = new Valikoima();
    	Kahvila kahvila = new Kahvila(valikoima);
    	
    // Luo kolme tuotetta.
    	Tuote kahvi = new Tuote("Latte", 4.50);
    	Tuote muffinsi = new Tuote("muffinsi", 3.90);
    	Tuote vesi = new Tuote("pullovesi", 2.00);
    	
    // Lisää ne valikoimaan.
    	valikoima.lisääTuoteValikoimaan(kahvi);
    	valikoima.lisääTuoteValikoimaan(muffinsi);
    	valikoima.lisääTuoteValikoimaan(vesi);

    // Tulosta valikoima.
    	valikoima.tulostaTuotteet();

    // Poista siitä yksi tuote.
    	valikoima.poistaTuoteValikoimasta(3);

    // Tulosta muuttunut valikoima.
    	valikoima.tulostaTuotteet();

    // Luo tilaus.
    	Tilaus tilaus1 = new Tilaus();

    // Luo kaksi tilausriviä.
    	Tilausrivi tilausrivi1 = new Tilausrivi(valikoima, 1,2);
    	Tilausrivi tilausrivi2 = new Tilausrivi(valikoima, 3,1);

    // Lisää tilausrivit tilaukseen.
    	tilaus1.lisääRiviTilaukseen(tilausrivi1);
    	tilaus1.lisääRiviTilaukseen(tilausrivi2);

    // Lisää tilaus kahvilan tilauslistaan.
    	kahvila.lisääTilaus(tilaus1);

    // Luo toinenkin tilaus tilausriveineen.
    	Tilaus tilaus2 = new Tilaus();
    	Tilausrivi tilausrivi3 = new Tilausrivi(valikoima, 1,1);
    	Tilausrivi tilausrivi4 = new Tilausrivi(valikoima, 3,3);
    	tilaus2.lisääRiviTilaukseen(tilausrivi3);
    	tilaus2.lisääRiviTilaukseen(tilausrivi4);
    	kahvila.lisääTilaus(tilaus2);

    // Tulosta kaikki kahvilan tilaukset.
    	kahvila.tulostaTilaukset();

    }
}
