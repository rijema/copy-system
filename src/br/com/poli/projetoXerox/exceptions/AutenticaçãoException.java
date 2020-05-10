package br.com.poli.projetoXerox.exceptions;

public class AutenticaçãoException extends Exception{
	public AutenticaçãoException(){
		super("Login e/ou senha inválidos");
	}
}
