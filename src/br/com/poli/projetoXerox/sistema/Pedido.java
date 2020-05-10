package br.com.poli.projetoXerox.sistema;
import java.io.Serializable;
import java.util.Date;


public class Pedido implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int qtdCopias;
	private String nomeDisciplina;
	private Date data;
	private String donoPedido;
	private String cpfDono;
	private String titulo;
	private String nomeProfessor;
	private boolean pago;
	private boolean pendente;
	private boolean cancelado;
	private double preço;
	private long id;
	private Aluno aluno = new Aluno();
	private Professor professor = new Professor();
	
	public Pedido(Aluno a, int qtdCopias, Material m) {
		this.donoPedido = a.getNome();
		this.qtdCopias = qtdCopias;
		this.data= new Date();
		this.cpfDono = a.getCPF();
		this.nomeDisciplina = m.getNomeDisciplina();
		this.titulo = m.getTitulo();
		this.nomeProfessor = m.getNomeProfessor();
		this.preço = (0.1 * m.getPaginas()) * qtdCopias;
		this.aluno = a;
		this.pago=false;
		this.pendente=true;
		this.cancelado=false;				
	}
	
	public Pedido(Professor p, int qtdCopias, Material m) {
		this.donoPedido = p.getNome();
		this.qtdCopias = qtdCopias;
		this.data= new Date();
		this.cpfDono = p.getCPF();
		this.nomeDisciplina = m.getNomeDisciplina();
		this.titulo = m.getTitulo();
		this.nomeProfessor = m.getNomeProfessor();
		this.preço = (0.1 * m.getPaginas()) * qtdCopias;
		this.professor = p;
		this.pago=false;
		this.pendente=true;
		this.cancelado=false;
	}
	
	
	public Pedido() {
		/*
		 * Polimorfismo: Overload de construtor
		 */
	}
	
	public double getPreço() {
		return preço;
	}
	
	public String getTitulo(){
		return this.titulo;
	}

	public boolean getStatus() {
		return this.pendente;
	}
	
	public void setStatusTrue() {
		this.pendente=true;
	}
	
	public boolean getPago() {
		return pago;
	}


	public void setPagoTrue() {
		this.pago=true;
	}


	public void setCanceladoTrue() {
		this.cancelado=true;
	}
	
	public boolean getCancelado () {
		return this.cancelado;
	}
	
	public void setStatusFalse() {
		this.pendente=false;
	}
	

	public void setData(Date data) {
		this.data = data;
	}

	public void setDonoPedido(Aluno a) {
		this.donoPedido = a.getNome();
	}
	
	public Date getData() {
		return data;
	}
	
	public String getCpfDono() {
		return cpfDono;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	public Aluno getAluno() {
		return this.aluno;
	}
	
	public Professor getProfessor() {
		return this.professor;  
	}

	@Override
	public String toString() {
		if (this.getCancelado()==false && this.getPago()==false && this.getStatus()==true)	{
			return "\n> Feito por: " + this.donoPedido +
				"\t\n> Ação referida: Impressão de " + this.qtdCopias+ " folha(s) do material abaixo." +
				"\t\n> Material do(a) professor(a): " + this.nomeProfessor + "\t\n> Título: " 
				+  this.titulo  + "\t\t\t\t\t\t\t\t\t\t\t\t > Não Impresso <"  + "\t\n>Disciplina : " + this.nomeDisciplina + "\n>Preço: R$" + this.getPreço() + " -   [ NÃO PAGO ]";
		} else if (this.getCancelado()==false && this.getPago()==false && this.getStatus()==false) {
			return "\n> Feito por: " + this.donoPedido +
					"\t\n> Ação referida: Impressão de " + this.qtdCopias+ " folha(s) do material abaixo." +
					"\t\n> Material do(a) professor(a): " + this.nomeProfessor + "\t\n> Título: " 
					+  this.titulo+ "\t\t\t\t\t\t\t\t\t\t\t\t  > Impresso < " + "\t\n>Disciplina : " + this.nomeDisciplina + "\n>Preço: R$" + this.getPreço() + " -   [ NÃO PAGO ]";
		}else if (this.getCancelado()==true) {
			return "\n\n [ Pedido CANCELADO! ]  "+"\n> Feito por: " + this.donoPedido +
					"\t\n> Ação referida: Impressão de " + this.qtdCopias+ " folha(s) do material abaixo." +
					"\t\n> Material do(a) professor(a): " + this.nomeProfessor + "\t\n> Título: "
					+  this.titulo + "\t\n>Disciplina : " + this.nomeDisciplina;
		} else if (this.getCancelado()==false && this.getPago()==true && this.getStatus()==false) {
			
			return "\n> Feito por: " + this.donoPedido +
					"\t\n> Ação referida: Impressão de " + this.qtdCopias+ " folha(s) do material abaixo." +
					"\t\n> Material do(a) professor(a): " + this.nomeProfessor + "\t\n> Título: "  + 
					  this.titulo + "\t\t\t\t\t\t\t\t\t\t\t\t  > Impresso <"  + "\t\n>Disciplina : " + this.nomeDisciplina + "\n>Preço: R$" + this.getPreço() + " -   [ PAGO ]";
				
		} else if (this.getCancelado()==false && this.getPago()==true && this.getStatus()==true) {
		
			return "\n> Feito por: " + this.donoPedido +
					"\t\n> Ação referida: Impressão de " + this.qtdCopias+ " folha(s) do material abaixo." +
					"\t\n> Material do(a) professor(a): " + this.nomeProfessor + "\t\n> Título: " 
					+  this.titulo +"\t\t\t\t\t\t\t\t\t\t\t\t  > Não Impresso < " +  "\t\n>Disciplina : " + this.nomeDisciplina + "\n>Preço: R$" + this.getPreço() + " -   [ PAGO ]";
		} else {
			return "\n> Feito por: " + this.donoPedido +
					"\n\t> Ação referida: Impressão de " + this.qtdCopias+ " folha(s) do material abaixo." +
					"\n\t> Material do(a) professor(a): " + this.nomeProfessor + "\n\t> Título: "
					+  this.titulo + "\n\t>Disciplina : " + this.nomeDisciplina;
		}
		
		/* Polimorfismo - Sobrescrita:
		 * O método toString dá uma representação em string do nosso objeto em questão,
		 * sem isso, iria aparecer seu hashcode. Cada return depende dos atributos do pedido
		 * getCancelado()==false quer dizer que não foi cancelado
		 * getCancelado()==true quer dizer quee foi cancelado
		 * getPago()==true quer dizer que foi pago
		 * getPago()==true quer dizer que não foi pago
		 * getStatus()==true quer dizer que está pendente
		 * getStatus()==false quer dizer que está impresso
		 * 
		 */
		
	}
}
