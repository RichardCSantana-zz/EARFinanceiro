/**
 * 
 */
package br.com.earfinanceiro.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.entidades.Grupo;

/**
 * @author Richard
 * 
 */
@Stateless
@Local
public class GrupoDAO extends AbstractDAO<Grupo> implements IGrupoDAO {

	/**
	 * @param classe
	 */
	public GrupoDAO() {
		super(Grupo.class);
	}

}
