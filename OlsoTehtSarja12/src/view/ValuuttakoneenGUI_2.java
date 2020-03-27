package view;

import java.text.DecimalFormat;

import controller.IValuuttakoneenOhjain;
import controller.ValuuttakoneenOhjain;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.IValuuttakone;
import model.Valuuttakone;

public class ValuuttakoneenGUI_2 extends Application implements IValuuttakoneenGUI{
	
	//t.3
	private IValuuttakoneenOhjain kontrolleri;
	private TextField tulosTxt;
	//t.4
	private String[] valuutat;
	private ListView<String> valintaMista;
	private ListView<String> valintaMihin;
	private TextField maaraTxt;
	//t.5
	private Stage primaryStage;

	@Override
	public void init() {
		//t.3
		IValuuttakone valuuttakone = new Valuuttakone();
		kontrolleri = new ValuuttakoneenOhjain(this,valuuttakone);
		//t.4
		valuutat = kontrolleri.getValuutat();
	}

	

	@Override
	public void start(Stage primaryStage) {
		
		//t.3
		try {
			//t.5
			this.primaryStage = primaryStage;
			primaryStage.setTitle("Valuuttakone");
			Button muunna = new Button("Muunna");
			muunna.setOnAction(new EventHandler<ActionEvent>() {
	        	
				@Override
	            public void handle(ActionEvent event) {
	                kontrolleri.muunnos();
	            }

	        });		


			maaraTxt = new TextField();
			Label maaraLabel = new Label("Määrä");
			Label mista = new Label("Mistä");
			Label mihin = new Label("Mihin");			
			Label tulosLabel = new Label("Tulos");
			
			tulosTxt = new TextField();
			VBox sarake2 = new VBox();
			
			sarake2.setSpacing(10);
			sarake2.getChildren().addAll(maaraTxt, muunna, tulosLabel, tulosTxt);

			
			//t.4
			valintaMista = new ListView<>();
			valintaMihin = new ListView<>();

			//t.4
			ObservableList<String> itemsMista = FXCollections.observableArrayList(valuutat);
			ObservableList<String> itemsMihin = FXCollections.observableArrayList(valuutat);
						
			//t.4
			valintaMista.setItems(itemsMista);	
			valintaMihin.setItems(itemsMihin);
			valintaMista.setMaxHeight(150);
			valintaMihin.setMaxHeight(150);
			valintaMista.setMaxWidth(165);
			valintaMihin.setMaxWidth(165);
			
			//t.4
			GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);
	        grid.setPadding(new Insets(10,10,10,10));
	        grid.setVgap(10);
	        grid.setHgap(10);
	        
	        grid.add(mista, 0, 0); // sarake, rivi
	        grid.add(mihin, 1, 0);
	        grid.add(maaraLabel, 2, 0);
	        grid.add(valintaMista, 0, 1);
	        grid.add(valintaMihin, 1, 1);
	        grid.add(sarake2, 2, 1);

	        
	        //t.3
	        Scene scene = new Scene(grid, 550, 200);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}		

	}


	//t.3
	@Override
	public int getLähtöIndeksi() {
		return valintaMista.getSelectionModel().getSelectedIndex();
	}


	// t.3
	@Override
	public int getKohdeIndeksi() {
		return valintaMihin.getSelectionModel().getSelectedIndex();
	}


	// t.3
	@Override
	public double getMäärä() {
		
		// t.5
		double paluuarvo = 0;
		try {
			paluuarvo = Double.parseDouble(maaraTxt.getText());
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ei numero");
			alert.setHeaderText(null);
			alert.setContentText("Syötä kenttään vain numeroita.");
			alert.initOwner(primaryStage);
			alert.showAndWait();
		}
		return paluuarvo;
	}


	// t.3
	@Override
	public void setTulos(double määrä) {
		DecimalFormat formatter = new DecimalFormat("#0.00");
		tulosTxt.setText(formatter.format(määrä));
	}

	

	public static void main(String[] args) {
		launch(args);
	}

}
