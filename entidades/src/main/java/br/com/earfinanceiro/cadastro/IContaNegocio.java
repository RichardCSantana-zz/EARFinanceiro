/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.Calendar;
import java.util.List;

import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.entidades.Parcela;

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
	List<Parcela> getParcelasNaoEfetivas();

	/**
	 * 
	 * Efetiva uma conta
	 * 
	 * @param parcelas
	 *            - {@link List} de {@link Parcela} a serem efetivadas
	 * @param dataEfetivacao
	 *            - {@link Calendar} que representa a data de efetivação
	 */
	void efetiva(List<Parcela> parcelas, Calendar dataEfetivacao);

}
