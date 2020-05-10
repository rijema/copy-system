package br.com.poli.projetoXerox.Interface;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import br.com.poli.projetoXerox.sistema.Aluno;
import br.com.poli.projetoXerox.sistema.Pedido;
import br.com.poli.projetoXerox.sistema.Professor;
import br.com.poli.projetoXerox.sistema.SistemaAluno;
import br.com.poli.projetoXerox.sistema.SistemaPedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TelaHistoricoPedido implements Initializable{
	@FXML
	private Button cButton2;
	@FXML
	private Button cButton;
	@FXML
	private ListView<Pedido> lvCategorias;
	@FXML
	private SelectionModel<Pedido> smSelectionModel;
	@FXML
	private List<Pedido> categorias = new ArrayList<>();
	@FXML
	private ObservableList<Pedido> obsCategorias;
    @FXML
    private Label preco;	

	@FXML
	public void cOk(ActionEvent event) throws Exception {
		SistemaPedido sp = new SistemaPedido();
		Pedido p = new Pedido();
		p=lvCategorias.getSelectionModel().getSelectedItem();
		if(lvCategorias.getSelectionModel().getSelectedItem()==null){
			abrirAlertWarning();
		}
		if(p.getStatus()==false) {
			abrirAlertError();
		} else {
			sp.cancelarPedido(p);
			abrirAlert();
			new TelaSecundaria("TelaHistoricoPedido.fxml").start(TelaInicial.stage);
		}
		


	}

	@FXML
	public void cReturn(ActionEvent event) throws Exception {
		if (LoginController.variavelSistema instanceof Aluno) {
			new TelaSecundaria("MenuAluno.fxml").start(TelaInicial.stage);
		} else if (LoginController.variavelSistema instanceof Professor) {
			new TelaSecundaria("MenuProfessor.fxml").start(TelaInicial.stage);
		}
	}


	public void carregarCategorias () throws IOException {
		
		SistemaPedido sp = new SistemaPedido();
		if (LoginController.variavelSistema instanceof Aluno) {
			obsCategorias = FXCollections.observableArrayList(sp.listarPedidosAluno(LoginController.a));
		} else if (LoginController.variavelSistema instanceof Professor) {
			obsCategorias = FXCollections.observableArrayList(sp.listarPedidosProfessor(LoginController.p));
		}
		lvCategorias.setItems(obsCategorias);	
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			carregarCategorias();
			preco();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	void abrirAlert() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Sucesso!");
		alert.setHeaderText("Seu pedido foi cancelado!");
		alert.setContentText("Lista atualizada!");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
	
	void abrirAlertWarning() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Erro 704 pedido não selecionado!");
		alert.setHeaderText("Voçê não selecionou nenhum pedido para cancelar");
		alert.setContentText("Selecione algo para continuar");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }

	void abrirAlertError() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erro!");
		alert.setHeaderText("Você não pode cancelar um pedido que já está impresso ou pago.");
		alert.setContentText("Lista atualizada.");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }

	 @FXML
	 public void preco() throws IOException {
		 SistemaPedido sp = new SistemaPedido();
		 if(LoginController.variavelSistema instanceof Aluno) {
			 preco.setText(sp.dividaAluno(LoginController.a));
		 } else if (LoginController.variavelSistema instanceof Professor) {
			 preco.setText(sp.dividaProfessor(LoginController.p));
		 }
		 preco.setVisible(true);
	 }

}
