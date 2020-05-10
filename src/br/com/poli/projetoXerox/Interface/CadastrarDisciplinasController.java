package br.com.poli.projetoXerox.Interface;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CadastrarDisciplinasController {

    @FXML
    private Button bConfirmar;

    @FXML
    private TextField txtDisciplina;

    @FXML
    private Text texto;

    @FXML
    private Button bVoltar;

    @FXML
    void actionReturn(ActionEvent event) {
    	
    }

    @FXML
    void cOK(ActionEvent event) {
    	//SistemaProfessor sp = new SistemaProfessor();
    	//sp.cadastrarDisciplinas(txtDisciplina.getText());
    }

}
