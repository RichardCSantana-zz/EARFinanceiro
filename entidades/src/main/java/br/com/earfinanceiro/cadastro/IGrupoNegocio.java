/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import br.com.earfinanceiro.entidades.Grupo;
import br.com.earfinanceiro.entidades.TipoEnum;

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
	public abstract void salva(Grupo grupo);

	/**
	 * 
	 * Retorna um grupo referente ao id
	 * 
	 * @param id
	 *            - Long que representa o id do grupo a ser encontrado
	 * @return {@link Grupo} referente ao id apresentado
	 */
	Grupo retorna(Long id);

	/**
	 * 
	 * Exclui um grupo
	 * 
	 * @param grupo
	 *            - {@link Grupo} a ser excluído
	 */
	public abstract void exclui(Grupo grupo);

	/**
	 * 
	 * Exclui um grupo
	 * 
	 * @param id
	 *            - Integer que representa o id do grupo a ser excluído
	 */
	public abstract void exclui(Long id);

	/**
	 * 
	 * Retorna lista de grupos
	 * 
	 * @return {@link List} de {@link Grupo} - lista de grupos
	 */
	public abstract List<Grupo> lista();

	/**
	 * 
	 * Retorna lista de tipos
	 * 
	 * @return {@link List} de {@link TipoEnum}
	 */
	public abstract List<TipoEnum> listaTipos();

}