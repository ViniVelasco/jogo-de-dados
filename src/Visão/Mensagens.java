package Vis�o;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Mensagens {
	public static void nomeIncorreto(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Nome fora do tamanho definido");
		alert.setHeaderText(null);
		alert.setContentText("Confira o nome dos jogadores, existem nomes que est�o fugindo do padr�o determinado.");
		alert.showAndWait();
	}

}
