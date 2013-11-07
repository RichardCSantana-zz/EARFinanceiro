/**
 * 
 */
package br.com.earfinanceiro.dao;

import java.util.List;

import br.com.earfinanceiro.entidades.AbstractConta;
import br.com.earfinanceiro.entidades.IConta;

/**
 * @author richard.santana
 * 
 */
public interface IContaDAO extends IAbstractContaDAO<AbstractConta> {

	/**
	 * 
	 * Retorna lista de contas não efetivas
	 * 
	 * @return {@link IConta} que não estão efetivas
	 */
	List<IConta> getContasNaoEfetivas();

}
