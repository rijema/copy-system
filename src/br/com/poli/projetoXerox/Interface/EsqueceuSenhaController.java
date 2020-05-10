package br.com.poli.projetoXerox.Interface;

import java.io.IOException;

import br.com.poli.projetoXerox.exceptions.UsuarioNãoExistenteException;
import br.com.poli.projetoXerox.repositorio.Auxiliar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EsqueceuSenhaController {

    @FXML
    private Button bConfirmar;

    @FXML
    private TextField txtLogin;

    @FXML
    private Text texto;

    @FXML
    private Button bVoltar;

    @FXML
    void cOK(ActionEvent event) throws IOException{
    	
    	Auxiliar aux = new Auxiliar();
    	
    	try {
			abrirAlert(aux.recuperarSenha(txtLogin.getText()));
			
			try {
				new TelaSecundaria("Login.fxml").start(TelaInicial.stage);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
    	} 
    	catch (UsuarioNãoExistenteException e){
			abrirAlertErro();
		}
    }
    
    void abrirAlert(String novaSenha) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Senha Recuperada com Sucesso");
		alert.setHeaderText("Você será redirecionado para a tela de login");
		alert.setContentText("Você recebeu uma nova senha tempóraria que poderá ser alterada dentro do programa: "+ novaSenha);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
    
    void abrirAlertErro() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erro 404! Informações não encontradas");
		alert.setHeaderText("Erro ao recuperar senha");
		alert.setContentText("Não existe um usuário cadastrado com esse cpf!");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
    
    @FXML
    void actionReturn(ActionEvent event) {
    	try{
    		new TelaSecundaria("Login.fxml").start(TelaInicial.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
