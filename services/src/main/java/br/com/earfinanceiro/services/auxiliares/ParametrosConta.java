/**
 * 
 */
package br.com.earfinanceiro.services.auxiliares;

import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.earfinanceiro.entidades.AbstractConta;
import br.com.earfinanceiro.entidades.IConta;

/**
 * @author Richard
 * 
 */
@XmlRootElement(name = "efetivas")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ParametrosConta {

	private Calendar dataEfetivar;
	private List<IConta> contas;

	/**
	 * 
	 * Retorna a data a efetivar
	 * 
	 * @return Calendar que representa a data efetivar
	 */
	@XmlElement(name = "dataInicial")
	public Calendar getDataEfetivar() {
		return this.dataEfetivar;
	}

	/**
	 * 
	 * Preenche a data a efetivar
	 * 
	 * @param dataEfetivar
	 *            - Calendar que representa a data a efetivar
	 * 
	 */
	public void setDataEfetivar(Calendar dataEfetivar) {
		this.dataEfetivar = dataEfetivar;
	}

	/**
	 * 
	 * Retorna a lista de contas
	 * 
	 * @return {@link List} de {@link IConta}
	 */
	@XmlElement(type = AbstractConta.class, name = "conta")
	public List<IConta> getContas() {
		return this.contas;
	}

	/**
	 * 
	 * Preenche a lista de contas
	 * 
	 * @param contas
	 *            - {@link List} de {@link IConta}
	 */
	public void setContas(List<IConta> contas) {
		this.contas = contas;
	}

}
