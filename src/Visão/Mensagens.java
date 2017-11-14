package Visão;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Mensagens {
	public static void nomeIncorreto(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Nome fora do tamanho definido");
		alert.setHeaderText(null);
		alert.setContentText("Confira o nome dos jogadores, existem nomes que estão fugindo do padrão determinado.");
		alert.showAndWait();
	}

}
