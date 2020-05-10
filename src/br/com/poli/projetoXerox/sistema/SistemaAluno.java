package br.com.poli.projetoXerox.sistema;

import java.io.IOException;
import java.util.ArrayList;
import br.com.poli.projetoXerox.exceptions.AlterarAtributoException;
import br.com.poli.projetoXerox.exceptions.Autentica��oException;
import br.com.poli.projetoXerox.exceptions.CampoN�oInformadoException;
import br.com.poli.projetoXerox.exceptions.ContaExistenteException;
import br.com.poli.projetoXerox.exceptions.CpfInv�lidoException;
import br.com.poli.projetoXerox.exceptions.DividaPendenteException;
import br.com.poli.projetoXerox.repositorio.*;

public class SistemaAluno {
	
	/*
	 * Cadastra o aluno nos arquivos (cria conta)
	 */
	public void cadastrarAluno (String nome, String cpf, String senha) throws IOException, ContaExistenteException, CampoN�oInformadoException {
		if(nome.equals("")||cpf.equals("")||senha.equals("")){
			throw new CampoN�oInformadoException();
		}
		if (cpf.matches("[0-9]*")==false) {
			throw new CpfInv�lidoException();
		}
		Aluno a = new Aluno(nome, cpf, senha);
		RepositorioAluno repAluno = new RepositorioAluno();
		
		if (repAluno.disponibilidadeContaAluno(a.getCPF())==true) {
			a.criarUser();
			long i=repAluno.tamanhoBanco();
			a.setId(i);
			repAluno.adicionarAluno(i, a);
		} else {
			throw new ContaExistenteException();
		}
	}
	
	/*
	 * Retorna se logou com sucesso
	 */
	public boolean login (String user, String senha) throws IOException, Autentica��oException, CampoN�oInformadoException {
		if(user.equals("")||senha.equals("")){
			throw new CampoN�oInformadoException();
		}
		RepositorioAluno repAluno = new RepositorioAluno();
		if ((repAluno.autenticaSenhaAluno(user, senha)!=null)) {
			return true;
		} 
		else {
			throw new Autentica��oException();
		}
		
	}
	
	/*
	 * Retorna se logou com sucesso
	 */
	public void alterarSenhaAluno (String user, String senha, String novaSenha) throws IOException, AlterarAtributoException, CampoN�oInformadoException {
		if(user.equals("")||senha.equals("")||novaSenha.equals("")){
			throw new CampoN�oInformadoException();
		}
		RepositorioAluno repAluno = new RepositorioAluno();
		Aluno a = new Aluno("", "00000000000", "");
		if (repAluno.autenticaSenhaAluno(user, senha)!=null) {
			a=repAluno.autenticaSenhaAluno(user, senha);
			a.setSenha(novaSenha);
			repAluno.editarAluno(a.getId(), a);
		} else {
			throw new AlterarAtributoException();
		}
	}
	
	/*
	 * M�todo para alterar nome de usu�rio
	 */
	public void alterarLoginAluno(String user, String senha, String novoLogin) throws CampoN�oInformadoException, IOException, AlterarAtributoException{
		if(user.equals("")||senha.equals("")||novoLogin.equals("")){
			throw new CampoN�oInformadoException();
		}
		RepositorioAluno repAluno = new RepositorioAluno();
		Aluno a = new Aluno("", "00000000000", "");
		if (repAluno.autenticaSenhaAluno(user, senha)!=null) {
			a=repAluno.autenticaSenhaAluno(user, senha);
			a.setUsuario(novoLogin);
			repAluno.editarAluno(a.getId(), a);
		} else {
			throw new AlterarAtributoException();
		}
	}
	
	/*
	 * M�todo para alterar nome
	 */
	public void alterarNomeAluno (String user, String senha, String novoNome) throws IOException, AlterarAtributoException, CampoN�oInformadoException {
		if(user.equals("")||senha.equals("")||novoNome.equals("")){
			throw new CampoN�oInformadoException();
		}
		RepositorioAluno repAluno = new RepositorioAluno();
		Aluno a = new Aluno("", "00000000000", "");
		if (repAluno.autenticaSenhaAluno(user, senha)!=null) {
			a=repAluno.autenticaSenhaAluno(user, senha);
			a.setNome(novoNome);
			repAluno.editarAluno(a.getId(), a);
		} else {
			throw new AlterarAtributoException();
		}
	}
	
	
	/*
	 * Altera o atributo listaPedidos do aluno e adiciona o pedido
	 */
	public Aluno adicionarArrayPedido (String cpf, Material m) throws IOException, DividaPendenteException {
		RepositorioAluno repAluno = new RepositorioAluno();
		Aluno a = new Aluno("", "00000000000", "");
		if(repAluno.buscarPeloCpf(cpf)!=null) {
			a=repAluno.buscarPeloCpf(cpf);
			a.fazerPedido(1, m);
			repAluno.editarAluno(a.getId(), a);
			return a;
		} else {
			return null;
		}
		
	}
	
	/*
	 * Lista todos os alunos cadastrados no sistema
	 */
	public ArrayList<Aluno> listarAlunos () throws IOException {
		RepositorioAluno repAluno = new RepositorioAluno();
		ArrayList<Aluno> p = new ArrayList<Aluno>();
		for (long i=0; i<repAluno.tamanhoBanco(); i++) {
			p.add((Aluno) repAluno.leituraDados(i));
		}
		return p;
	}
	
}
