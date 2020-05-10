package br.com.poli.projetoXerox.Interface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import br.com.poli.projetoXerox.exceptions.CampoN�oInformadoException;
import br.com.poli.projetoXerox.sistema.SistemaMaterial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PedidosController implements Initializable {
	
	
	    @FXML
	    private Button bConfirmar;

	    @FXML
	    private TextField txtTitulo;

	    @FXML
	    private TextField txtNumPag;
	    
	    @FXML
	    private TextField txtDisciplina;

	    @FXML
	    private Label labelPreco;
	    
	    

	    @FXML
	    void cOK(ActionEvent event) throws IOException{
	    	
	    	SistemaMaterial sm = new SistemaMaterial();
	    	int numPag =  Integer.parseInt(this.txtNumPag.getText());
	    	try{
	    		sm.cadastrarMaterial(LoginController.p,this.txtDisciplina.getText(), txtTitulo.getText(), numPag);
	    		abrirAlert();
	    		try{
	    			new TelaSecundaria("MenuProfessor.fxml").start(TelaInicial.stage);	    		
	    		}
	    		catch(Exception e){
	    			e.printStackTrace();
	    		}
	    	}
	    	catch(CampoN�oInformadoException e){
	    		abrirAlertCampos();
	    	}
	    }
	    
	    @FXML
	    public void actionReturn(ActionEvent event) throws Exception {
	    	
	    	try{
	    		new TelaSecundaria("MenuProfessor.fxml").start(TelaInicial.stage);
			} catch (Exception e) {
				e.printStackTrace();
			}	
	    	
	    }
	    
	    void abrirAlertCampos() {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erro 404! Informa��es n�o encontradas");
			alert.setHeaderText("Preencha corretamente os campos.");
			alert.setContentText("Informa��es Inv�lidas! Digite novamente.");
			Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image("file:Imagens/icon.png"));
			stage.show();
			
	    }
	    
	    void abrirAlert() {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Conclu�do!");
			alert.setHeaderText("Seu material foi enviado!");
			alert.setContentText("Voc� ser� redirecionado ao menu para escolher novamente uma op��o.");
			Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image("file:Imagens/icon.png"));
			stage.show();
			
	    }
	    
	    
	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
		}
	

}
