/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import br.com.earfinanceiro.entidades.Entrada;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
public interface IEntradaNegocio {

	/**
	 * 
	 * Persiste uma entrada
	 * 
	 * @param entrada
	 *            - {@link Entrada} a ser persistida
	 */
	void salva(Entrada entrada);

	/**
	 * 
	 * Exclui uma entrada
	 * 
	 * @param entrada
	 *            - {@link Entrada} a ser excluída
	 */
	void excluir(Entrada entrada);

	/**
	 * 
	 * Retorna lista de subgrupos elegíveis para a entrada
	 * 
	 * @return {@link List} de {@link Subgrupo} - lista de subgrupos de entrada
	 */
	List<Subgrupo> getSubgrupos();

	/**
	 * 
	 * Retorna uma entrada referente ao id
	 * 
	 * @param id
	 *            - Long que representa o id da entrada a ser retornada
	 * @return {@link Entrada} referente ao id apresentado
	 */
	Entrada retorna(Long id);

	/**
	 * 
	 * Exclui um entrada
	 * 
	 * @param id
	 *            - Integer que representa o id da entrada a ser excluída
	 */
	void exclui(Long id);

}
