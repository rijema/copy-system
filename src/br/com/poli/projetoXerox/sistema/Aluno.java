package br.com.poli.projetoXerox.sistema;

import java.util.ArrayList;

import br.com.poli.projetoXerox.exceptions.DividaPendenteException;

public class Aluno extends Usuario {
	
	private ArrayList<Pedido> listPedidos;
	
	public Aluno (String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		listPedidos = new ArrayList<Pedido>();
	}
	
	public Aluno() {
		
	}
	
	//Faz o pedido de um material. (arraylist aluno)
	public void fazerPedido(int qtdCopias, Material m) throws DividaPendenteException {
		if(this.getDividaValor()!=0.0){
			Pedido pedido = new Pedido(this, qtdCopias, m);
			listPedidos.add(pedido);
		}
		else{
			throw new DividaPendenteException();
		}
	}
	
	//Remove material da lista (arraylis Aluno)
	public void cancelarPedido(){
		for(int i=0;i<listPedidos.size();i++){
			  if(listPedidos.get(i).getStatus()==true ){
				  listPedidos.remove(i);
			  }
		}
	}
	
	//Retorna o atributo listPedidos
	public ArrayList<Pedido> getListaPedido () {
		return listPedidos;
	}
	
	


}	

