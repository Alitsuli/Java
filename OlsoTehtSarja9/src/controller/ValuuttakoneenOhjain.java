package controller;

import model.IValuuttakone;
import model.Valuuttakone;
import view.IValuuttakoneenGUI;

// Ali 

public class ValuuttakoneenOhjain implements IValuuttakoneenOhjain {
	
	IValuuttakone model;
	IValuuttakoneenGUI gui;
	
	//t.3
	public ValuuttakoneenOhjain(IValuuttakoneenGUI gui,IValuuttakone model){
		this.gui = gui;
		this.model = model;
	}
	
	public void muunnos() {
		// t.6
		int lahtoIndeksi = gui.getLähtöIndeksi();
		int kohdeIndeksi = gui.getKohdeIndeksi();
		double maara = gui.getMäärä();
		double muunnettu = model.muunna(gui.getLähtöIndeksi(), gui.getKohdeIndeksi(),gui.getMäärä());
		
		gui.setTulos(muunnettu);
	}
	//t.4
	public String [] getValuutat() {
		String[] valuutat = model.getVaihtoehdot();
		return valuutat;
	}

}
