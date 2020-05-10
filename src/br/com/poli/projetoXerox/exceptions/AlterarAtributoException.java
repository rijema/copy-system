package br.com.poli.projetoXerox.exceptions;

public class AlterarAtributoException extends Exception{
	public AlterarAtributoException(){
		super("O login e/ou senha informados são inválidos para o seu usuário");
	}
}
