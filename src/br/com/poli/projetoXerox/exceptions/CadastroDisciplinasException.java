package br.com.poli.projetoXerox.exceptions;

public class CadastroDisciplinasException extends Exception{
	public CadastroDisciplinasException() {
		super("Você ja cadastrou todas as disciplinas!");
	}
}
