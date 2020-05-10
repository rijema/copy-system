package br.com.poli.projetoXerox.repositorio;
import java.io.*;


import br.com.poli.projetoXerox.arquivos.*;
import br.com.poli.projetoXerox.sistema.Funcionario;



public class RepositorioFuncionario extends Arquivos{
	

	private static final long serialVersionUID = 1L;

	public RepositorioFuncionario() {
		this.setBanco("PastaAdmin\\");
		this.setArquivo("Admin");
	}
	
	/*
	 * Método adiciona funcionário nos arquivos
	 */
	public Funcionario adicionarFuncionario(long idPessoa, Funcionario funcionario) throws IOException {		
		funcionario = (Funcionario)armazenaDados(funcionario, idPessoa);
		return funcionario;
	}
	
	
	/*
	 * Método para autenticar a senha e usuário do funcionario
	 */
	public Funcionario autenticaSenhaFuncionario (String login, String senha) throws IOException {
		Funcionario a = new Funcionario();
		RepositorioFuncionario repFuncionario = new RepositorioFuncionario();
		
		for (long i=0; i<repFuncionario.tamanhoBanco(); i++) {
			a = (Funcionario) buscarArquivoPorId(i);
			if(a.getSenha().equals(senha) && a.getUsuario().equals(login)) {
				return a;
			} else {
				
			}
			
		}
		return null;
	}

}
