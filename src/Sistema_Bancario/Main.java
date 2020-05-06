package Sistema_Bancario;


/**
 * Classe principal para a execucao
 */
import Telas.TelaPrincipal;

public class Main {
	
	private static Pessoa []lista_pessoas;
	private static int qtd_pessoas = 0;
	
	private static Conta []lista_contas;
	private static int qtd_contas = 0;
	
	public static String nome;
	public static String tipoLogradouro;
	public static String logradouro;
	public static Integer numero;
	public static String bairro;
	public static String cidade;
	public static String estado;
	public static String cep;
	public static String cpf;
	public static String cnpj;
	public static String cargo;
	
	public static int num_conta;
	public static double saldo_conta;
	public static Pessoa cliente;
	public static TipoConta tipo_conta;
	public static int limite_conta;
	public static ContaPoupanca poupanca;
	
	private static TelaPrincipal tela;

	public static void main(String[] args) throws ContaException, PessoaException{
		PessoaFisica p1;
		//PessoaJuridica pj1;
		Conta c1;/*
		try {
			p1 = new PessoaFisica("Pedro", new Endereco("Residencial", "Logradouro", 100, "Bairro", "Cidade", "Estado", "CEP"), "01070600199");
			c1 = new ContaCorrente(001, 1000, p1, TipoConta.CONTA_CORRENTE, 500, new ContaPoupanca(001, 0, p1, TipoConta.CONTA_POUPANCA));
			//System.out.println(c1.toString());
			c1.saque(1600);
			System.out.println(c1.getSaldo());	
		} catch (PessoaException e) {
			System.out.println(e.getMessage());
		}*/
		
		tela = new TelaPrincipal();
		
		
	}

	public static void criarPF() throws PessoaException {
		lista_pessoas[qtd_pessoas] = new PessoaFisica(nome, new Endereco(tipoLogradouro, logradouro, numero, bairro, cidade, estado, cep), cpf);
	}
	
	public static void criarPJ() throws PessoaException {
		lista_pessoas[qtd_pessoas] = new PessoaJuridica(nome, new Endereco(tipoLogradouro, logradouro, numero, bairro, cidade, estado, cep), cnpj);
	}
	
	public static void criarFuncionario() throws PessoaException {
		lista_pessoas[qtd_pessoas] = new Funcionario(nome, new Endereco(tipoLogradouro, logradouro, numero, bairro, cidade, estado, cep), cpf, cargo);
	}
	
	public static void criarCC() throws ContaException {
		lista_contas[qtd_contas] = new ContaCorrente(num_conta, saldo_conta, cliente, tipo_conta, limite_conta, poupanca);
	}
	
	public static void criarPP() throws ContaException {
		lista_contas[qtd_contas] = new ContaPoupanca(num_conta, saldo_conta, cliente, tipo_conta);
	}

}
