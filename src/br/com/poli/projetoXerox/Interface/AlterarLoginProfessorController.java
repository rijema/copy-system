package br.com.poli.projetoXerox.Interface;

import java.io.IOException;

import br.com.poli.projetoXerox.exceptions.AlterarAtributoException;
import br.com.poli.projetoXerox.exceptions.CampoNãoInformadoException;
import br.com.poli.projetoXerox.repositorio.RepositorioProfessor;
import br.com.poli.projetoXerox.sistema.SistemaProfessor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlterarLoginProfessorController {

    @FXML
    private Button bConfirmar;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtLogin;

    @FXML
    private Text texto;

    @FXML
    private Button bVoltar;

    @FXML
    private TextField txtNovoLogin;

    @FXML
    void cOK(ActionEvent event) throws IOException {
    	SistemaProfessor sp = new SistemaProfessor();
    	RepositorioProfessor ra = new RepositorioProfessor();
    	if(ra.disponibilidadeLoginProfessor(txtNovoLogin.getText())==true){
    		try{
    			sp.alterarLoginProfessor(txtLogin.getText(), txtSenha.getText(), txtNovoLogin.getText());
    			abrirAlert();
    			try {
    				new TelaSecundaria("MenuProfessor.fxml").start(TelaInicial.stage);
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
    	else{
    		abrirAlertIndisponivel();
    	}
    }
    
    void abrirAlert() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Login Alterado com Sucesso");
		alert.setHeaderText("Você será redirecionado para a tela de menu");
		alert.setContentText("Seu login foi alterado com sucesso");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
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
    
    void abrirAlertIndisponivel() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Login Solicitado Indisponivel");
		alert.setHeaderText("O login solicitado ja está em uso");
		alert.setContentText("Informe um login que ainda não esteja em uso");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
    
    void abrirAlertErro() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erro 404 usuario not found");
		alert.setHeaderText("Erro ao alterar o atributo nome");
		alert.setContentText("O login e/ou senha informados são inválidos para o seu usuário");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }

    @FXML
    void cRetornar(ActionEvent event) {
    	try{
    		new TelaSecundaria("MenuProfessor.fxml").start(TelaInicial.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
