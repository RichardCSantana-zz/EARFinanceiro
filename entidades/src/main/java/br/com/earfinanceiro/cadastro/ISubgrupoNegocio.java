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
	public abstract void salvaSubgrupo(Subgrupo subgrupo);

	/**
	 * 
	 * Atualiza um subgrupo
	 * 
	 * @param subgrupo
	 *            - {@link Subgrupo} a ser atualizado
	 */
	public abstract void atualizaSubgrupo(Subgrupo subgrupo);

	/**
	 * 
	 * Exclui um subgrupo
	 * 
	 * @param subgrupo
	 *            - {@link Subgrupo} a ser excluido
	 */
	public abstract void excluirsubSubgrupo(Subgrupo subgrupo);

	/**
	 * 
	 * Retorna lista de subgrupos
	 * 
	 * @return {@link List} de {@link Subgrupo}
	 */
	public abstract List<Subgrupo> listarSubgrupos();

	/**
	 * 
	 * Retorna lista de grupos
	 * 
	 * @return {@link List} de {@link Grupo}
	 */
	public abstract List<Grupo> getGrupos();

}
