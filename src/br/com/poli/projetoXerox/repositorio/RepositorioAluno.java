package br.com.poli.projetoXerox.repositorio;
import java.io.*;


import br.com.poli.projetoXerox.arquivos.*;
import br.com.poli.projetoXerox.sistema.Aluno;



public class RepositorioAluno extends Arquivos{
	

	private static final long serialVersionUID = 1L;

	public RepositorioAluno() {
		this.setBanco("PastaAlunos\\");
		this.setArquivo("Aluno");
	}
		
	/*
	 * Método armazena novo aluno nos arquivos.
	 */
	public Aluno adicionarAluno(long idPessoa, Aluno aluno) throws IOException {		
		aluno = (Aluno)armazenaDados(aluno, idPessoa);
		return aluno;
	}
	
	
	/*
	 * Abre o arquivo para alteração
	 */
	public Aluno editarAluno(long idPessoa, Aluno aluno) throws IOException {		
		aluno = (Aluno)editarArquivo(aluno, idPessoa);
		return aluno;
	}
	
	/*
	 * Verifica se já existe alguma conta com esse cpf
	 */
	public boolean disponibilidadeContaAluno (String cpf) throws IOException {
		RepositorioAluno repAluno = new RepositorioAluno();
		Aluno b = new Aluno("", "00000000000", "");
		if (repAluno.tamanhoBanco()!=0) {
			for (long i=0; i<repAluno.tamanhoBanco(); i++) {
				b = (Aluno) buscarArquivoPorId(i);
				if(b.getCPF().equals(cpf)) {	
					return false;
				} else {
				
				}
			}	
		}
		return true;
	}
	
	/*
	 * Verifica se já existe alguma conta com esse novo nome de usuário cadastrado.
	 */
	public boolean disponibilidadeLoginAluno (String login) throws IOException {
		Aluno b = new Aluno("", "00000000000", "");
		if (this.tamanhoBanco()!=0) {
			for (long i=0; i<this.tamanhoBanco(); i++) {
				b = (Aluno) buscarArquivoPorId(i);
				if(b.getUsuario().equals(login)) {	
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
	public Aluno autenticaSenhaAluno (String login, String senha) throws IOException {
		Aluno a = new Aluno("", "00000000000", "");
		RepositorioAluno repAluno = new RepositorioAluno();
		
		for (long i=0; i<repAluno.tamanhoBanco(); i++) {
			a = (Aluno) buscarArquivoPorId(i);
			if(a.getSenha().equals(senha) && a.getUsuario().equals(login)) {
				return a;
			}
		}
		return null;
	}
	
	/*
	 * Busca o id do objeto pelo cpf (retorna o id)
	 */
	public long buscarIdAluno (String cpf) throws IOException {
		Aluno a = new Aluno("", "00000000000", "");
		RepositorioAluno repAluno = new RepositorioAluno();
		
		for (long i=0; i<repAluno.tamanhoBanco(); i++) {
			a = (Aluno) buscarArquivoPorId(i);
			if (a.getCPF().equals(cpf)) {
				return a.getId();
			} else {
				
			}
		}
		return -1;
	
	}
	
	/*
	 * Busca o id do objeto pelo cpf (retorna o proprio objeto)
	 */
	public Aluno buscarPeloCpf (String cpf) throws IOException {
		Aluno a = new Aluno("", "00000000000", "");
		RepositorioAluno repAluno = new RepositorioAluno();
		
		for (long i=0; i<repAluno.tamanhoBanco(); i++) {
			a = (Aluno) buscarArquivoPorId(i);
			if (a.getCPF().equals(cpf)) {
				return a;
			} else {
				
			}
		}
		return null;
	
	}
	

}
