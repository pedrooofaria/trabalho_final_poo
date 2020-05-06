package Telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

import Sistema_Bancario.Main;
import Sistema_Bancario.PessoaException;
/**
 * Classe responsavel por gerar as telas do sistema bancario
 * @author Integrantes do grupo
 *
 */
public class TelaPrincipal implements Runnable {
	/**
	 * Containers, componentes e atributos para a construcao da interface grafica
	 * Panels, Labels e TextFields, Buttons e ActionListeners
	 */
	// Panels
	protected JFrame tela;
	public JPanel cabecalho;
	public JPanel principal;
	public JPanel padrao;
	public JPanel panelCaixaEletronico;
	public JPanel cadastrarConta;
	public JPanel cadastrarPF;
	public JPanel cadastrarPF2;
	public JPanel cadastrarPJ;
	public JPanel cadastrarPJ2;
	public JPanel cadastrarFuncionario;
	public JPanel cadastrarFuncionario2;
	public JPanel cadastrarPadrao;
	public JPanel menu;
	public JPanel rodape;
	// Labels
	public JLabel titulo;
	public JLabel labelBemVindo;
	public JLabel labelCaixaEletronico;
	public JLabel labelCadastrarConta;
	public JLabel labelcadastrarPF;
	public JLabel labelcadastrarPJ;
	public JLabel labelcadastrarFuncionario;
	public JLabel labelNome;
	public JLabel labelTipoLogradouro;
	public JLabel labelLogradouro;
	public JLabel labelNumero;
	public JLabel labelBairro;
	public JLabel labelCidade;
	public JLabel labelEstado;
	public JLabel labelCEP;
	public JLabel labelCPF;
	public JLabel labelCNPJ;
	public JLabel labelCargo;
	public JLabel creditos;
	public JLabel horario;
	// TextFields
	public JTextField fieldNome;
	public JTextField fieldTipoLogradouro;
	public JTextField fieldLogradouro;
	public JTextField fieldNumero;
	public JTextField fieldBairro;
	public JTextField fieldCidade;
	public JTextField fieldEstado;
	public JTextField fieldCEP;
	public JTextField fieldCPF;
	public JTextField fieldCNPJ;
	public JTextField fieldCargo;
	// Button
	public JButton caixaEletronico;
	public JButton cadastroConta;
	public JButton cadastroPF;
	public JButton cadastroPJ;
	public JButton cadastroFuncionario;
	public JButton buttonSalvarPF;
	public JButton buttonSalvarPJ;
	public JButton buttonSalvarFuncionario;
	// ActionListener
	private MudarTelaAction mudar;
	private SalvarPFAction salvarPFAction;
	private SalvarPJAction salvarPJAction;
	private SalvarFuncionarioAction salvarFuncionarioAction;
	// private SalvarContaAction salvarContaAction;
	// private BuscarContaAction buscarContaAction;
	
	/**
	 * Variaveis para hora, relogio do caixa eletronico
	 */
	// Variaveis para hora
	public int hora, min, seg;
	
	/**
	 * Construtor da classe
	 */
	public TelaPrincipal() {
		tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(1000, 500); // 1060, 520
		tela.setLocationRelativeTo(null); // Centraliza a Janela
		tela.setResizable(false);
		// tela.setLayout(new BorderLayout(50,50));
		tela.setLayout(null);

		cabecalho();
		menu();
		bemVindo();
		rodape();

		criarAction();

		Thread t = new Thread(this);
		t.start();

		tela.setVisible(true);
	}
	
	/**
	 * Metodo responsavel pelas mudancas de telas
	 * @author Integrantes do grupo
	 *
	 */
	private class MudarTelaAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// principal = padrao;
			if (e.getSource() == caixaEletronico) {
				caixaEletronico();
				/*
				 * principal.removeAll(); principal.add( panelCaixaEletronico );
				 * principal.revalidate(); principal.repaint();
				 */
			}
			if (e.getSource() == cadastroConta) {
				cadastrarConta();
				/*
				 * principal.removeAll(); principal.add( cadastrarConta );
				 * principal.revalidate(); principal.repaint();
				 */
			}

			if (e.getSource() == cadastroPF) {
				cadastrarPF();
				/*
				 * principal.removeAll(); principal.add( cadastrarPF ); principal.revalidate();
				 * principal.repaint();
				 */
			}
			if (e.getSource() == cadastroPJ) {
				cadastrarPJ();
				/*
				 * principal.removeAll(); principal.add( cadastrarPJ ); principal.revalidate();
				 * principal.repaint();
				 */
			}
			if (e.getSource() == cadastroFuncionario) {
				cadastrarFuncionario();
				/*
				 * principal.removeAll(); principal.add( cadastrarFuncionario );
				 * principal.revalidate(); principal.repaint();
				 */
			}
		}
	}
	
	/**
	 * Criar objetos do tipo ActionListener
	 */
	private void criarAction() {
		salvarPFAction = new SalvarPFAction();
		salvarPJAction = new SalvarPJAction();
		salvarFuncionarioAction = new SalvarFuncionarioAction();
		// salvarContaAction = new SalvarContaAction();
		// buscarContaAction = new BuscarContaAction();
	}
	
	/**
	 * Metodo responsavel por escutar o botao de salvar de pessoa fisica e realizar a troca de mensagens com a classe principal (Main)
	 * @author Integrantes do grupo
	 *
	 */
	private class SalvarPFAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			Main.nome = fieldNome.getText();
			Main.tipoLogradouro = fieldTipoLogradouro.getText();
			Main.logradouro = fieldLogradouro.getText();
			String aux = fieldNumero.getText();
			Main.numero = Integer.valueOf(aux);
			Main.bairro = fieldBairro.getText();
			Main.cidade = fieldCidade.getText();
			Main.estado = fieldEstado.getText();
			Main.cep = fieldCEP.getText();
			Main.cpf = fieldCPF.getText();

			try {
				Main.criarPF();
				JOptionPane.showMessageDialog(null, "O cadastro foi salvo.", "Cadastro", JOptionPane.PLAIN_MESSAGE);
			} catch (PessoaException e) {
				JOptionPane.showMessageDialog(null, "CPF invalido, Digite novamente", "CPF", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	/**
	 * Metodo responsavel por escutar o botao de salvar de pessoa juridica e realizar a troca de mensagens com a classe principal (Main)
	 * @author Integrantes do grupo
	 *
	 */
	private class SalvarPJAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			Main.nome = fieldNome.getText();
			Main.tipoLogradouro = fieldTipoLogradouro.getText();
			Main.logradouro = fieldLogradouro.getText();
			String aux = fieldNumero.getText();
			Main.numero = Integer.valueOf(aux);
			Main.bairro = fieldBairro.getText();
			Main.cidade = fieldCidade.getText();
			Main.estado = fieldEstado.getText();
			Main.cep = fieldCEP.getText();
			Main.cnpj = fieldCNPJ.getText();

			try {
				Main.criarPJ();
				JOptionPane.showMessageDialog(null, "O cadastro foi salvo.", "Cadastro", JOptionPane.PLAIN_MESSAGE);

			} catch (PessoaException e) {
				JOptionPane.showMessageDialog(null, "CNPJ invalido, Digite novamente", "CNPJ",
						JOptionPane.PLAIN_MESSAGE);
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo responsavel por escutar o botao de salvar de funcionario e realizar a troca de mensagens com a classe principal (Main)
	 * @author Integrantes do grupo
	 *
	 */
	private class SalvarFuncionarioAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			Main.nome = fieldNome.getText();
			Main.tipoLogradouro = fieldTipoLogradouro.getText();
			Main.logradouro = fieldLogradouro.getText();
			String aux = fieldNumero.getText();
			Main.numero = Integer.valueOf(aux);
			Main.bairro = fieldBairro.getText();
			Main.cidade = fieldCidade.getText();
			Main.estado = fieldEstado.getText();
			Main.cep = fieldCEP.getText();
			Main.cpf = fieldCPF.getText();
			Main.cargo = fieldCargo.getText();

			try {
				Main.criarPF();
				JOptionPane.showMessageDialog(null, "O cadastro foi salvo.", "Cadastro", JOptionPane.PLAIN_MESSAGE);

			} catch (PessoaException e) {
				JOptionPane.showMessageDialog(null, "CPF invalido, Digite novamente", "CPF", JOptionPane.PLAIN_MESSAGE);
				e.printStackTrace();
			}
		}
	}

	/*
	 * private class SalvarContaAction implements ActionListener{ // }
	 * 
	 * private class BuscarContaAction implements ActionListener{ // }
	 */
	
	/**
	 * Metodo responsavel por criar o JPanel cabecalho
	 */
	private void cabecalho() {
		cabecalho = new JPanel();
		// tela.add(cabecalho, BorderLayout.NORTH);
		tela.add(cabecalho);
		cabecalho.setBounds(0, 0, 1000, 80);
		cabecalho.setLayout(new GridLayout(1, 2));
		cabecalho.setBackground(Color.GRAY);

		titulo = new JLabel("Sistema Bancario");
		cabecalho.add(titulo);

		horario = new JLabel();
		cabecalho.add(horario);

	}
	
	/**
	 * Metodo responsavel por criar o JPanel menu
	 */
	private void menu() {
		menu = new JPanel();
		// tela.add(menu, BorderLayout.WEST);
		tela.add(menu);
		menu.setBounds(0, 80, 250, 340);
		menu.setLayout(new GridLayout(5, 1, 10, 10));
		menu.setBackground(Color.BLUE);

		caixaEletronico = new JButton("Caixa Eletronico");
		cadastroConta = new JButton("Cadastrar Conta");
		cadastroPF = new JButton("Cadastrar Pessoa Fisica");
		cadastroPJ = new JButton("Cadastrar Pessoa Juridica");
		cadastroFuncionario = new JButton("Cadastrar Funcionario");

		menu.add(caixaEletronico);
		menu.add(cadastroConta);
		menu.add(cadastroPF);
		menu.add(cadastroPJ);
		menu.add(cadastroFuncionario);

		mudar = new MudarTelaAction();

		caixaEletronico.addActionListener(mudar);
		cadastroConta.addActionListener(mudar);
		cadastroPF.addActionListener(mudar);
		cadastroPJ.addActionListener(mudar);
		cadastroFuncionario.addActionListener(mudar);

	}
	
	/**
	 * Metodo responsavel por criar o JPanel Bem vindo
	 */
	private void bemVindo() {
		padrao = new JPanel();
		tela.add(padrao);
		padrao.setBounds(250, 80, 750, 340);
		padrao.setLayout(new FlowLayout());
		padrao.setBackground(Color.WHITE);

		labelBemVindo = new JLabel("Bem vindo ao Programa Sistema Bancario");
		padrao.add(labelBemVindo, BorderLayout.CENTER);

	}

	/**
	 * Metodo responsavel por criar o JPanel caixa eletronico
	 */
	private void caixaEletronico() {
		panelCaixaEletronico = new JPanel();
		tela.add(panelCaixaEletronico);
		panelCaixaEletronico.setBounds(250, 80, 750, 340);
		panelCaixaEletronico.setLayout(new FlowLayout());
		panelCaixaEletronico.setBackground(Color.CYAN);

		labelCaixaEletronico = new JLabel("Caixa Eletronico");
		panelCaixaEletronico.add(labelCaixaEletronico, BorderLayout.CENTER);
	}
	
	/**
	 * Metodo responsavel por criar o JPanel cadastrar padrao
	 */
	private void cadastrarPadrao() {
		cadastrarPadrao = new JPanel();
		cadastrarPadrao.setLayout(new GridLayout(8, 2, 5, 5));

		labelNome = new JLabel("Nome: ");
		labelTipoLogradouro = new JLabel("Tipo Logradouro: ");
		labelLogradouro = new JLabel("Logradouro: ");
		labelNumero = new JLabel("Numero: ");
		labelBairro = new JLabel("Bairro: ");
		labelCidade = new JLabel("Cidade: ");
		labelEstado = new JLabel("Estado: ");
		labelCEP = new JLabel("CEP: ");

		fieldNome = new JTextField(30);
		fieldTipoLogradouro = new JTextField(30);
		fieldLogradouro = new JTextField(30);
		fieldNumero = new JTextField(30);
		fieldBairro = new JTextField(30);
		fieldCidade = new JTextField(30);
		fieldEstado = new JTextField(30);
		fieldCEP = new JTextField(30);

		cadastrarPadrao.add(labelNome);
		cadastrarPadrao.add(fieldNome);
		cadastrarPadrao.add(labelTipoLogradouro);
		cadastrarPadrao.add(fieldTipoLogradouro);
		cadastrarPadrao.add(labelLogradouro);
		cadastrarPadrao.add(fieldLogradouro);
		cadastrarPadrao.add(labelNumero);
		cadastrarPadrao.add(fieldNumero);
		cadastrarPadrao.add(labelBairro);
		cadastrarPadrao.add(fieldBairro);
		cadastrarPadrao.add(labelCidade);
		cadastrarPadrao.add(fieldCidade);
		cadastrarPadrao.add(labelEstado);
		cadastrarPadrao.add(fieldEstado);
		cadastrarPadrao.add(labelCEP);
		cadastrarPadrao.add(fieldCEP);
	}
	
	/**
	 * Metodo responsavel por criar o JPanel conta
	 */
	private void cadastrarConta() {
		cadastrarConta = new JPanel();
		tela.add(cadastrarConta);
		cadastrarConta.setBounds(250, 80, 750, 340);
		cadastrarConta.setLayout(new FlowLayout());
		cadastrarConta.setBackground(Color.WHITE);

		labelCadastrarConta = new JLabel("Cadastrar Conta");
		cadastrarConta.add(labelCadastrarConta);

	}
	
	/**
	 * Metodo responsavel por criar o JPanel cadastrar pessoa fisica
	 */
	private void cadastrarPF() {
		cadastrarPF = new JPanel();
		tela.add(cadastrarPF);
		cadastrarPF.setBounds(250, 80, 750, 340);
		// cadastrarPF.setLayout(null);
		// cadastrarPF.setBackground(Color.WHITE);

		labelcadastrarPF = new JLabel("Cadastrar Pessoa Fisica");
		cadastrarPF.add(labelcadastrarPF);

		cadastrarPadrao();
		cadastrarPF.add(cadastrarPadrao);

		cadastrarPF2 = new JPanel();
		cadastrarPF.add(cadastrarPF2);
		cadastrarPF2.setLayout(new GridLayout(1, 1, 5, 5));

		labelCPF = new JLabel("CPF: ");
		fieldCPF = new JTextField(30);
		buttonSalvarPF = new JButton("Salvar");
		buttonSalvarPF.addActionListener(salvarPFAction);

		cadastrarPF2.add(labelCPF);
		cadastrarPF2.add(fieldCPF);

		cadastrarPF.add(buttonSalvarPF);
	}

	/**
	 * Metodo responsavel por criar o JPanel cadastrar pessoa juridica
	 */
	private void cadastrarPJ() {
		cadastrarPJ = new JPanel();
		tela.add(cadastrarPJ);
		cadastrarPJ.setBounds(250, 80, 750, 340);
		// cadastrarPF.setLayout(null);

		labelcadastrarPJ = new JLabel("Cadastrar Pessoa Juridica");
		cadastrarPJ.add(labelcadastrarPJ);

		cadastrarPadrao();
		cadastrarPJ.add(cadastrarPadrao);

		cadastrarPJ2 = new JPanel();
		cadastrarPJ.add(cadastrarPJ2);
		cadastrarPJ2.setLayout(new GridLayout(1, 1, 5, 5));

		labelCNPJ = new JLabel("CNPJ: ");
		fieldCNPJ = new JTextField(30);
		buttonSalvarPJ = new JButton("Salvar");

		cadastrarPJ2.add(labelCNPJ);
		cadastrarPJ2.add(fieldCNPJ);

		cadastrarPJ.add(buttonSalvarPJ);
	}
	
	/**
	 * Metodo responsavel por criar o JPanel cadastrar funcionario
	 */
	private void cadastrarFuncionario() {
		cadastrarFuncionario = new JPanel();
		tela.add(cadastrarFuncionario);
		cadastrarFuncionario.setBounds(250, 80, 750, 340);
		// cadastrarPF.setLayout(null);
		// cadastrarPF.setBackground(Color.WHITE);

		labelcadastrarFuncionario = new JLabel("Cadastrar Funcionario");
		cadastrarFuncionario.add(labelcadastrarFuncionario);

		cadastrarPadrao();
		cadastrarFuncionario.add(cadastrarPadrao);

		cadastrarFuncionario2 = new JPanel();
		cadastrarFuncionario.add(cadastrarFuncionario2);
		cadastrarFuncionario2.setLayout(new GridLayout(2, 2, 5, 5));

		labelCPF = new JLabel("CPF: ");
		fieldCPF = new JTextField(30);
		labelCargo = new JLabel("Cargo: ");
		fieldCargo = new JTextField(30);
		buttonSalvarFuncionario = new JButton("Salvar");

		cadastrarFuncionario2.add(labelCPF);
		cadastrarFuncionario2.add(fieldCPF);
		cadastrarFuncionario2.add(labelCargo);
		cadastrarFuncionario2.add(fieldCargo);

		cadastrarFuncionario.add(buttonSalvarFuncionario);
	}

	/**
	 * Responsavel por iniciar a thread de relogio do caixa eletronico
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Date d = new Date();
			hora = d.getHours();
			min = d.getMinutes();
			seg = d.getSeconds();

			horario.setText(hora + ":" + min + ":" + seg);
		}
	}

	/**
	 * Informacoes do rodape
	 */
	private void rodape() {
		rodape = new JPanel();
		// tela.add(rodape, BorderLayout.SOUTH);
		tela.add(rodape);
		rodape.setBounds(0, 420, 1000, 80);
		rodape.setBackground(Color.GRAY);

		creditos = new JLabel(
				"Desenvolvido por Pedro Faria, Andre Soares, Victor Vidal, Vinicius Barreto, copyrights �");
		rodape.add(creditos);
	}
}
