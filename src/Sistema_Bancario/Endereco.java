package Sistema_Bancario;

/**
 * Classe responsavel por salvar as informa��es de endere�o de Pessoa
 * @author Integrantes do grupo
 *
 */
public class Endereco {
	protected static int geraid = 0;
	protected String id;
	//private String tipo = "Residencial";
	private String tipoDeLogradouro;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	
	//CONTRUTOR 1
	public Endereco(String tipoDeLogradouro, String logradouro, int numero, String bairro, String cidade,
			String estado, String cep) {
		//this.tipo = tipo;
		this.tipoDeLogradouro = tipoDeLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		geraid++;
		this.id = gerarID();
	}
	//CONTRUTOR 2
	/*
	public Endereco(String tipoDeLogradouro, String logradouro, int numero, String bairro, String cidade,
			String estado, String cep) {
		super();
		this.tipoDeLogradouro = tipoDeLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		geraid++;
	}*/
	
	private String gerarID() {
		return "Endere�o - " +geraid;
	}
	
	// GETTERS
	
	public String getID() {
		return id;
	}

	public String getTipoDeLogradouro() {
		return tipoDeLogradouro;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String getCep() {
		return cep;
	}
	
	//SETTERS
	
	protected void setTipoDeLogadouro(String tipoDeLogradouro) {
		this.tipoDeLogradouro = tipoDeLogradouro;
	}


	protected void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	protected void setNumero(int numero) {
		this.numero = numero;
	}

	protected void setBairro(String bairro) {
		this.bairro = bairro;
	}

	protected void setCidade(String cidade) {
		this.cidade = cidade;
	}

	protected void setEstado(String estado) {
		this.estado = estado;
	}

	protected void setCep(String cep) {
		this.cep = cep;
	}
	
	@Override
	public String toString() {
		return "Endereco \nid = " + id + "\ntipoDeLogradouro = " + tipoDeLogradouro + "\nlogradouro = "
				+ logradouro + "\nnumero = " + numero + "\nbairro = " + bairro + "\ncidade = " + cidade + "\nestado = " + estado
				+ "\ncep = " + cep + "\n";
	}

	
	
	
}
