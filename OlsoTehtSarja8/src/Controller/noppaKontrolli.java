package Controller;

import Model.noppaModel;
import Model.noppaModel_IF;
import View.noppaGUI_IF;

public class noppaKontrolli implements noppaKontrolli_IF {
	
	noppaModel_IF model;
	noppaGUI_IF gui;
	

	public noppaKontrolli(noppaGUI_IF gui) {
		this.gui = gui;
		model = new noppaModel();
	}
	
	// t.2,3,4,6
	@Override
	public void arvoSilmaluku() {
		int arvo = model.annaSilmäluku();
		gui.setSilmaluku(arvo);

	}
	// t.2,3,4,6
	@Override
	public void annaHeitot() {
		int heittot = model.lisaaHeitot();
		gui.setHeitot(heittot);
	}
	// t. 4
	public void annaViisiNoppaa() {
		String viisi = model.viisiNoppaa();
		gui.setViisiNoppaa(viisi);
	}
	// t. 4
	public void annaSumma() {
		int summa = model.viisiNoppanSumma();
		gui.setSumma(summa);
	}
}
