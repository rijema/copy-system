package br.com.poli.projetoXerox.exceptions;

public class AlterarAtributoException extends Exception{
	public AlterarAtributoException(){
		super("O login e/ou senha informados s�o inv�lidos para o seu usu�rio");
	}
}
