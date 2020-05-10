package br.com.poli.projetoXerox.Interface;

import java.io.IOException;

import br.com.poli.projetoXerox.exceptions.AlterarAtributoException;
import br.com.poli.projetoXerox.exceptions.CampoNãoInformadoException;
import br.com.poli.projetoXerox.sistema.SistemaAluno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlterarSenhaAlunoController {

    @FXML
    private Button bConfirmar;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtLogin;

    @FXML
    private Text texto;
    
    @FXML
    private PasswordField txtNovaSenha;

    @FXML
    private Button bVoltar;

    @FXML
    void cOK(ActionEvent event) throws IOException{
    	SistemaAluno sa = new SistemaAluno();
    	try{
    		sa.alterarSenhaAluno(txtLogin.getText(), txtSenha.getText(), txtNovaSenha.getText());
    		abrirAlertSucesso();
    		try {
    			new TelaSecundaria("MenuAluno.fxml").start(TelaInicial.stage);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	catch(AlterarAtributoException e){
    		abrirAlertErro();
    	}
    	catch(CampoNãoInformadoException e){
    		abrirAlertCampos();  	
    	}
    	
    }
    
    void abrirAlertCampos() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erro 404! Informações não encontradas");
		alert.setHeaderText("Preencha corretamente os campos.");
		alert.setContentText("Informações Inválidas! Digite novamente.");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
    }
    
    void abrirAlertSucesso() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Senha Alterada com Sucesso");
		alert.setHeaderText("Você será redirecionado para a tela de menu");
		alert.setContentText("Sua senha foi alterada com sucesso");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
    
    void abrirAlertErro() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erro 404! Informações não encontradas");
		alert.setHeaderText("Erro ao alterar senha");
		alert.setContentText("O login e/ou senha informados são inválidos para o seu usuário");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }

    @FXML
    void cRetornar(ActionEvent event) {
    	try{
    		new TelaSecundaria("MenuAluno.fxml").start(TelaInicial.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
