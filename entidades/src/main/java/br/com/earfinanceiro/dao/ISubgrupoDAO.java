/**
 * 
 */
package br.com.earfinanceiro.dao;

import java.util.List;

import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
public interface ISubgrupoDAO extends IDAO<Subgrupo> {

	/**
	 * @param id
	 * @return
	 */
	Subgrupo getPorId(Long id);

	List<Subgrupo> listaSubgruposEntrada();

	List<Subgrupo> listaSubgruposSaida();

}
