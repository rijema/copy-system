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
	
	//Método para enviar as informações do material para o sistema(apenas o professor tem essa prioridade).
	public void solicitarEnvioMaterial (String titulo, int qtdPaginas) {
		Material material = new Material(this, disciplinas[0], titulo, qtdPaginas); //ALTERAR
		listMateriais.add(material);
		
	}
	
	//Método para adicionar as disciplinas que o professor ensina, e suas informações.
	public void adicionarDisciplina(String nomeDisciplina) throws CadastroDisciplinasException {
		if(this.contador<this.qtdDisciplinas) {
			disciplinas[contador] = nomeDisciplina;
			this.contador++;
		}
		else {
			throw new CadastroDisciplinasException();
		}
	}
	
	//Método para retornar a lista de materiais (irá sofrer melhorias com implementação de arquivos).
	public ArrayList<Material> getListaMateriais () {
		return listMateriais;
	}
	
	//Cria material para envio.
	/*public Material criarMaterial (Professor professor, String titulo) {
		Material m = new Material(professor, titulo);
		return m;
	}*/
	
}
	
