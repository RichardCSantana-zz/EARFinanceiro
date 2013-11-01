/**
 * 
 */
package br.com.earfinanceiro.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.entidades.Saida;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class SaidaDAO extends ContaAbstractDAO<Saida> implements ISaidaDAO {

	public SaidaDAO() {
		super(Saida.class);
	}

}
