package View;



import Controller.tervehdysKontrolli;
import Controller.tervehdysKontrolli_Interface;
import Model.tervehdysModel;
import Model.tervehdysModel_IF;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class tervehdysGUI extends Application implements tervehdysGUI_Interface{
	
	private tervehdysKontrolli_Interface kontrolli;
	
	// esittelyn varten
	private Button aamuB;
	private Button paivaB;
	private Button iltaB;
	private Button yoB;
	
	private Label selite;
	
	// kutsu automaattisesti launch metodia
	public void init() {
		tervehdysModel_IF malli = new tervehdysModel();
		kontrolli = new tervehdysKontrolli(this, malli);		
		
	}
	
	// käynnistää valikoima
	@Override
	public void start(Stage primaryStage) {
		
		try {
			primaryStage.setTitle("Tervehdys");
			
			aamuB = new Button("Aamu");
			aamuB.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					// kutsu aamu
					kontrolli.aamu();					
				}				
			});
			
			paivaB = new Button("Päivä");
			paivaB.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					kontrolli.paiva();					
				}				
			});
			
			iltaB = new Button("Ilta");
			iltaB.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					kontrolli.ilta();					
				}				
			});
			
			yoB = new Button("Yö");
			yoB.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					kontrolli.yo();					
				}				
			});
			
			selite = new Label("Napsauta painiketta");
			
			GridPane grid = new GridPane();
			
			grid.setAlignment(Pos.BASELINE_CENTER);
			grid.setVgap(20);
			grid.setHgap(10);
			
			grid.add(aamuB, 0, 0);
			grid.add(paivaB, 0, 1);
			grid.add(iltaB, 1,0);
			grid.add(yoB, 1, 1);
			grid.add(selite, 0, 2);
			
			Scene scene = new Scene(grid,190,110);
			primaryStage.setScene(scene);
			primaryStage.show();

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setTervehdys(String terehdys) {
		this.selite.setText(terehdys);
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	

}
