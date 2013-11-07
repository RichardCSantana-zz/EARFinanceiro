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
	 * 
	 * Retorna um grupo de acordo com uma descrição
	 * 
	 * @param descricao
	 *            - String para busca por descrição
	 * @return {@link Grupo} - grupo referente a descrição
	 */
	public Grupo getPorNome(String descricao);

	/**
	 * 
	 * Retorna um grupo de acordo com um id
	 * 
	 * @param id
	 *            - Long para busca por id
	 * @return {@link Grupo} - grupo referente ao id
	 */
	public Grupo getPorId(Long id);

}
