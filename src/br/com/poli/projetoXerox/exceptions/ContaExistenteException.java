package br.com.poli.projetoXerox.exceptions;

public class ContaExistenteException extends Exception{
	public ContaExistenteException() {
		super("O arquivo da respectiva conta j� existe no sistema!");
	}
}
