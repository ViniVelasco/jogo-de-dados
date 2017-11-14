package Controle;
import java.net.URL;

import Visão.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MenuTipoJogoController {

    @FXML
    private Button jogoPadrao;

    @FXML
    private Button jogoAleatorio;
    
    @FXML
    private Button btnSair;
    
    protected static Stage menuTipo;

    @FXML
    void jogoAleatorioClick(ActionEvent event) {
    	

    }

    @FXML
    void jogoPadraoClick(ActionEvent event) {
    	 Stage palco = new Stage();
    	 try {
    	 URL arquivoFXML = getClass().getResource("/Visão/IniciarJogoPadrao.fxml");
		 Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
		 menuTipo = palco;
		 palco.initStyle(StageStyle.UNDECORATED); //tirando opções superiores do menu
		 palco.setScene(new Scene(fxmlParent)); 
		 palco.setTitle("Configuração do Jogo");
		 palco.show();
		 MenuController.menu.close();
    	 } catch(Exception e) {
				e.printStackTrace();
			}
			
	}
    
    @FXML
    void sairClick(ActionEvent event) {
    	MenuController.menu.close();
    	Main.myStage.show();
    }

}
