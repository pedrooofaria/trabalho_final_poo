package Sistema_Bancario;

/**
 * 
 * @author Integrantes do grupo
 * Classe responsavel pela excecao de conta
 *
 */
public class ContaException extends Exception {

	private String msg;

	public ContaException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
}
