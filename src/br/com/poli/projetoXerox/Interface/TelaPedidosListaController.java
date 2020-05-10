package br.com.poli.projetoXerox.Interface;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.com.poli.projetoXerox.sistema.Aluno;
import br.com.poli.projetoXerox.sistema.Pedido;
import br.com.poli.projetoXerox.sistema.Professor;
import br.com.poli.projetoXerox.sistema.SistemaPedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TelaPedidosListaController implements Initializable{
	
	@FXML
	private ListView<Pedido> lvCategorias;
	
	@FXML
	private SelectionModel<Pedido> smSelectionModel;
	
	@FXML
	private List<Pedido> categorias = new ArrayList<>();

	private ObservableList<Pedido> obsCategorias;
	
	@FXML
    private Button cButton;
	
    @FXML
    private Button cButton1;
	
    @FXML
    private Button cButton2;
	
	 @FXML
	 void cOk(ActionEvent event) throws Exception {
		 if(lvCategorias.getSelectionModel().getSelectedItem()==null){
				abrirAlertWarning();
		 }
		 SistemaPedido sp = new SistemaPedido();
		 sp.alterarStatusPedidoParaFeito(lvCategorias.getSelectionModel().getSelectedItem());
		 new TelaSecundaria("TelaPedidosLista.fxml").start(TelaInicial.stage);	 
	 }
	
	@FXML
	void cReturn(ActionEvent event) {
		try{
    		new TelaSecundaria("MenuFuncionario.fxml").start(TelaInicial.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}	
    	
	}
	
	void abrirAlertWarning() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Erro 907! Material não selecionado!");
		alert.setHeaderText("Você não selecionou nenhum material para pedir");
		alert.setContentText("Selecione algo para continuar");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
	 
	public void carregarCategorias () throws IOException {		
		SistemaPedido sp = new SistemaPedido();
		obsCategorias = FXCollections.observableArrayList(sp.listarPedidosPendentes());		
		lvCategorias.setItems(obsCategorias);	
	}
	
    @FXML
    void cPago(ActionEvent event) throws Exception {
    	if(lvCategorias.getSelectionModel().getSelectedItem()==null){
			abrirAlertWarning();
		}
    	SistemaPedido sp = new SistemaPedido();
		sp.alterarStatusPedidoParaPago(lvCategorias.getSelectionModel().getSelectedItem());
		new TelaSecundaria("TelaPedidosLista.fxml").start(TelaInicial.stage);
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

			try {
				carregarCategorias();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
