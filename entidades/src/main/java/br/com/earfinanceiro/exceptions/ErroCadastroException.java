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
	 * @param string
	 */
	public ErroCadastroException(String string) {
		super(string);
	}

}
