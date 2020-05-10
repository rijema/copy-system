package br.com.poli.projetoXerox.repositorio;
import java.io.*;


import br.com.poli.projetoXerox.arquivos.*;
import br.com.poli.projetoXerox.sistema.*;


public class RepositorioPedido extends Arquivos{
	

	private static final long serialVersionUID = 1L;

	public RepositorioPedido() {
		this.setBanco("PastaPedido\\");
		this.setArquivo("Pedido");
	}
		
	/*
	 * Método armazena novo aluno nos arquivos.
	 */
	public Pedido adicionarPedido(long idPessoa,Pedido pedido) throws IOException
	{		
		Pedido p = (Pedido)armazenaDados(pedido, idPessoa);
		return p;
	}
	
	/*
	 * Método para alterar atributos de pedido nos arquivos
	 */
	public Pedido editarPedido(long id, Pedido pedido) throws IOException {		
		pedido = (Pedido)editarArquivo(pedido, id);
		return pedido;
	}

}
