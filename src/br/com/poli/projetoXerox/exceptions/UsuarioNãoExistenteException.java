package br.com.poli.projetoXerox.exceptions;

public class UsuarioN�oExistenteException extends Exception {
	public UsuarioN�oExistenteException(){
		super("N�o existe um usu�rio cadastrado com esse cpf!");
	}
}
