package br.com.poli.projetoXerox.sistema;

import java.io.IOException;
import java.util.ArrayList;

import br.com.poli.projetoXerox.exceptions.ContaExistenteException;
import br.com.poli.projetoXerox.exceptions.DividaPendenteException;
import br.com.poli.projetoXerox.repositorio.RepositorioAluno;
import br.com.poli.projetoXerox.repositorio.RepositorioPedido;
import br.com.poli.projetoXerox.repositorio.RepositorioProfessor;

public class SistemaPedido {
	
	/*
	 * Salva o pedido no repositorio pedido
	 * (Overload)
	 */
	public boolean cadastrarPedido (Aluno a, int qtdFolhas, Material m) throws IOException, ContaExistenteException, DividaPendenteException {
		Pedido p = new Pedido(a, qtdFolhas, m);
		RepositorioPedido repPedido = new RepositorioPedido();		
		long i=repPedido.tamanhoBanco();
		p.setId(i);
		a.setDividaValor(p.getPreço());
		repPedido.adicionarPedido(i, p);
		return true;
		
	}
	
	/*
	 * Salva o pedido no repositorio pedido
	 * (Overload)
	 */
	public boolean cadastrarPedido (Professor a, int qtdFolhas, Material m) throws IOException, ContaExistenteException, DividaPendenteException {
		Pedido p = new Pedido(a, qtdFolhas, m);
		RepositorioPedido repPedido = new RepositorioPedido();		
		long i=repPedido.tamanhoBanco();
		p.setId(i);
		repPedido.adicionarPedido(i, p);
		return true;
		
	}
	
	/*
	 * Lista os pedidos que faltam ser pagos ou ainda não impressos, ou as duas opcoes
	 */
	public ArrayList<Pedido> listarPedidosPendentes () throws IOException {
		RepositorioPedido repPedido = new RepositorioPedido();
		ArrayList<Pedido> p = new ArrayList<Pedido>();
		Pedido pedido = new Pedido();
		for (long i=0; i<repPedido.tamanhoBanco(); i++) {
			pedido = (Pedido) repPedido.leituraDados(i);
			if ((pedido.getStatus()==true && pedido.getCancelado()==false && pedido.getPago()==true)||
					(pedido.getStatus()==true && pedido.getCancelado()==false && pedido.getPago()==false) || 
					(pedido.getStatus()==false && pedido.getCancelado()==false &&	pedido.getPago()==false)) {
				p.add((Pedido) repPedido.leituraDados(i));
			}
		}
		return p;
	}
	
	/*
	 * Indica que o pedido foi impresso
	 */
	public void alterarStatusPedidoParaFeito (Pedido pedido) throws IOException {
		RepositorioPedido repPedido = new RepositorioPedido();
		Pedido p = new Pedido();
		p=(Pedido)repPedido.leituraDados(pedido.getId());
		p.setStatusFalse();
		repPedido.editarPedido(pedido.getId(), p);
		
	}
	
	/*
	 * Indica que o pedido foi pago
	 */
	public void alterarStatusPedidoParaPago (Pedido pedido) throws IOException {
		RepositorioPedido repPedido = new RepositorioPedido();
		Pedido p = new Pedido();
		p=(Pedido)repPedido.leituraDados(pedido.getId());
		p.setPagoTrue();
		repPedido.editarPedido(pedido.getId(), p);
		
	}
	
	/*
	 * Cancela o pedido selecionado
	 */
	public void cancelarPedido (Pedido pedido) throws IOException {
		RepositorioPedido repPedido = new RepositorioPedido();
		Pedido p = new Pedido();
		p=(Pedido)repPedido.leituraDados(pedido.getId());
		p.setCanceladoTrue();
		
		repPedido.editarPedido(pedido.getId(), p);
		
	}
	
	/*
	 * Lista o pedido somente daquele aluno em questão
	 */
	public ArrayList<Pedido> listarPedidosAluno (Aluno a) throws IOException {
		RepositorioPedido repPedido = new RepositorioPedido();
		Pedido pedido = new Pedido();
		ArrayList<Pedido> p = new ArrayList<Pedido>();
		for (long i=0; i<repPedido.tamanhoBanco(); i++) {
			pedido = (Pedido) repPedido.leituraDados(i);
			if (pedido.getCpfDono().equals(a.getCPF())) {
				p.add((Pedido) repPedido.leituraDados(i));
			}
		}
		return p;
	}
	
	/*
	 * Lista o pedido somente daquele professor em questão
	 */
	public ArrayList<Pedido> listarPedidosProfessor (Professor professor) throws IOException {
		RepositorioPedido repPedido = new RepositorioPedido();
		Pedido pedido = new Pedido();
		ArrayList<Pedido> p = new ArrayList<Pedido>();
		for (long i=0; i<repPedido.tamanhoBanco(); i++) {
			pedido = (Pedido) repPedido.leituraDados(i);
			if (pedido.getCpfDono().equals(professor.getCPF())) {
				p.add((Pedido) repPedido.leituraDados(i));
			}
		}
		return p;
	}
	
	/*
	 * Retorna quanto o aluno deve de pedidos pendentes
	 */
	public String dividaAluno (Aluno a) throws IOException {
		RepositorioPedido repPedido = new RepositorioPedido();
		Pedido pedido = new Pedido();
		RepositorioAluno ra = new RepositorioAluno();
		double valorTotal = 0;
		for (long i=0; i<repPedido.tamanhoBanco(); i++) {
			pedido = (Pedido) repPedido.leituraDados(i);
			if (pedido.getCpfDono().equals(a.getCPF())) {
				if (pedido.getCancelado()==false && pedido.getPago()==false) {
					valorTotal = pedido.getPreço()+valorTotal;
				}
			}
		}
		a.setDividaValor(valorTotal);
		ra.editarAluno(a.getId(), a);
		return a.getNome() + ", Você deve: R$" + a.getDividaValor();
	}
	
	/*
	 * Retorna quanto o professor deve de pedidos pendentes
	 */
	public String dividaProfessor (Professor p) throws IOException {
		RepositorioPedido repPedido = new RepositorioPedido();
		Pedido pedido = new Pedido();
		RepositorioProfessor rp = new RepositorioProfessor();
		double valorTotal = 0;
		for (long i=0; i<repPedido.tamanhoBanco(); i++) {
			pedido = (Pedido) repPedido.leituraDados(i);
			if (pedido.getCpfDono().equals(p.getCPF())) {
				if (pedido.getCancelado()==false && pedido.getPago()==false) {
					valorTotal = pedido.getPreço()+valorTotal;
				}
			}
		}
		p.setDividaValor(valorTotal);
		rp.editarProfessor(p.getId(), p);
		return "Olá " + p.getNome() + ", você deve: R$ " + p.getDividaValor();
	}
	


}