package br.com.poli.projetoXerox.exceptions;

public class UsuarioNãoExistenteException extends Exception {
	public UsuarioNãoExistenteException(){
		super("Não existe um usuário cadastrado com esse cpf!");
	}
}
