package model;

// Ali t.6
public class Valuuttakone implements IValuuttakone{
	
	//olio valuuttoille
	private Valuutta[] valuutat;
	private static ValuuttaAccessObject valuuttaDAO = new ValuuttaAccessObject ();
	
	public Valuuttakone() {
		valuuttaDAO.luoIstuntotehdas();
		this.valuutat = valuuttaDAO.readValuutta();
		valuuttaDAO.suljeIstuntotehdas();
	}

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
