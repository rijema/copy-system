package br.com.poli.projetoXerox.Interface;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.scene.control.MenuItem;

import javafx.scene.control.MenuButton;

public class MenuFuncionarioController implements Initializable{
	@FXML
	private Button pedirMaterial;
	@FXML
	private Button sair;
	@FXML
	private MenuButton mConfiguração;
	@FXML
	private MenuItem bAlterarNome;
	@FXML
	private MenuItem bAlterarUsuário;
	@FXML
	private MenuItem bAlterarSenha;
    @FXML
    private Button listarAlunos;
    @FXML
    private Button listarProfessores;

	// Event Listener on Button[#pedirMaterial].onAction
	@FXML
	public void pedirMaterial(ActionEvent event) throws Exception {
		try{
    		new TelaSecundaria("TelaPedidosLista.fxml").start(TelaInicial.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@FXML
	public void logOut(ActionEvent event) throws Exception {
		new TelaSecundaria("Login.fxml").start(TelaInicial.stage);
	}

    @FXML
    void listarAlunos(ActionEvent event) {
    	try{
    		new TelaSecundaria("TelaAlunosLista.fxml").start(TelaInicial.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}	
    }

    @FXML
    void listarProfessores(ActionEvent event) {
    	try{
    		new TelaSecundaria("TelaProfessoresLista.fxml").start(TelaInicial.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}	
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
