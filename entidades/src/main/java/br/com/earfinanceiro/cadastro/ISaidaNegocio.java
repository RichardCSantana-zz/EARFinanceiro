/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import br.com.earfinanceiro.entidades.Saida;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
public interface ISaidaNegocio {

	/**
	 * 
	 * Persiste uma saída
	 * 
	 * @param saida
	 *            - {@link Saida} a ser persistida
	 */
	public abstract void salva(Saida saida);

	/**
	 * 
	 * Exclui uma saída
	 * 
	 * @param saida
	 *            - {@link Saida} a ser excluída
	 */
	public abstract void excluir(Saida saida);

	/**
	 * 
	 * Retorna lista de subgrupos elegíveis para a saída
	 * 
	 * @return {@link List} de {@link Subgrupo}- lista de subgrupos de saida
	 */
	public abstract List<Subgrupo> getSubgrupos();

	/**
	 * 
	 * Retorna uma saida referente ao id
	 * 
	 * @param id
	 *            - Long que representa o id da saida a ser retornada
	 * @return {@link Saida} referente ao id apresentado
	 */
	Saida retorna(Long id);

	/**
	 * 
	 * Exclui um saida
	 * 
	 * @param id
	 *            - Integer que representa o id da saida a ser excluída
	 */
	void exclui(Long id);

}
