package br.com.poli.projetoXerox.exceptions;

public class CampoN�oInformadoException extends Exception{
	public CampoN�oInformadoException(){
		super("Um ou mais dos campos necess�rios n�o foi/foram preenchido(s)");
	}
}
