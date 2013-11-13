/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import br.com.earfinanceiro.entidades.Grupo;

/**
 * @author Richard
 * 
 */
public interface IGrupoNegocio {

	/**
	 * 
	 * Persiste um grupo
	 * 
	 * @param grupo
	 *            - {@link Grupo} a ser persistido
	 */
	public abstract void salvaGrupo(Grupo grupo);

	/**
	 * 
	 * Persiste um grupo
	 * 
	 * @param id
	 *            - Long que representa o id do grupo a ser encontrado
	 * @return {@link Grupo} referente ao id apresentado
	 */
	Grupo retornaGrupo(Long id);

	/**
	 * 
	 * Exclui um grupo
	 * 
	 * @param grupo
	 *            - {@link Grupo} a ser excluído
	 */
	public abstract void excluirGrupo(Grupo grupo);

	/**
	 * 
	 * Exclui um grupo
	 * 
	 * @param id
	 *            - Integer que representa o id do grupo a ser excluído
	 */
	public abstract void excluirGrupo(Long id);

	/**
	 * 
	 * Retorna lista de grupos
	 * 
	 * @return {@link List} de {@link Grupo} - lista de grupos
	 */
	public abstract List<Grupo> listarGrupos();

}