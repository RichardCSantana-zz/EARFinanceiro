/**
 * 
 */
package br.com.earfinanceiro.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.entidades.AbstractConta;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class ContaDAO extends ContaAbstractDAO<AbstractConta> implements
		IContaDAO {

	public ContaDAO() {
		super(AbstractConta.class);
	}

}
