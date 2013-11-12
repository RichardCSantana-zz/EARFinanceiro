/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.Calendar;
import java.util.List;

import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.exceptions.ErroCadastroException;

/**
 * @author richard.santana
 * 
 */
public interface IContaNegocio {

	/**
	 * 
	 * Retorna contas que não estão com o status de efetivas
	 * 
	 * @return {@link List} de {@link IConta} que não estão com o status de
	 *         efetivas
	 */
	List<IConta> getContasNaoEfetivas();

	/**
	 * 
	 * Efetiva uma conta
	 * 
	 * @param conta
	 *            - {@link IConta} a ser efetivada
	 * @param dataEfetivacao
	 *            - {@link Calendar} que representa a data de efetivação
	 * @throws ErroCadastroException
	 *             - Quando a data de efetivação é inferior a data de cadastro
	 */
	void efetiva(List<IConta> contas, Calendar dataEfetivacao)
			throws ErroCadastroException;

}
