package br.com.poli.projetoXerox.repositorio;
import java.io.*;
import br.com.poli.projetoXerox.arquivos.*;
import br.com.poli.projetoXerox.sistema.Professor;



public class RepositorioProfessor extends Arquivos{
	

	private static final long serialVersionUID = 1L;

	public RepositorioProfessor() {
		this.setBanco("PastaProfessor\\");
		this.setArquivo("Professor");
	}
	
	/*
	 * Método armazena novo professor nos arquivos.
	 */
	public Professor adicionarProfessor(long idPessoa,Professor professor) throws IOException
	{		
		professor = (Professor)armazenaDados(professor, idPessoa);
		return professor;
	}
	
	/*
	 * Abre o arquivo para alteração
	 */
	public Professor editarProfessor(long idPessoa, Professor professor) throws IOException
	{		
		professor = (Professor)editarArquivo(professor, idPessoa);
		return professor;
	}
	
	/*
	 * Verifica se já existe alguma conta com esse cpf
	 */
	public boolean disponibilidadeContaProfessor (String cpf) throws IOException {
		Professor b = new Professor("", "00000000000", "", 0);
		
		for (long i=0; i<this.tamanhoBanco(); i++) {
			b = (Professor) buscarArquivoPorId(i);
			if(b.getCPF().equals(cpf)) {
				return false;
			} else {
				
			}
			
		}
		return true;
	}
	
	/*
	 * Verifica a existência de um nome de um nome de usuário já criado.
	 */
	public boolean disponibilidadeLoginProfessor (String login) throws IOException {
		Professor p = new Professor("", "00000000000", "", 0);
		if (this.tamanhoBanco()!=0) {
			for (long i=0; i<this.tamanhoBanco(); i++) {
				p = (Professor) buscarArquivoPorId(i);
				if(p.getUsuario().equals(login)) {	
					return false;
				} else {
					
				}
			}	
		}
		return true;
	}
	
	/*
	 * Faz a autenticação para verificar se existe o login correspondente no sistema, e caso sim, retorna o proprio objeto
	 */
	public Professor autenticaSenhaProfessor (String login, String senha) throws IOException {
		Professor p = new Professor("", "00000000000", "", 0);
		RepositorioProfessor repProfessor = new RepositorioProfessor();
		
		for (long i=0; i<repProfessor.tamanhoBanco(); i++) {
			p = (Professor) buscarArquivoPorId(i);
			if(p.getSenha().equals(senha) && p.getUsuario().equals(login)) {
				return p;
			} else {
				
			}
			
		}
		return null;
	}

	/*
	 * Busca o id do objeto pelo cpf (retorna o id)
	 */
	public long buscarIdProfessor (String cpf) throws IOException {
		Professor p = new Professor("", "00000000000", "", 0);
		RepositorioProfessor repAluno = new RepositorioProfessor();
		
		for (long i=0; i<repAluno.tamanhoBanco(); i++) {
			p = (Professor) buscarArquivoPorId(i);
			if (p.getCPF().equals(cpf)) {
				return p.getId();
			} else {
				
			}
		}
		return -1;
	
	}
	
	/*
	 * Busca o professor pelo cpf e retorna o proprio professor.
	 */
	public Professor buscarPeloCpf (String cpf) throws IOException {
		Professor p = new Professor("", "00000000000", "", 0);
		RepositorioProfessor repProf = new RepositorioProfessor();
		
		for (long i=0; i<repProf.tamanhoBanco(); i++) {
			p = (Professor) buscarArquivoPorId(i);
			if (p.getCPF().equals(cpf)) {
				return p;
			} else {
				
			}
		}
		return null;
	
	}




}
