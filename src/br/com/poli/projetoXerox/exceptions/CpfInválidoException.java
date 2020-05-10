package br.com.poli.projetoXerox.exceptions;

public class CpfInválidoException extends RuntimeException{
	public CpfInválidoException() {
		super("O CPF informado não está formatado corretamente.");
	}
}
