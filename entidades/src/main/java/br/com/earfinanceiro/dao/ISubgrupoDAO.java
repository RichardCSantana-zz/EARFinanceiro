/**
 * 
 */
package br.com.earfinanceiro.dao;

import java.util.List;

import br.com.earfinanceiro.entidades.Grupo;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
public interface ISubgrupoDAO extends IDAO<Subgrupo> {

	/**
	 * 
	 * Retorna um grupo de acordo com um id
	 * 
	 * @param id
	 *            - Long para busca por id
	 * @return {@link Grupo} - grupo referente ao id
	 */
	Subgrupo getPorId(Long id);

	/**
	 * Retorna lista de subgrupos elegíveis para a entrada
	 * 
	 * @return {@link List} de {@link Subgrupo} - lista de subgrupos de entrada
	 */
	List<Subgrupo> listaSubgruposEntrada();

	/**
	 * Retorna lista de subgrupos elegíveis para a saida
	 * 
	 * @return {@link List} de {@link Subgrupo} - lista de subgrupos de saida
	 */
	List<Subgrupo> listaSubgruposSaida();

}
