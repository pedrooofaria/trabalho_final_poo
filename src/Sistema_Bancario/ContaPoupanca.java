package Sistema_Bancario;
/**
 * Classe de conta Poupanca
 * @author Integrantes do grupo
 *
 */
public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(int numero, double saldo, Pessoa cliente, TipoConta tipoConta) {
		super(numero, saldo, cliente, tipoConta);
	}

	public void saque(double valor) throws ContaException{
		if (valor < getSaldo()) {
			setSaldo(getSaldo() - valor);
		}else {
			throw new ContaException("Saldo insuficiente!");
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
