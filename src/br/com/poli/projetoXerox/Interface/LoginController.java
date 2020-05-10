package br.com.poli.projetoXerox.Interface;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

import javafx.collections.FXCollections;

import br.com.poli.projetoXerox.Interface.Categoria;
import br.com.poli.projetoXerox.exceptions.AutenticaçãoException;
import br.com.poli.projetoXerox.exceptions.CampoNãoInformadoException;

import br.com.poli.projetoXerox.repositorio.RepositorioAluno;
import br.com.poli.projetoXerox.repositorio.RepositorioFuncionario;
import br.com.poli.projetoXerox.repositorio.RepositorioProfessor;
import br.com.poli.projetoXerox.sistema.*;


public class LoginController implements Initializable {

	@FXML
	private TextField txtLogin;

	@FXML
	private PasswordField txtSenha;

	@FXML
	private Button bConfirmar;

	@FXML
	private Button bCriarContaAluno;
	
	@FXML
	private Button bCriarContaProfessor;

	@FXML
	private ComboBox<Categoria> categorias;

    @FXML
    private Text texto;
    
    @FXML
    public static Object variavelSistema;
    
    @FXML
    public static Professor p;
    
    @FXML
    public static Aluno a;
    
    @FXML
    public static Funcionario f;
    
    @FXML
	public static String tipo =  "aluno";

	@FXML
	private ObservableList<Categoria> obsCategorias;

	@FXML
	private List<Categoria> categoria = new ArrayList<>();

    @FXML
    private Button bEsqueceuSenha;

	@FXML
	public void cOK(ActionEvent event) throws IOException{
		
		int categoriaSelecionada = categorias.getSelectionModel().getSelectedIndex();

		if (categoriaSelecionada == 1) {
			SistemaAluno sa = new SistemaAluno();
			RepositorioAluno ra = new RepositorioAluno();
			try{
				if (sa.login(this.txtLogin.getText(), this.txtSenha.getText())==true) {
					a = ra.autenticaSenhaAluno(this.txtLogin.getText(), this.txtSenha.getText()); //o proprio logado
					variavelSistema = new Aluno(); //variavel sistema sofre atribuicao de aluno, professor ou funcinario no login
					try {
						new TelaSecundaria("MenuAluno.fxml").start(TelaInicial.stage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			catch(AutenticaçãoException e){
				abrirAlert();
			}
			catch(CampoNãoInformadoException e){
				abrirAlertCampos();
			}
		}
		else if (categoriaSelecionada == 0) {
			try{
				SistemaProfessor sp = new SistemaProfessor();	
				RepositorioProfessor rp = new RepositorioProfessor();
				if (sp.login(this.txtLogin.getText(), this.txtSenha.getText())) {
					p=rp.autenticaSenhaProfessor(this.txtLogin.getText(), this.txtSenha.getText()); //o proprio logado
					variavelSistema=new Professor();//variavel sistema sofre atribuicao de aluno, professor ou funcinario no login
					try{
						new TelaSecundaria("MenuProfessor.fxml").start(TelaInicial.stage);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			catch(AutenticaçãoException e){
				abrirAlert();
			}
			catch(CampoNãoInformadoException e){
				abrirAlertCampos();
			}
		}
		else if (categoriaSelecionada == 2) {
			try{
				SistemaFuncionario sf = new SistemaFuncionario();	
				RepositorioFuncionario rf = new RepositorioFuncionario();
				if (sf.login(this.txtLogin.getText(), this.txtSenha.getText())) {
					f=rf.autenticaSenhaFuncionario(this.txtLogin.getText(), this.txtSenha.getText());
					variavelSistema = new Funcionario();
					try{
						new TelaSecundaria("MenuFuncionario.fxml").start(TelaInicial.stage);
					} 
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			catch(AutenticaçãoException e) {
				abrirAlert();
			}
			catch(CampoNãoInformadoException e){
				abrirAlertCampos();
			}
		}
		
		//Caso não digitem nada na tela de login
		if(this.txtSenha.getText().isEmpty() || this.txtLogin.getText().isEmpty()){
			abrirAlertBranco();
		}

	}
	
	
	

	@FXML
	public void cCriarContabCriarContaProfessor(ActionEvent event) throws Exception {

		try {
			new TelaSecundaria("CriarContaProfessor.fxml").start(TelaInicial.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	public void cCriarContabCriarContaAluno(ActionEvent event) throws Exception {

		try {
			new TelaSecundaria("CriarContaAluno.fxml").start(TelaInicial.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void carregarCategoria() {
		Categoria categoria1 = new Categoria("Professor");
		Categoria categoria2 = new Categoria("Aluno");
		Categoria categoria3 = new Categoria("Funcionário");

		categoria.add(categoria1);
		categoria.add(categoria2);
		categoria.add(categoria3);

		obsCategorias = FXCollections.observableArrayList(categoria);

		categorias.setItems(obsCategorias);
		
	}

	void abrirAlert() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Erro de autenticação");
		alert.setHeaderText("Login e senha inválidos!");
		alert.setContentText("Escreva seus dados corretamente,crie uma conta caso não possua, ou selecione a categoria correta.");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
	
	void abrirAlertCampos() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erro 404! Informações não encontradas");
		alert.setHeaderText("Preencha corretamente os campos.");
		alert.setContentText("Informações Inválidas! Digite novamente.");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
	
	
	void abrirAlertBranco() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Digite algo!");
		alert.setHeaderText("Preencha corretamente os campos");
		alert.setContentText("Dados não informados! Por favor, para sucesso do programa, digite suas informações.");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:Imagens/icon.png"));
		stage.show();
		
    }
	
	@FXML
    void cEsqueceuSenha(ActionEvent event) {
		try {
			new TelaSecundaria("EsqueceuSenha.fxml").start(TelaInicial.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarCategoria();
	}
	
	}


