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
	public abstract void salva(Entrada entrada);

	/**
	 * 
	 * Atualiza os dados de uma entrada já persistida
	 * 
	 * @param entrada
	 *            - {@link Entrada} a ser atualizada
	 */
	public abstract void atualiza(Entrada entrada);

	/**
	 * 
	 * Exclui uma entrada
	 * 
	 * @param entrada
	 *            - {@link Entrada} a ser excluída
	 */
	public abstract void excluir(Entrada entrada);

	/**
	 * 
	 * Retorna lista de subgrupos elegíveis para a entrada
	 * 
	 * @return {@link List} de {@link Subgrupo} - lista de subgrupos de entrada
	 */
	public abstract List<Subgrupo> getSubgrupos();

}
