package br.com.poli.projetoXerox.sistema;

import java.io.IOException;
import java.util.ArrayList;

import br.com.poli.projetoXerox.exceptions.AlterarAtributoException;
import br.com.poli.projetoXerox.exceptions.Autentica��oException;
import br.com.poli.projetoXerox.exceptions.CampoN�oInformadoException;
import br.com.poli.projetoXerox.exceptions.ContaExistenteException;
import br.com.poli.projetoXerox.exceptions.CpfInv�lidoException;
import br.com.poli.projetoXerox.repositorio.*;



public class SistemaProfessor {
	
	/*
	 * Cadastra o professor nos arquivos (cria conta)
	 */
	public boolean cadastrarProfessor (String nome, String cpf, String senha, int qtdDisciplinas) throws IOException, ContaExistenteException, CampoN�oInformadoException {
		
		if(nome.equals("")||cpf.equals("")||senha.equals("")||qtdDisciplinas==0){
			throw new CampoN�oInformadoException();
		}
		if (cpf.matches("[0-9]*")==false) {
			throw new CpfInv�lidoException();
		}
		Professor p = new Professor(nome, cpf, senha, qtdDisciplinas);
		RepositorioProfessor repProfessor = new RepositorioProfessor();
		
		if (repProfessor.disponibilidadeContaProfessor(p.getCPF())) {
			p.criarUser();
			long i=repProfessor.tamanhoBanco();
			repProfessor.adicionarProfessor(i, p);
			return true;
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
		RepositorioProfessor repProfessor = new RepositorioProfessor();
		if ((repProfessor.autenticaSenhaProfessor(user, senha)!=null)) {
			return true;
		} 
		else {
			throw new Autentica��oException();
		}
	}
	
	/*
	 * Altera a senha de uma conta existente
	 */
	public void alterarSenhaProfessor (String user, String senha, String novaSenha) throws IOException, CampoN�oInformadoException, AlterarAtributoException {
		if(user.equals("")||senha.equals("")||novaSenha.equals("")){
			throw new CampoN�oInformadoException();
		}
		RepositorioProfessor repProfessor = new RepositorioProfessor();
		Professor p = new Professor("", "00000000000", "", 0);
		if (repProfessor.autenticaSenhaProfessor(user, senha)!=null) {
			p=repProfessor.autenticaSenhaProfessor(user, senha);
			p.setSenha(novaSenha);
			repProfessor.editarProfessor(p.getId(), p);
		} else {
			throw new AlterarAtributoException();
		}
	}
	
	public void alterarLoginProfessor(String user, String senha, String novoLogin) throws CampoN�oInformadoException, IOException, AlterarAtributoException{
		if(user.equals("")||senha.equals("")||novoLogin.equals("")){
			throw new CampoN�oInformadoException();
		}
		RepositorioProfessor repProfessor = new RepositorioProfessor();
		Professor p = new Professor("", "00000000000", "", 0);
		if (repProfessor.autenticaSenhaProfessor(user, senha)!=null) {
			p=repProfessor.autenticaSenhaProfessor(user, senha);
			p.setUsuario(novoLogin);
			repProfessor.editarProfessor(p.getId(), p);
		} else {
			throw new AlterarAtributoException();
		}
	}
	
	public void alterarNomeProfessor(String user, String senha, String novoNome) throws IOException, AlterarAtributoException, CampoN�oInformadoException {
		if(user.equals("")||senha.equals("")||novoNome.equals("")){
			throw new CampoN�oInformadoException();
		}
		RepositorioProfessor repProf = new RepositorioProfessor();
		Professor p = new Professor("", "00000000000", "",0);
		if (repProf.autenticaSenhaProfessor(user, senha)!=null) {
			p=repProf.autenticaSenhaProfessor(user, senha);
			p.setNome(novoNome);
			repProf.editarProfessor(p.getId(), p);
		} else {
			throw new AlterarAtributoException();
		}
	}

	public ArrayList<Professor> listarProfessores () throws IOException {
		RepositorioProfessor repProfessor = new RepositorioProfessor();
		ArrayList<Professor> p = new ArrayList<Professor>();
		for (long i=0; i<repProfessor.tamanhoBanco(); i++) {
			p.add((Professor) repProfessor.leituraDados(i));
		}
		return p;
	}

}
