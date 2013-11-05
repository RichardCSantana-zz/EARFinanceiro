/**
 * 
 */
package br.com.earfinanceiro.dao;

import br.com.earfinanceiro.entidades.Grupo;

/**
 * @author Richard
 * 
 */
public interface IGrupoDAO extends IDAO<Grupo> {

	/**
	 * @param arg2
	 * @return
	 */
	public Grupo getPorNome(String nome);

	/**
	 * @param arg2
	 * @return
	 */
	public Grupo getPorId(Long id);

}
