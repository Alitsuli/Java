package View;

import Controller.kolikkoControl;
import Controller.kolikkoControl_IF;
import Model.kolikkoModel;
import Model.kolikkoModel_IF;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class kolikkoGUI extends Application implements kolikkoGUI_IF{
	
	private kolikkoControl_IF kontrolli;
	
	private Button heittoButton;
	private Label tulos;
	
	public void init() {
		kolikkoModel_IF malli = new kolikkoModel();
		kontrolli = new kolikkoControl(this ,malli);
	}
	
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Kolikonheitto");
			heittoButton = new Button();
			heittoButton.setText("Heitä kolikko");
			heittoButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					kontrolli.kolikonheitto();					
				}
			});
			tulos = new Label("Tulos");

			GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);
	        grid.setVgap(20);
	        grid.setHgap(10); 
	         
	        
	        grid.add(heittoButton, 0, 0);
	        grid.add(tulos, 0, 1);     
	        
			Scene scene = new Scene(grid, 400, 200);
	        primaryStage.setScene(scene);
	        primaryStage.show();	
	        
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override

	public void setTulos(int tulos) {
		if (tulos == 0) {
			this.tulos.setText("Kruuna");
		}
		else {
			this.tulos.setText("Klaava");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
