/**
 * 
 */
package br.com.earfinanceiro.entidades;

import java.util.Calendar;

import br.com.earfinanceiro.exceptions.ErroCadastroException;

/**
 * @author Richard
 *
 */
public interface IConta {

	public abstract void efetiva(Calendar dataEfetivacao)
			throws ErroCadastroException;

	public abstract Double contabilizaValor();

}