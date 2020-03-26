package Model;

import java.util.Random;

public class kolikkoModel implements kolikkoModel_IF {
	
	Random rnd = new Random();
	int tulos;
	
	public int arvoTulos() {
		tulos = rnd.nextInt(2);
		return tulos;
	}
	

}
