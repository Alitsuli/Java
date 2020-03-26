package View;

import java.util.ArrayList;

import Controller.noppaKontrolli;
import Controller.noppaKontrolli_IF;
import Model.noppaModel;
import Model.noppaModel_IF;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class noppaGUI extends Application implements noppaGUI_IF{
	
	private noppaKontrolli_IF kontrolleri;

	private Button heittoBtn; 	
	private Text silmaluku;
	private Text heitot;
	private Text viisi;
	private Text summa;
	

	//t.6
	private Image nappi1 = new Image("https://upload.wikimedia.org/wikipedia/commons/0/0a/Dicey-1.png");
	private Image nappi2 = new Image("https://upload.wikimedia.org/wikipedia/commons/5/53/Dicey-2.png");
	private Image nappi3 = new Image("https://upload.wikimedia.org/wikipedia/commons/a/a3/Dicey-3.png");
	private Image nappi4 = new Image("https://upload.wikimedia.org/wikipedia/commons/7/7b/Dicey-4.png");
	private Image nappi5 = new Image("https://upload.wikimedia.org/wikipedia/commons/4/4b/Dicey-5.png");
	private Image nappi6 = new Image("https://upload.wikimedia.org/wikipedia/commons/f/fe/Dicey-6.png");
	private ImageView kuvake;

	

	@Override

	public void init() {
		kontrolleri = new noppaKontrolli(this);
	}

	

	@Override
	public void start(Stage primaryStage) {
		try {


			primaryStage.setTitle("Noppa - MVC");
			
			silmaluku = new Text();
			heitot = new Text();
			viisi = new Text();
			summa = new Text();
			
			kuvake = new ImageView();
			kuvake.setFitWidth(90);
			kuvake.setFitHeight(90);
			
			heittoBtn = new Button("Heitä Noppa!");
			heittoBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {

					kontrolleri.arvoSilmaluku();
					kontrolleri.annaHeitot();
					//kontrolleri.annaViisiNoppaa(); 	//t.4
					//kontrolleri.annaSumma();	//t.4
				}
			});


			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(20);
			
			grid.add(heittoBtn,2,1);	
			grid.add(silmaluku,0,1);
			grid.add(heitot, 1, 1);
			//grid.add(viisi,0,1);
			//grid.add(summa, 1, 1);
			grid.add(kuvake, 0, 0); //t.6
			


			Scene scene = new Scene(grid, 300, 200);
	        primaryStage.setScene(scene);
	        primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	

	@Override

	public void setSilmaluku(int silmaluku) {
		//.t4
		//String lukutxt = String.format("Nopsta tuli: "+"%d", silmaluku);
		//this.silmaluku.setText(lukutxt);
		
		//t.6
		if(silmaluku == 1) {
			this.kuvake.setImage(nappi1);
			String lukutxt = String.format("\nTulos: "+"%d", silmaluku);
			this.silmaluku.setText(lukutxt);
		}else if(silmaluku == 2) {
			this.kuvake.setImage(nappi2);
			String lukutxt = String.format("\nTulos: "+"%d", silmaluku);
			this.silmaluku.setText(lukutxt);
		}else if(silmaluku == 3) {
			this.kuvake.setImage(nappi3);
			String lukutxt = String.format("\nTulos: "+"%d", silmaluku);
			this.silmaluku.setText(lukutxt);
		}else if(silmaluku == 4) {
			this.kuvake.setImage(nappi4);
			String lukutxt = String.format("\nTulos: "+"%d", silmaluku);
			this.silmaluku.setText(lukutxt);
		}else if(silmaluku == 5) {
			this.kuvake.setImage(nappi5);
			String lukutxt = String.format("\nTulos: "+"%d", silmaluku);
			this.silmaluku.setText(lukutxt);
		}else if(silmaluku == 6) {
			this.kuvake.setImage(nappi6);
			String lukutxt = String.format("\nTulos: "+"%d", silmaluku);
			this.silmaluku.setText(lukutxt);
		}
		
		
	}

	

	@Override

	public void setHeitot(int heitot) {
		String heitottxt = String.format("\nHeittokertoja: "+"%d", heitot);
		this.heitot.setText(heitottxt);
	}
	// t. 4
	@Override
	public void setViisiNoppaa(String viisiNoppaa) {
		this.viisi.setText(viisiNoppaa);
	}
	// t. 4
	@Override
	public void setSumma(int summa) {
		String summatxt = String.format("summa: "+"%d", summa);
		this.summa.setText(summatxt);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
