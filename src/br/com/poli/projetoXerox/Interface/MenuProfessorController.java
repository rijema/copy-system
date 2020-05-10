package br.com.poli.projetoXerox.Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class MenuProfessorController {

    @FXML
    private Button cadastrarMaterial;

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
    private Button historicoPedidos;


    @FXML
    void cadastrarMaterial(ActionEvent event) throws Exception {
    	new TelaSecundaria("Pedidos.fxml").start(TelaInicial.stage);
    }
    
    @FXML
    void cSetNomeAluno(ActionEvent event) throws Exception {
    	new TelaSecundaria("AlterarNomeProfessor.fxml").start(TelaInicial.stage);
    }

    @FXML
    void cSetSenha(ActionEvent event) throws Exception {
    	new TelaSecundaria("AlterarSenhaProfessor.fxml").start(TelaInicial.stage);
    }

    @FXML
    void cSetUsuario(ActionEvent event) throws Exception {
    	new TelaSecundaria("AlterarLoginProfessor.fxml").start(TelaInicial.stage);
    }

    @FXML
    void logOut(ActionEvent event) throws Exception {
    	new TelaSecundaria("Login.fxml").start(TelaInicial.stage);

    }

    @FXML
    void pedirMaterial(ActionEvent event) throws Exception {
    	new TelaSecundaria("TelaMateriaisLista.fxml").start(TelaInicial.stage);

    }
    
    @FXML
    void historicoPedidos(ActionEvent event) throws Exception {
    	new TelaSecundaria("TelaHistoricoPedido.fxml").start(TelaInicial.stage);
    }

}
