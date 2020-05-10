package br.com.poli.projetoXerox.sistema;

import java.io.IOException;

import br.com.poli.projetoXerox.exceptions.AutenticaçãoException;
import br.com.poli.projetoXerox.exceptions.CampoNãoInformadoException;
import br.com.poli.projetoXerox.repositorio.*;

public class SistemaFuncionario {
	
	/*
	 * Método para funcionário logar no sistema
	 */
	public boolean login (String user, String senha) throws IOException, CampoNãoInformadoException, AutenticaçãoException {
		if(user.equals("")||senha.equals("")){
			throw new CampoNãoInformadoException();
		}
		RepositorioFuncionario repFuncionario = new RepositorioFuncionario();
		if ((repFuncionario.autenticaSenhaFuncionario(user, senha)!=null)) {
			return true;
		} else {
			throw new AutenticaçãoException();
		}
		
	}
}
