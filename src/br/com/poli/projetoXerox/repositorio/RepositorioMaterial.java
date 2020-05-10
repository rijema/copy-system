package br.com.poli.projetoXerox.repositorio;
import java.io.IOException;
import br.com.poli.projetoXerox.arquivos.Arquivos;
import br.com.poli.projetoXerox.sistema.Material;

public class RepositorioMaterial extends Arquivos{

	private static final long serialVersionUID = 1L;

	public RepositorioMaterial() {
		this.setBanco("PastaMaterial\\");
		this.setArquivo("Material");
	}
	
	/*
	 * Método armazena novo material nos arquivos.
	 */
	public Material adicionarMaterial(long id,Material m) throws IOException
	{		
		m = (Material)armazenaDados(m, id);
		return m;
	}

	
}
