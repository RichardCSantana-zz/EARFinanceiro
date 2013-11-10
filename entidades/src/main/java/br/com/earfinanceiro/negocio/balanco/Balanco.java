/**
 * 
 */
package br.com.earfinanceiro.negocio.balanco;

import java.util.Collections;
import java.util.List;

import br.com.earfinanceiro.entidades.IConta;

/**
 * @author richard.santana
 * 
 */
public class Balanco {

	private List<IConta> contas;

	/**
	 * 
	 * Retorna o total contabilizado pelo balanço
	 * 
	 * @return Double que indica o total do balanço
	 */
	public Double getTotal() {
		Double total = 0.0;
		for (IConta conta : this.contas) {
			total += conta.contabilizaValor();
		}
		return total;
	}

	/**
	 * 
	 * Adiciona ao balanco uma lista de contas
	 * 
	 * @param contas
	 *            - {@link List} de {@link IConta} pertencentes ao balanço
	 */
	public void setContas(List<IConta> contas) {
		this.contas = contas;
	}

	/**
	 * 
	 * Retorna lista de contas pertencentes ao balanço
	 * 
	 * @return {@link List} de {@link IConta} pertencentes ao balanço
	 */
	public List<IConta> getContas() {
		return Collections.unmodifiableList(this.contas);
	}

}
