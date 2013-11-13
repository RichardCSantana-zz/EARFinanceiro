/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.Calendar;
import java.util.List;

import br.com.earfinanceiro.entidades.IConta;

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
	 * @param contas
	 *            - {@link List} de {@link IConta} a serem efetivadas
	 * @param dataEfetivacao
	 *            - {@link Calendar} que representa a data de efetivação
	 */
	void efetiva(List<IConta> contas, Calendar dataEfetivacao);

}
