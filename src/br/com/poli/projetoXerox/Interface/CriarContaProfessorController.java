package br.com.poli.projetoXerox.Interface;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import br.com.poli.projetoXerox.Interface.Categoria;
import br.com.poli.projetoXerox.exceptions.CampoNãoInformadoException;
import br.com.poli.projetoXerox.exceptions.ContaExistenteException;
import br.com.poli.projetoXerox.exceptions.CpfInválidoException;
import br.com.poli.projetoXerox.sistema.SistemaProfessor;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

	public class CriarContaProfessorController implements Initializable  {

	   	@FXML
	    private TextField txtLogin;
	    
	    @FXML
	    private CheckBox checkLi;
	    
	    @FXML
	    private TextField txtqtdMat;
	    
	    @FXML
	    private PasswordField txtSenha2;

	    @FXML
	    private ComboBox<Categoria> categorias;
	    
	    @FXML
	    private ObservableList<Categoria> obsCategorias;
	    
	    @FXML
	    private List<Categoria> categoria = new ArrayList<>();
	    
	    @FXML
	    private Label aceitarTermos;
	    
	    @FXML
	    private Button bVoltar;
	    
	    @FXML
	    private Button bConfirmar;
	    
	    @FXML
	    private TextField txtCPF;
	    
	    @FXML
	    private Button termosUso;
	   
	    
	    @FXML
	    public void actionGoFoward(ActionEvent event) throws IOException {
	    	
	    	if(checkLi.isSelected()) {	    			
	    		SistemaProfessor sp = new SistemaProfessor();
	    		final int valor =  Integer.parseInt(this.txtqtdMat.getText());
	    		
	    		try{
	   				sp.cadastrarProfessor(this.txtLogin.getText(),this.txtCPF.getText(), this.txtSenha2.getText(), valor);
	   				abrirAlert();
	   				try {
	   					new TelaSecundaria("Login.fxml").start(TelaInicial.stage);
	   				} catch (Exception e) {
	   					e.printStackTrace();
	   				}
	    		} 
	    		catch(ContaExistenteException e) {
	    			abrirAlertErro();
	    		}
	    		catch(CpfInválidoException e){
	    			abrirAlertCPF();
	    		}
	    		catch(CampoNãoInformadoException e){
	    			abrirAlertCampos();
	    		}
	    	}
	    	else {
	    		concordo();
	    	}
	    }
	    
	    void abrirAlertErro() {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erro 807! Usuário já cadasstrado");
			alert.setHeaderText("Erro ao cadastrar respectivo aluno");
			alert.setContentText("O arquivo da respectiva conta já existe no sistema!");
			Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image("file:Imagens/icon.png"));
			stage.show();
			
	    }
	    
	    @FXML
	    void abrirTermos(ActionEvent event) {
	    	 termosdeUsoAlert();

	    }
	    
	    @FXML
	    public void concordo() {

	    	if(checkLi.selectedProperty().getValue().equals(false)) {
	    	 aceitarTermos.setText("Você precisa aceitar os termos antes de continuar");
	    	}
	    	
	    }
	    
	    @FXML
	    public void actionReturn(ActionEvent event) throws Exception {
	    	
	    	try{
	    		new TelaSecundaria("Login.fxml").start(TelaInicial.stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    		
	    	
	    }
	    
	    @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	    	
	    }

	 void abrirAlert() {
	    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    alert.setTitle("Seja bem vindo ao Sistema");
	    alert.setHeaderText("Você será redirecionado para a tela de login");
	    alert.setContentText("Obrigado por utilizar nosso programa!");
	    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
	    stage.getIcons().add(new Image("file:Imagens/icon.png"));
	    stage.show();
	   }
	
	void abrirAlertCPF() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("CPF INVÁLIDO!");
		alert.setHeaderText("Formato de CPF não existente.");
		alert.setContentText("Digite novamente.");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
	
	void abrirAlertCampos() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("INFORMAÇÕES INVÁLIDAS!");
		alert.setHeaderText("Preencha corretamente os campos.");
		alert.setContentText("Digite novamente.");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
	
	void termosdeUsoAlert() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("TERMOS DE USO");
		alert.setHeaderText("Segue os termos de uso do Sistema:");
		alert.setContentText("Você está sendo vigiado");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
	}
	    
}


