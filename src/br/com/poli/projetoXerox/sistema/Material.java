package br.com.poli.projetoXerox.sistema;

import java.io.Serializable;
import java.util.Date;

public class Material implements Serializable{

	private String titulo;
	private String disciplina;
	private String nomeProfessor;
	private int paginas;
	private Date data;
	Professor professor;
	private String cpfDono;
	
	public Material(Professor professor,String d, String titulo, int qtdPaginas) {
		this.titulo = titulo;
		this.disciplina= d; 
		this.paginas = qtdPaginas;
		this.professor=professor;
		this.nomeProfessor = professor.getNome();
		this.data= new Date();
		
	}
	
	public Material () {
		/*
		 * Polimorfismo: Overload de construtor
		 */
	}
	
	public Professor getProfessor() {
		return this.professor;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public void setNomeProfessor(Professor professor) {
		this.nomeProfessor = professor.getNome();
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getNomeDisciplina() {
		return this.disciplina;
	}
	
	public String getNomeProfessor () {
		return this.nomeProfessor;
	}
	
	public int getPaginas() {
		return paginas;
	}

	public Date getData () {
		return this.data;
	}
	
	@Override
	public String toString() {
		return "\n>Material do professor: " + this.nomeProfessor + "\n>Título: " + this.titulo+"\n>Enviado em: [ "+data+" ]"
				+ "\n>Disciplina: " + this.disciplina; /* + " referente a disciplina " + disciplina; */
		/* Polimorfismo - Sobrescrita:
		 * O método toString dá uma representação em string do nosso objeto em questão,
		 * sem isso, iria aparecer seu hashcode.
		 * 
		 */
	}
}