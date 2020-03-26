package Controller;

import Model.kolikkoModel_IF;
import View.kolikkoGUI_IF;

public class kolikkoControl implements kolikkoControl_IF{
	kolikkoModel_IF model;
	kolikkoGUI_IF gui;
	
	public kolikkoControl(kolikkoGUI_IF gui, kolikkoModel_IF model) {
		this.gui = gui;
		this.model = model;
	}
	
	public void kolikonheitto() {
		int tulos = model.arvoTulos();
		gui.setTulos(tulos);
	}
	

}
