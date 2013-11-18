/**
 * 
 */
package br.com.earfinanceiro.negocio.balanco;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.earfinanceiro.entidades.AbstractConta;
import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.entidades.Parcela;

/**
 * @author richard.santana
 * 
 */
@XmlRootElement(name = "balanco")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Balanco {

	private List<IConta> contas;

	/**
	 * 
	 * Retorna o total contabilizado pelo balanço
	 * 
	 * @return Double que indica o total do balanço
	 */
	@XmlElement(name = "total")
	public Double getTotal() {
		Double total = 0.0;
		for (IConta conta : this.contas) {
			for (Parcela parcela : conta.getParcelas()) {
				total += parcela.getContabilizaValor();
			}
		}
		return total;
	}

	/**
	 * 
	 * Retorna lista de contas pertencentes ao balanço
	 * 
	 * @return {@link List} de {@link IConta} pertencentes ao balanço
	 */
	@XmlElement(type = AbstractConta.class, name = "conta")
	public List<IConta> getContas() {
		return Collections.unmodifiableList(this.contas);
	}

	/**
	 * @param contas
	 *            the contas to set
	 */
	public void setContas(List<IConta> contas) {
		this.contas = contas;
	}

}
