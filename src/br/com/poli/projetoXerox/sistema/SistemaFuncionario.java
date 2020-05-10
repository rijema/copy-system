package br.com.poli.projetoXerox.sistema;

import java.io.IOException;

import br.com.poli.projetoXerox.exceptions.Autentica��oException;
import br.com.poli.projetoXerox.exceptions.CampoN�oInformadoException;
import br.com.poli.projetoXerox.repositorio.*;

public class SistemaFuncionario {
	
	/*
	 * M�todo para funcion�rio logar no sistema
	 */
	public boolean login (String user, String senha) throws IOException, CampoN�oInformadoException, Autentica��oException {
		if(user.equals("")||senha.equals("")){
			throw new CampoN�oInformadoException();
		}
		RepositorioFuncionario repFuncionario = new RepositorioFuncionario();
		if ((repFuncionario.autenticaSenhaFuncionario(user, senha)!=null)) {
			return true;
		} else {
			throw new Autentica��oException();
		}
		
	}
}
