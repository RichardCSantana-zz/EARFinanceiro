/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import br.com.earfinanceiro.entidades.Grupo;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
public interface ISubgrupoNegocio {

	/**
	 * 
	 * Persiste um subgrupo
	 * 
	 * @param subgrupo
	 *            - {@link Subgrupo} a ser persistido
	 */
	public abstract void salva(Subgrupo subgrupo);

	/**
	 * 
	 * Exclui um subgrupo
	 * 
	 * @param subgrupo
	 *            - {@link Subgrupo} a ser excluido
	 */
	public abstract void exclui(Subgrupo subgrupo);

	/**
	 * 
	 * Retorna lista de subgrupos
	 * 
	 * @return {@link List} de {@link Subgrupo}
	 */
	public abstract List<Subgrupo> lista();

	/**
	 * 
	 * Retorna lista de grupos
	 * 
	 * @return {@link List} de {@link Grupo}
	 */
	public abstract List<Grupo> getGrupos();

	/**
	 * 
	 * Persiste um subgrupo
	 * 
	 * @param id
	 *            - Long que representa o id do subgrupo a ser encontrado
	 * @return {@link Subgrupo} referente ao id apresentado
	 */
	public abstract Subgrupo retorna(Long id);

	/**
	 * 
	 * Exclui um subgrupo
	 * 
	 * @param id
	 *            - Integer que representa o id do subgrupo a ser excluído
	 */
	public abstract void exclui(Long id);

}
