package br.com.earfinanceiro.negocio.balanco;

import java.util.Calendar;

/**
 * @author Richard
 * 
 */
public interface IBalancoBuilder {

	/**
	 * 
	 * Retorna um balanço
	 * 
	 * @param dataInicial
	 *            - {@link Calendar} que define o primeiro dia do balanço
	 * @param dataFinal
	 *            - {@link Calendar} que define o último dia do balanço
	 * @return um {@link Balanco} com a movimentação do período
	 * @throws IllegalArgumentException
	 *             - caso a data inicial seja posterior a data final
	 */
	public Balanco geraBalanco(Calendar dataInicial, Calendar dataFinal)
			throws IllegalArgumentException;

}