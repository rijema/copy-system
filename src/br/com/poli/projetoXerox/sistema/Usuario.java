package br.com.poli.projetoXerox.sistema;
import java.io.Serializable;
import java.util.regex.*;

import br.com.poli.projetoXerox.exceptions.CpfInv�lidoException;


public abstract class Usuario implements Serializable {
	
	private String nome;
	private String usuario;
	private String senha;
	private String cpf;
	private String codUser;
	private double dividaValor;
	private long id;
	
	public Usuario (String nome, String cpf, String senha) {
		this.setNome(nome);
		this.setCPF(cpf);
		this.setSenha(senha);
	}
	
	public Usuario() {
		
	}
		
	//Pega apenas o primeiro nome da pessoa com a senha e cria um login �nico.
	public void criarUser() {
		this.gerarCodigoUser();
		String pattern = "\\S+";	
		Pattern r = Pattern.compile(pattern);	 
		Matcher m = r.matcher(this.nome);	
	    if (m.find( )) {	
	    	this.usuario = m.group(0) + this.codUser;	
	    }				
	}
	
	//Senha criada a partir dos 6 primeiros d�gitos do cpf.
	public void gerarCodigoUser() {;
		this.codUser = cpf;		
	}	
	
	//M�todo para realiza��o de login (ainda necessita implementa��o de arquivos).
	public boolean autenticaLogin(String senha) {
		if(this.usuario.equals(usuario) && this.senha.equals(senha)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validaCpf(String cpf) throws CpfInv�lidoException {
		if(cpf.length()==11) {
			return true;
		}
		else {
			return false;
		}
	}

	public void setCPF(String cpf) throws CpfInv�lidoException{
		if(validaCpf(cpf)==true) {
			this.cpf = cpf;
		}
		else {
			throw new CpfInv�lidoException();
		}
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getCPF () {
		return this.cpf;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public long getId () {
		return this.id;
	}
	

	
	public double getDividaValor(){
		return this.dividaValor;
	}
	
	public void setDividaValor(double dividaValor) {
		this.dividaValor=dividaValor;
	}
	
	public void pagarDividaValor(double dividaValor) {
		this.dividaValor -= dividaValor;
	}
	
	public void pedirDividaValor(double dividaValor) {
		this.dividaValor += dividaValor;
	}
	

	@Override
	public String toString() {
		return "\t\t\tNome:  " + this.getNome()  + "  - - - - -  " + "  CPF:  " + this.getCPF() + "  - - - - -  " + "  Login:  " + this.getUsuario() + "\n";
		/* Polimorfismo - Sobrescrita:
		 * O m�todo toString d� uma representa��o em string do nosso objeto em quest�o,
		 * sem isso, iria aparecer seu hashcode.
		 * 
		 */
	}
	
}
