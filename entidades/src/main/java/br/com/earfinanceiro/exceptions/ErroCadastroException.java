/**
 * 
 */
package br.com.earfinanceiro.exceptions;

/**
 * @author Richard
 * 
 */
public class ErroCadastroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6518397903924312077L;

	/**
	 * 
	 * 
	 * 
	 * @param mensagem
	 *            - String que define a mensagem de erro retornada pela
	 *            Exception
	 */
	public ErroCadastroException(String mensagem) {
		super(mensagem);
	}

}
