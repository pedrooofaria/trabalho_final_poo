package Sistema_Bancario;

/**
 * 
 * @author Integrantes do grupo
 *Classe responsavel por salvar os dados da conta corrente de Pessoa Fisica e Juridica
 */
public class ContaCorrente extends Conta{
	private double limite;
	private ContaPoupanca contaPoupanca;
	
	public ContaCorrente(int numero, double saldo, Pessoa cliente, TipoConta tipoConta, double limite,
			ContaPoupanca contaPoupanca) {
		super(numero, saldo, cliente, tipoConta);
		this.limite = limite;
		this.setContaPoupanca(contaPoupanca);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public void saque(double valor) throws ContaException{
		double aux = getLimite() + getSaldo();
		if (valor <= aux) {
			setSaldo(getSaldo() - valor);
		}else {
			throw new ContaException("Saldo indisponivel!"); 
		}
	}

	public ContaPoupanca getContaPoupanca() {
		return contaPoupanca;
	}

	public void setContaPoupanca(ContaPoupanca contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}

	@Override
	public String toString() {
		return super.toString() + "ContaCorrente \nlimite =" + limite + "\ncontaPoupanca = " + contaPoupanca + "\n";
	}
	
	
}
