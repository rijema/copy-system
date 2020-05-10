package br.com.poli.projetoXerox.Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TelaSecundaria extends Application {

	public static Stage stage;
	public static String link;

	public TelaSecundaria(String valor) {
		this.link = valor;
	}

	public static void main(String[] args) {
		launch(TelaInicial.class);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Parent root = FXMLLoader.load(getClass().getResource(link));

		Scene scene = new Scene(root);

		TelaSecundaria.stage = primaryStage;
		stage.setScene(scene);
		stage.setTitle("Gerenciamento de Cópias");
		stage.getIcons().add(new Image("file:Imagens/icon.png"));	
		primaryStage.setWidth(600);
		primaryStage.setHeight(400);
		stage.setResizable(false);
		stage.show();
	}

	/**
	 * @return the link
	 */ //Usuário vai setar uma outra Stage
	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

}
