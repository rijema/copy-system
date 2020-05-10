package br.com.poli.projetoXerox.sistema;

import java.io.IOException;

import br.com.poli.projetoXerox.exceptions.CampoNãoInformadoException;
import br.com.poli.projetoXerox.repositorio.RepositorioMaterial;

import java.util.ArrayList;

public class SistemaMaterial {
	
	/*
	 * Salva o material no repositorio material
	 */
	public void cadastrarMaterial (Professor professor, String disciplina, String titulo, int qtdPaginas) throws IOException, CampoNãoInformadoException {
		if(disciplina.equals("")||titulo.equals("")||qtdPaginas==0){
			throw new CampoNãoInformadoException();
		}
		Material m = new Material(professor, disciplina, titulo, qtdPaginas);
		RepositorioMaterial repMaterial = new RepositorioMaterial();		
		long i=repMaterial.tamanhoBanco();
		repMaterial.adicionarMaterial(i, m);
		
	}
	
	/*
	 * Retorna a lista de todos os materiais no sistema
	 */
	public ArrayList<Material> listaMaterial () throws IOException {
		RepositorioMaterial repMaterial = new RepositorioMaterial();
		ArrayList<Material> m = new ArrayList<Material>();
		for (long i=0; i<repMaterial.tamanhoBanco(); i++) {
			m.add((Material) repMaterial.leituraDados(i));
		}
		return m;
	}
}
