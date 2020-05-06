package Sistema_Bancario;

import java.util.InputMismatchException;
/**
 * Classe responsavel por salvar as informa��es de Pessoa Juridica
 * @author Integrantes do grupo
 *
 */
public class PessoaJuridica extends Pessoa{
	protected static int geraid = 0;
	private String cnpj;
	
	public PessoaJuridica(String nome, Endereco endereco, String cnpj) throws PessoaException {
		super(nome, endereco);
		geraid++;
		this.id = gerarID();
		this.cnpj = cnpj;
		if(validaCNPJ() == false) {
			throw new PessoaException("CNPJ inv�lido!");
		}
	}

	protected String gerarID() {
		return "Pessoa Juridica - " + super.geraid + " , " +geraid;
	}
	
	/**
	 * Metodo responsavel por validar CNPF de pessoa juridica
	 * @return Boolean
	 */
	private boolean validaCNPJ() {
		// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
	    if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
	        cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
	        cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
	        cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
	        cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
	       (cnpj.length() != 14))
	       return(false);
	 
	    char dig13, dig14;
	    int sm, i, r, num, peso;
	 
	// "try" - protege o c�digo para eventuais erros de conversao de tipo (int)
	    try {
	// Calculo do 1o. Digito Verificador
	      sm = 0;
	      peso = 2;
	      for (i=11; i>=0; i--) {
	// converte o i-�simo caractere do CNPJ em um n�mero:
	// por exemplo, transforma o caractere '0' no inteiro 0
	// (48 eh a posi��o de '0' na tabela ASCII)
	        num = (int)(cnpj.charAt(i) - 48);
	        sm = sm + (num * peso);
	        peso = peso + 1;
	        if (peso == 10)
	           peso = 2;
	      }
	 
	      r = sm % 11;
	      if ((r == 0) || (r == 1))
	         dig13 = '0';
	      else dig13 = (char)((11-r) + 48);
	 
	// Calculo do 2o. Digito Verificador
	      sm = 0;
	      peso = 2;
	      for (i=12; i>=0; i--) {
	        num = (int)(cnpj.charAt(i)- 48);
	        sm = sm + (num * peso);
	        peso = peso + 1;
	        if (peso == 10)
	           peso = 2;
	      }
	 
	      r = sm % 11;
	      if ((r == 0) || (r == 1))
	         dig14 = '0';
	      else dig14 = (char)((11-r) + 48);
	 
	// Verifica se os d�gitos calculados conferem com os d�gitos informados.
	      if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
	         return(true);
	      else return(false);
	    } catch (InputMismatchException erro) {
	        return(false);
	    }
	}

	public String getCnpj() {
		return cnpj;
	}

	@Override
	public String toString() {
		return super.toString() + "PessoaJuridica \ncnpj = " + cnpj + "\n";
	}
	
	
}
