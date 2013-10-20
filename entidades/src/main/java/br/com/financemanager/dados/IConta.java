/**
 * 
 */
package br.com.financemanager.dados;

import java.util.Calendar;

import br.com.financemanager.exceptions.ErroCadastroException;

/**
 * @author Richard
 *
 */
public interface IConta {

	public abstract void efetiva(Calendar dataEfetivacao)
			throws ErroCadastroException;

	public abstract Double contabilizaValor();

}