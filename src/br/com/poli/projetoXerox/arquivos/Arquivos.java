package br.com.poli.projetoXerox.arquivos;
import java.io.*;


public class Arquivos implements Serializable {

	private static final long serialVersionUID = 1L;
	private String caminho;
	private String banco;
	private long idArquivo;
	private String arquivo;
	     
	public Arquivos() {
		this.caminho ="dados";
		this.banco="arquivos";
	}
	
	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}



	public String getBanco() {
		return banco;
	}



	public void setBanco(String banco) {
		this.banco = banco;
	}



	public long getIdArquivo() {
		return idArquivo;
	}



	public void setIdArquivo(long idArquivo) {
		this.idArquivo = idArquivo;
	}



	public String getArquivo() {
		return arquivo;
	}



	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}


	/*
	 * Salva o objeto.
	 */
	public Object armazenaDados(Object arquivo, long id) throws IOException
	{		
		try 
		{
			FileOutputStream object = new FileOutputStream(this.caminho + this.banco + this.getArquivo() + id + ".arq");
			ObjectOutputStream objeto1 = new ObjectOutputStream(object);
			
			objeto1.writeObject(arquivo);		
			objeto1.close();
		}
		catch (Exception e)
		{
			
		}	
		
		return arquivo;
	}
    	
	/*
	 * Lê o objeto salvo.
	 */
	public Object leituraDados(long id) throws IOException {
		Object resultado = null;
		
			try {
				FileInputStream arq = new FileInputStream(this.caminho + this.banco + this.getArquivo() + id + ".arq");
				ObjectInputStream objectInputStream = new ObjectInputStream(arq);
				resultado = objectInputStream.readObject();
				objectInputStream.close();
				return resultado;

			} catch (Exception ex) {
				return resultado;
			}
     }	
	
	/*
	 * Cria uma pasta no diretório especificado.
	 */
    public void criarDiretorio() {
 		File file = new File(this.caminho+this.banco);
 		file.mkdir();
 	}
    
    /*
     * Retorna o tamanho do banco.
     */
    public long tamanhoBanco () {
		File file = new File(this.caminho + this.banco);
		long count = file.listFiles().length;
		return count;
	}
     
    /*
     * Busca o arquivo salvo de acordo com o id.
     */
    public Object buscarArquivoPorId(long id)throws IOException {
    	File file = new File(this.caminho + this.banco + this.getArquivo() + id +".arq");
		if(file.exists()){
			FileInputStream object = new FileInputStream(this.caminho + this.banco + this.getArquivo() + id +".arq");
			ObjectInputStream objeto1 = new ObjectInputStream(object);
			
			try
			{
				Object objeto = objeto1.readObject();
				
				objeto1.close();
				return objeto;
			}
			catch(Exception e)//NÃO ENCONTROU NENHUM ARQUIVO COM ESSE ID
			{
				
				objeto1.close();			
				return null;			
			}
			
		}
		else//ARQUIVO NÃO EXISTE
		{
			
			return null;
		}
	}	
	
    /*
     * Acha um arquivo através de seu id e o sobrescreve com as novas informacoes.
     */
    public Object editarArquivo(Object arquivoNovo, long id) throws IOException
	{
		
		Object arquivo = buscarArquivoPorId(id);
		
		try {
			if(arquivo !=null) {
				arquivo = arquivoNovo;
				arquivoNovo = (Object)arquivo;		
				FileOutputStream object = new FileOutputStream(this.caminho + this.banco + this.getArquivo() + id + ".arq");
				ObjectOutputStream objeto1 = new ObjectOutputStream(object);	
				objeto1.writeObject(arquivo);
				objeto1.close();
			}
			else {
				
			}

		}
		
		catch(Exception e){
			
		}
		
		return arquivoNovo;
	}
}