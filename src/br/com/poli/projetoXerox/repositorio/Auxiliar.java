package br.com.poli.projetoXerox.repositorio;
import java.io.*;
import java.util.Random;

import br.com.poli.projetoXerox.arquivos.*;
import br.com.poli.projetoXerox.exceptions.UsuarioNãoExistenteException;
import br.com.poli.projetoXerox.sistema.Aluno;
import br.com.poli.projetoXerox.sistema.Professor;

public class Auxiliar extends Arquivos{

	private static final long serialVersionUID = 1L;
	private long idAlunoRecente;
	private long idProfessorRecente;
	
	public Auxiliar() {
		
	}
	
	/*
	 * Método caso o usuário esqueca a senha, e gera uma nova aleatória através do CPF cadastrado
	 */
	public String recuperarSenha(String cpf) throws IOException, UsuarioNãoExistenteException {
		RepositorioAluno repAluno = new RepositorioAluno();
		RepositorioProfessor repProf = new RepositorioProfessor();
		
		Aluno a = new Aluno();
		Professor p = new Professor();
		Random rnd = new Random();
		
		a=repAluno.buscarPeloCpf(cpf);
		if(a!=null){
			a.setSenha(String.valueOf(rnd.nextInt(999999)+100000));
			repAluno.editarAluno(a.getId(), a);
			return a.getSenha();
		} 
		else{
			p = repProf.buscarPeloCpf(cpf);
			if(p!=null){
				p.setSenha(String.valueOf(rnd.nextInt(999999)+100000));
				repProf.editarProfessor(p.getId(), p);
				return p.getSenha();
			}
			else{
				throw new UsuarioNãoExistenteException();
			}
		}
	}

	public long getIdAlunoRecente() throws IOException {
		this.idAlunoRecente = idAlunoRecente + 1;
		armazenaDados(this.getArquivo(), 0);
		return idAlunoRecente;
	}

	public long getIdProfessorRecente() throws IOException {
		this.idProfessorRecente = idProfessorRecente + 1;
		armazenaDados(this.getArquivo(), 0);
		return idProfessorRecente;
	}


	
	
	

}
