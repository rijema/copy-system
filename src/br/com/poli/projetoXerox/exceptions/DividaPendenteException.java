package br.com.poli.projetoXerox.exceptions;

public class DividaPendenteException extends Exception{
	public DividaPendenteException(){
		super("Existem dividas a serem pagas antes de poder fazer um novo pedido!");
	}
}
