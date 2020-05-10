package br.com.poli.projetoXerox.Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
/*import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane; */
import javafx.stage.Stage;
import java.io.IOException;

public class TelaInicial extends Application {

	public static Stage stage;
	
		public static void main(String[] args) {
			launch(TelaInicial.class);
		}

		@Override
		public void start(Stage primaryStage) throws IOException {
			// TODO Auto-generated method stub

			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			
			Scene scene = new Scene(root);
			
			TelaInicial.stage = primaryStage;
			stage.setScene(scene);
			stage.setTitle("Gerenciamento de Cópias");
			stage.getIcons().add(new Image("file:Imagens/icon.png"));
			stage.setWidth(600);
			stage.setHeight(400);
			stage.setResizable(false);
			stage.show();
		}
		
	}

