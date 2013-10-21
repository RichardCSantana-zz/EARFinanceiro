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

	protected Balanco() {

	}

	public Double getTotal() {
		Double total = 0.0;
		for (IConta conta : contas) {
			total += conta.contabilizaValor();
		}
		return total;
	}

	public void setContas(List<IConta> contas) {
		this.contas = contas;
	}

	public List<IConta> getContas() {
		return Collections.unmodifiableList(contas);
	}

}
