package Model;

import java.util.Random;

public class noppaModel implements noppaModel_IF{
	
	//"pääohjelma"
	
	//instanssimuuttujat
	int silmaluku;
	Random rnd = new Random();
	public static int heitot = 1;
	private int [] taulu;
	
	//random silmäluku t.2,4,6
	public int annaSilmäluku() {
		silmaluku = rnd.nextInt(6) + 1;
		return silmaluku;
	}
	
	//heittojen määrä t.2,4,6
	public int lisaaHeitot() {
		return heitot++;
	}
	
	//viisi eri noppa t.5
	@Override
	public String viisiNoppaa() {
		taulu = new int[5];

		taulu[0] = new Random().nextInt(6)+1;
		taulu[1] = new Random().nextInt(6)+1;
		taulu[2] = new Random().nextInt(6)+1;
		taulu[3] = new Random().nextInt(6)+1;
		taulu[4] = new Random().nextInt(6)+1;

		return "Nopasta tuli: "+taulu[0] + "," + taulu[1] + "," + taulu[2] + "," + taulu[3] + "," + taulu[4];
	}
	
	//kaikki viisi noppaat yhteen t.5
	@Override
	public int viisiNoppanSumma() {
		int summa = 0;
		for(int arvo : taulu) {
			summa += arvo;
		}
		return summa;

	}

}
