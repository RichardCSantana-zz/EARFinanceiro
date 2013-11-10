/**
 * 
 */
package br.com.earfinanceiro.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.entidades.Entrada;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class EntradaDAO extends ContaAbstractDAO<Entrada> implements
		IEntradaDAO {

	/**
	 * 
	 */
	public EntradaDAO() {
		super(Entrada.class);
	}

}
