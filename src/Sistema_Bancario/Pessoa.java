package Sistema_Bancario;

/**
 * Classe responsavel por cadastrar e gerar os tipos de herancas para pessoa fisica e juridica
 * @author Integrantes do grupo
 *
 */
public abstract class Pessoa {
	protected static int geraid = 0;
	protected String id;
	protected String nome;
	private Endereco endereco;

	protected abstract String gerarID();

	public Pessoa(String nome, Endereco endereco) {
		this.nome = nome;
		this.endereco = endereco;
		geraid++;
	}

	public String getNome() {
		return nome;
	}
	
	public String getId() {
		return id;
	}

	private void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "Pessoa \nid = " + id + "\nnome = " + nome + "\nendereco = " + endereco + "\n";
	}
	
	
	
}
