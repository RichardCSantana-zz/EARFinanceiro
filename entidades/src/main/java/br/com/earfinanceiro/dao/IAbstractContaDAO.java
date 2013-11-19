package br.com.earfinanceiro.dao;

import java.util.Calendar;
import java.util.List;

/**
 * @author Richard
 * 
 * @param <T>
 *            - Classe que definirá o tipo
 */
public interface IAbstractContaDAO<T> extends IDAO<T> {

	/**
	 * @param inicio
	 *            - {@link Calendar} que define a data inicial da pesquisa
	 * @param fim
	 *            - {@link Calendar} que define a data final da pesquisa
	 * @return {@link List} de <T> correspondente ao resultado da pesquisa
	 */
	public abstract List<T> geraListaPorDataEfetivacao(Calendar inicio,
			Calendar fim);

	/**
	 * 
	 * Retorna lista de contas não efetivas
	 * 
	 * @return T que não estão efetivas
	 */
	List<T> getNaoEfetivas();

}