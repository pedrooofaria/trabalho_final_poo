package Sistema_Bancario;

/**
 * Classe de Funcionario para Pessoa Fisica, apenas pessoas fisicas podem ser funcionarios
 * @author Integrantes do grupo
 *
 */
public class Funcionario extends PessoaFisica{
	private static int geraid = 0;
	private String cargo;
	
	public Funcionario(String nome, Endereco endereco, String cpf, String cargo) throws PessoaException {
		super(nome, endereco, cpf);
		geraid++;
		this.setCargo(cargo);
		this.id = gerarID();
	}

	public String getCargo() {
		return cargo;
	}
	
	protected String gerarID() {
		return "Funcionario - " + super.geraid + " , " +geraid;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return super.toString() + "Funcionario \ncargo = " + cargo + "\n";
	}
	
	
}
