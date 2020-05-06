package Sistema_Bancario;


/**
 * 
 * @author Integrantes do grupo
 * Classe responsavel por salvar os dados da conta de Pessoa Fisica e Juridica
 */
public abstract class Conta {
	protected static int geranumero = 0;
	private int numero;
	private double saldo = 0;
	private Pessoa cliente;
	//private String tipoConta;
	private TipoConta tipoConta;
	
	public Conta(int numero, double saldo, Pessoa cliente, TipoConta tipoConta) {
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
		this.tipoConta = tipoConta;
		geranumero++;
	}

	protected int geraNumero() {
		return geranumero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void deposito(double valor) {
		setSaldo(valor + getSaldo());
	}

	public Pessoa getCliente() {
		return cliente;
	}
	
	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public abstract void saque(double valor) throws ContaException;

	@Override
	public String toString() {
		return "Conta \nnumero = " + numero + "\nsaldo = " + saldo + "\ncliente = " + cliente + "\ntipoConta = " + tipoConta
				+ "\n";
	}
}
