package Controle;

import java.net.URL;
import java.util.ResourceBundle;

import Visão.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController implements Initializable {

	   @FXML
	    private AnchorPane AnchorPane;

	    @FXML
	    private Button btnIniciar;

	    @FXML
	    private Button btnConsultaNumero;

	    @FXML
	    private Button btnConsultaNome;

	    @FXML
	    private Button btnSair;
	    
	    protected static Stage menu;

	    @FXML
	    void consultaNomeClick(ActionEvent event) {

	    }

	    @FXML
	    void consultaNumeroClick(ActionEvent event) {

	    }

	    @FXML
	    void iniciarClick(ActionEvent event) {
	    	Stage palco = new Stage();
	    	try {
				 URL arquivoFXML = getClass().getResource("/Visão/MenuIniciarJogo.fxml");
				 Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
				 MenuController.menu = palco;
				 palco.initStyle(StageStyle.UNDECORATED);
				 palco.setScene(new Scene(fxmlParent));
				 palco.setTitle("Menu de Tipo do Jogo");
				 palco.show();
				 Main.myStage.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}

	    

	    @FXML
	    void sairClick(ActionEvent event) {
	    	System.exit(0);
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}

}
