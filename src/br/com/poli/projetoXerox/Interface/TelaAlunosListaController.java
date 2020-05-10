package br.com.poli.projetoXerox.Interface;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.poli.projetoXerox.sistema.Aluno;
import br.com.poli.projetoXerox.sistema.SistemaAluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;

public class TelaAlunosListaController implements Initializable{

	@FXML
	private Button cButton2;
	@FXML
	private Button cButton;
	@FXML
	private ListView<Aluno> lvCategorias;
	@FXML
	private SelectionModel<Aluno> smSelectionModel;
	@FXML
	private List<Aluno> categorias = new ArrayList<>();
	
	private ObservableList<Aluno> obsCategorias;


	// Event Listener on Button[#cButton].onAction
	@FXML
	public void cReturn(ActionEvent event) throws Exception {
		new TelaSecundaria("MenuFuncionario.fxml").start(TelaInicial.stage);
	}
	
	public void carregarCategorias () throws IOException {
		
		SistemaAluno sa = new SistemaAluno();
		obsCategorias = FXCollections.observableArrayList(sa.listarAlunos());		
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


}
