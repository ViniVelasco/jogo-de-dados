package Visão;
	
import java.net.URL;
import java.util.Locale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	public static Stage myStage;
	@Override
	public void start(Stage palco) {
		try {
			 URL arquivoFXML = getClass().getResource("Menu.fxml");
			 Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
			 Main.myStage = palco;
			 palco.setScene(new Scene(fxmlParent));
			 palco.setTitle("Jogo de Dados");
			 palco.show();
			 Locale.setDefault(Locale.US);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}
