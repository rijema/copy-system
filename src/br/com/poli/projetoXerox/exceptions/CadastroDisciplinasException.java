package br.com.poli.projetoXerox.exceptions;

public class CadastroDisciplinasException extends Exception{
	public CadastroDisciplinasException() {
		super("Voc� ja cadastrou todas as disciplinas!");
	}
}
