package br.com.poli.projetoXerox.exceptions;

public class CpfInv�lidoException extends RuntimeException{
	public CpfInv�lidoException() {
		super("O CPF informado n�o est� formatado corretamente.");
	}
}
