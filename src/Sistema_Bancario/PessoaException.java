package Sistema_Bancario;
/**
 * Classe responsavel pela excecao de pessoa
 * @author Integrantes do grupo
 *
 */
public class PessoaException extends Exception{
	private String msg;

	public PessoaException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
	
}
