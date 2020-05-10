package br.com.poli.projetoXerox.Interface;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import br.com.poli.projetoXerox.sistema.Professor;
import br.com.poli.projetoXerox.sistema.SistemaProfessor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;

public class TelaProfessoresListaController implements Initializable{
	@FXML
	private Button cButton;
	
	@FXML
	private ListView<Professor> lvCategorias;
	@FXML
	private SelectionModel<Professor> smSelectionModel;
	@FXML
	private List<Professor> categorias = new ArrayList<>();
	
	private ObservableList<Professor> obsCategorias;


	@FXML
	public void cReturn(ActionEvent event) throws Exception {
		new TelaSecundaria("MenuFuncionario.fxml").start(TelaInicial.stage);
	}

	public void carregarCategorias () throws IOException {
		
		SistemaProfessor sp = new SistemaProfessor();
		obsCategorias = FXCollections.observableArrayList(sp.listarProfessores());		
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
