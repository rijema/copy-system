package br.com.poli.projetoXerox.sistema;


import java.util.ArrayList;
import br.com.poli.projetoXerox.exceptions.CadastroDisciplinasException;

public class Professor extends Usuario {
	

	public String disciplinas[];
	private int qtdDisciplinas;
	private int contador=0;
	private ArrayList<Material> listMateriais = new ArrayList<Material>();

	
	public Professor (String nome, String cpf, String senha, int qtdDisciplinas) {
		super (nome, cpf,senha);
		this.disciplinas = new String[qtdDisciplinas];
		this.qtdDisciplinas = qtdDisciplinas;
	}
	
	public Professor () {
		
	}
	
	//M�todo para enviar as informa��es do material para o sistema(apenas o professor tem essa prioridade).
	public void solicitarEnvioMaterial (String titulo, int qtdPaginas) {
		Material material = new Material(this, disciplinas[0], titulo, qtdPaginas); //ALTERAR
		listMateriais.add(material);
		
	}
	
	//M�todo para adicionar as disciplinas que o professor ensina, e suas informa��es.
	public void adicionarDisciplina(String nomeDisciplina) throws CadastroDisciplinasException {
		if(this.contador<this.qtdDisciplinas) {
			disciplinas[contador] = nomeDisciplina;
			this.contador++;
		}
		else {
			throw new CadastroDisciplinasException();
		}
	}
	
	//M�todo para retornar a lista de materiais (ir� sofrer melhorias com implementa��o de arquivos).
	public ArrayList<Material> getListaMateriais () {
		return listMateriais;
	}
	
	//Cria material para envio.
	/*public Material criarMaterial (Professor professor, String titulo) {
		Material m = new Material(professor, titulo);
		return m;
	}*/
	
}
	
