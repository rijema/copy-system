package br.com.poli.projetoXerox.Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class MenuAlunoController {

	@FXML
    private Button listaMaterial;

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
    void listaPedidosButton(ActionEvent event) throws Exception {
    	new TelaSecundaria("TelaHistoricoPedido.fxml").start(TelaInicial.stage);
    }

    @FXML
    void cSetNomeAluno(ActionEvent event) throws Exception {
    	new TelaSecundaria("AlterarNomeAluno.fxml").start(TelaInicial.stage);
    }

    @FXML
    void cSetSenha(ActionEvent event) throws Exception {
    	new TelaSecundaria("AlterarSenhaAluno.fxml").start(TelaInicial.stage);
    }

    @FXML
    void cSetUsuario(ActionEvent event) throws Exception {
    	new TelaSecundaria("AlterarLoginAluno.fxml").start(TelaInicial.stage);
    }

    @FXML
    void logOut(ActionEvent event) throws Exception {
    	new TelaSecundaria("Login.fxml").start(TelaInicial.stage);

    }

    @FXML
    void pedidosButton(ActionEvent event) throws Exception {
    	new TelaSecundaria("TelaMateriaisLista.fxml").start(TelaInicial.stage);
    }
    
    

}
