/**
 * 
 */
package br.com.earfinanceiro.dao;

import br.com.earfinanceiro.entidades.SubGrupo;

/**
 * @author Richard
 * 
 */
public class SubGrupoDAO extends AbstractDAO<SubGrupo> implements ISubGrupoDAO {

	/**
	 * @param classe
	 */
	protected SubGrupoDAO() {
		super(SubGrupo.class);
	}

}
