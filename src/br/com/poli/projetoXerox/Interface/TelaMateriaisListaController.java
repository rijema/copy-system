package br.com.poli.projetoXerox.Interface;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.com.poli.projetoXerox.sistema.Aluno;
import br.com.poli.projetoXerox.sistema.Material;
import br.com.poli.projetoXerox.sistema.Professor;
import br.com.poli.projetoXerox.sistema.SistemaMaterial;
import br.com.poli.projetoXerox.sistema.SistemaPedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TelaMateriaisListaController implements Initializable{
	
	@FXML
	private ListView<Material> lvCategorias;
	
	@FXML
	private SelectionModel<Material> smSelectionModel;
	
	@FXML
	private List<Material> categorias = new ArrayList<>();
   
	@FXML
    private TextField txtField;

	private ObservableList<Material> obsCategorias;
	
	@FXML
    private Button cButton;
	
    @FXML
    private Button cButton2;
	
	 @FXML
	 void cOk(ActionEvent event) throws Exception {
		 SistemaPedido sp = new SistemaPedido();
		 Material m = new Material();
		 m = lvCategorias.getSelectionModel().getSelectedItem();
		 if(lvCategorias.getSelectionModel().getSelectedItem()==null){
			abrirAlertWarning();
		 }
		 if (LoginController.variavelSistema instanceof Aluno) {
			int numPag = Integer.parseInt(this.txtField.getText());
			if(numPag == 0){
				abrirAlertCopias();
			}
			sp.cadastrarPedido(LoginController.a, numPag, m);
			abrirAlert();
	 	} else if (LoginController.variavelSistema instanceof Professor) {
	 		int numPag = Integer.parseInt(this.txtField.getText());
	 		sp.cadastrarPedido(LoginController.p, numPag, m);
	 		if(numPag == 0){
				abrirAlertCopias();
			}
	 		abrirAlert();
	 	}
	 }
	
	@FXML
	void cReturn(ActionEvent event) throws Exception {
		if (LoginController.variavelSistema instanceof Professor) {
			new TelaSecundaria("MenuProfessor.fxml").start(TelaInicial.stage);
		} else if (LoginController.variavelSistema instanceof Aluno) {
			new TelaSecundaria("MenuAluno.fxml").start(TelaInicial.stage);
				
		}
	}
	 
	public void carregarCategorias () throws IOException {
		
		SistemaMaterial sm = new SistemaMaterial();	
		obsCategorias = FXCollections.observableArrayList(sm.listaMaterial());
		lvCategorias.setItems(obsCategorias);
			
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

			try {
				carregarCategorias();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	void abrirAlertWarning() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Erro 907 material não selecionado!");
		alert.setHeaderText("Voçê não selecionou nenhum material para pedir");
		alert.setContentText("Selecione algo para continuar");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
	
	void abrirAlertCopias(){
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Erro 404! Nímero de cópias não encontrado");
		alert.setHeaderText("Voçê não escolheu um número de cópias para esse pedido");
		alert.setContentText("Especifique a quantidade de cópias para continuar");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
	}
	
	void abrirAlert() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Sucesso!");
		alert.setHeaderText("Seu pedido foi feito.");
		alert.setContentText("Caso queira fazer outro pedido, repita o procedimento.");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
	
}
