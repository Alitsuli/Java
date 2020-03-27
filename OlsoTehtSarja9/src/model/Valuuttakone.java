package model;

// Ali t.2
public class Valuuttakone implements IValuuttakone{
	
	//olio valuuttoille
	Valuutta euro = new Valuutta("Europaan euro ", 1.0);
	Valuutta kruunu = new Valuutta("Ruotsin kruuna ", 9.4780);
	Valuutta Nkruunu = new Valuutta("Norjan kruunu ", 8.9018);
	Valuutta dollari = new Valuutta("Yhdysvaltain dollari ", 1.0629);
	
	//taulukko valuuttalle
	Valuutta[] valuutat = {euro,kruunu,Nkruunu,dollari};

	//vaihtoehdot t.4
	public String[] getVaihtoehdot() {
		String[] vaihtoehdot = new String[valuutat.length];
		for (int i = 0; i < valuutat.length; i++) {
			vaihtoehdot[i] = valuutat[i].getNimi();
		}
		return vaihtoehdot;
	}
	
	// muunnan rahat
	public double muunna(int mistäIndeksi, int mihinIndeksi , double määrä) {
		double euroina, tulos;
		//lähtövaluutta euroiksi
		euroina = määrä / valuutat[mistäIndeksi].getVaihtokurssi();
		//eurot kohdevaluutaksi
		tulos = euroina * valuutat[mihinIndeksi].getVaihtokurssi();
		return tulos;
	}

}
