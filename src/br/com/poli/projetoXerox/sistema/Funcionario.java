package br.com.poli.projetoXerox.sistema;

public class Funcionario extends Usuario{

	/**
	 * 
	 */
	private String usuario;
	private String senha;
	private static final long serialVersionUID = 1L;
	
	public Funcionario (){

	}
	
	public Funcionario (String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
