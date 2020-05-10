package br.com.poli.projetoXerox.exceptions;

public class CampoNãoInformadoException extends Exception{
	public CampoNãoInformadoException(){
		super("Um ou mais dos campos necessários não foi/foram preenchido(s)");
	}
}
