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
	 * Atualiza os dados de uma saida já persistida
	 * 
	 * @param saida
	 *            - {@link Saida} a ser atualizada
	 */
	public abstract void atualiza(Saida saida);

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

}
