/**
 * 
 */
package br.com.earfinanceiro;

import java.util.Collections;
import java.util.List;

import br.com.financemanager.entidades.IConta;

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
